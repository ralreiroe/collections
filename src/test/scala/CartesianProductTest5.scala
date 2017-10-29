import org.scalatest.{FlatSpec, Matchers}

class CartesianProductTest5 extends FlatSpec with Matchers {
  "Hello" should "have tests" in {

    println ( List("A", "B").flatMap(s => List("C", "D").map(s1 => s+s1)) )

    val f = (s: String) => List("C", "D").map(s1 => s+s1)



    def cartesianProduct(inp: List[List[String]]): List[String] = inp match {

      case h :: Nil => h
      case Nil => Nil
      case h :: t if t.size==1 => {
        for (x <- h; y <- t.head) yield x + y
      }
      case h :: t => {
        for (x <- h; y <- cartesianProduct(t)) yield x + y
      }
    }

    println(cartesianProduct(List(List("A", "B"), List("C", "D"), List("E", "F"))))
    println(cartesianProduct(List(List("A", "B"), List("C", "D"))))
    println(cartesianProduct(List()))
    println(cartesianProduct(List(List("A", "B"))))
  }
}




