package example


class Hackerrank extends Spec {

  "sfjksjh" in {

    def candleBlow(heights: List[Int]) = {


      heights.filter(_==heights.max).size

    }


    val highestCandles = candleBlow(List(3,3,1,2))
    println(highestCandles)

  }


}
