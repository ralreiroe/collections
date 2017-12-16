package example

class TakeTillThreshold extends Spec {

  "take a subset of a list such that the sum of the elements in the result does not pass a threshold" in {

    var sum=0
    val threshold = 3
    val result = List(1,1,0,0,1,1).takeWhile {
      case el => {
        sum = sum + el
        sum <= threshold
      }
    }

    println(result)

  }

  "without var" in {

    val threshold = 3


    val result = List(1, 1, 0, 0, 1, 1).foldLeft(List(0)) {
      case (acc, el) => {
        val newEl = acc.last + el
        acc ::: List(newEl)
      }
    }

    result.tail shouldBe List(1, 2, 2, 2, 3, 4)

    val result2 = List(1, 1, 0, 0, 1, 1).zip(result.tail) takeWhile {
      case (l,r) => {
        r <= threshold
      }
    }

    result2.map(_._1) shouldBe List(1, 1, 0, 0, 1)


  }


  "scanLeft" in {

    List(1, 1, 0, 0, 1, 1).scanLeft(0)(_+_) shouldBe List(0, 1, 2, 2, 2, 3, 4)



  }



}
