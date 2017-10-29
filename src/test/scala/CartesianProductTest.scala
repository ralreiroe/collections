import org.scalatest.{FlatSpec, Matchers}

class CartesianProductTest extends FlatSpec with Matchers {
  "Hello" should "have tests" in {


    /**
      * List( List(, ), List(, ), List(, ) )
      * @param inp
      */
    def cartesianProduct(inp: List[List[Int]]): List[List[Int]] = {

      inp match {
        case Nil => List(Nil)
        case (h :: t) => {

          for (x <- h; y <- cartesianProduct(t)) yield {
            x :: y
          }
        }
      }
    }

    val threeLists = List(List(1, 2), List(3, 4), List(5, 6))

    cartesianProduct(threeLists) shouldBe (
      for {
        x <- threeLists.head
        y <- cartesianProduct(threeLists.tail)
      } yield x :: y)



    cartesianProduct(List(List(1)))
    println(cartesianProduct(Nil))
  }
}




