package example

class SecondSmallestElement extends Spec {

  "" in {

    val coll = List(2,3,4,7,5,1)

    def sndSmallest(coll: List[Int]) = {
      var min1 = Integer.MAX_VALUE
      var min2 = Integer.MAX_VALUE

      for (el <- coll) {

        el match {
          case x if (x < min1) => min1 = x
          case x if (x < min2) => min2 = x
          case _ =>
        }
      }

      min2
    }

    println(sndSmallest(coll))


  }

}
