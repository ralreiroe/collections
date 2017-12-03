package example

import play.api.libs.json._

import scala.util.Sorting

class OrderingTest extends Spec {

  "sort tuples" in {

    import scala.util.Sorting
    val pairs = Array(("a", 5, 2), ("c", 3, 1), ("b", 1, 3))

    // sort by 2nd element
    Sorting.quickSort(pairs)(Ordering.by[(String, Int, Int), Int](_._2))

    pairs foreach println

    // sort by the 3rd element, then 1st
    Sorting.quickSort(pairs)(Ordering[(Int, String)].on(x => (x._3, x._1)))

    pairs foreach println
  }

  "sort persons" in {

    import scala.util.Sorting

    case class Person(name: String, age: Int)
    val people = Array(Person("bob", 30), Person("ann", 32), Person("carl", 19))

    // sort by age
    object AgeOrdering extends Ordering[Person] {
      def compare(a: Person, b: Person) = a.age compare b.age
    }
    Sorting.quickSort(people)(AgeOrdering)

    people foreach println
  }

  "sort JsValues" in {

    val jsonOrdering: Ordering[JsValue] = new Ordering[JsValue]() {

      override def compare(x: JsValue, y: JsValue): Int = {

        x.getClass.getName.compareTo(y.getClass.getName) match {
          case 0 =>
            (x, y) match {
              case (JsNull, JsNull) => 0
              case (JsString(valueX), JsString(valueY)) =>
                valueX.compareTo(valueY)
              case (JsNumber(valueX), JsNumber(valueY)) =>
                valueX.compare(valueY)
              case (JsBoolean(boolX), JsBoolean(boolY)) =>
                boolX.compareTo(boolY)
              case (JsArray(elementsX), JsArray(elementsY)) =>
                elementsX.size.compareTo(elementsY.size) match {
                  case 0 =>
                    elementsX
                      //                      .sorted(this) // uncomment if array order DOES NOT matter
                      .zip(elementsY
                      //                        .sorted(this) // uncomment if array order DOES NOT matter
                    )
                      .view
                      .map {
                        case (elementX, elementY) => compare(elementX, elementY)
                      }
                      .find(_ != 0)
                      .getOrElse(0)
                  case nonZero => nonZero
                }
              case (JsObject(fieldsX), JsObject(fieldsY)) =>
                fieldsX.size.compareTo(fieldsY.size) match {
                  case 0 =>
                    fieldsX.toSeq
                      .sortBy(_._1)
                      .zip(fieldsY.toSeq.sortBy(_._1))
                      .view
                      .flatMap {
                        case ((keyX, valueX), (keyY, valueY)) =>
                          Seq(keyX.compareTo(keyY), compare(valueX, valueY))
                      }
                      .find(_ != 0)
                      .getOrElse(0)
                  case nonZero => nonZero
                }
            }
          case nonZero => nonZero
        }
      }
    }


    val jsobjects = Json.parse(
      """{
        | "a":[2,1],
        | "b":[
        |   {"c":[3,2]},
        |   {"d":[4,3]}
        | ],
        | "e":{
        |   "f":[5,4]
        |   }
        |}""".stripMargin)


    val j1 = Json.parse("""[
                 |   {"c":[3,2]},
                 |   {"d":[4,3]}
                 | ]""".stripMargin)

    val r1 = jsonOrdering.compare(j1, j1)
    println(r1)

    val j2 = Json.parse("""[
                          |   {"c":[3,2]},
                          |   {"d":[4,1]}
                          | ]""".stripMargin)

    val r2 = jsonOrdering.compare(j1, j2)
    println(r2)
    r2 shouldBe 1
  }

  "json equality for array" in {

    val j1 = Json.parse("""[
                          |   {"c":[3,2]},
                          |   {"d":[4,3]}
                          | ]""".stripMargin)
    val j1reversed = Json.parse("""[
                          |   {"d":[4,3]},
                          |   {"c":[3,2]}
                          | ]""".stripMargin)

    println(j1==j1reversed)
    val t = j1.asInstanceOf[JsArray]
  }




}
