package example


class Hackerrank extends Spec {

  "sfjksjh" in {

    def candleBlow(heights: List[Int]) = {


      heights.count(_ == heights.max)

    }


    val highestCandles = candleBlow(List(3,3,1,2))
    println(highestCandles)

  }


}
