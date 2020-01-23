package example

class SecondSmallestElement extends Spec {

  "its a fold!!! G Research Arrgh" in {

    val coll = List(2,3,4,7,5,1)

    def sndSmallest(coll: List[Int]) = {

      val twos: (Int, Int) = (Integer.MAX_VALUE, Integer.MAX_VALUE)

      coll.foldLeft(twos) {
        case ((min1, min2), el) => {
          el match {
            case x if (x < min1) => (x, min1)
            case x if (x < min2) => (min1, x)
            case _ => (min1, min2)
          }

        }
      }

    }

    sndSmallest(coll) shouldBe (1,2)


  }

}
