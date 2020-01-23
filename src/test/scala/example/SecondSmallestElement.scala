package example

class SecondSmallestElement extends Spec {

  "" in {

    val coll = List(2,3,4,7,5,1)

    var min1 = Integer.MAX_VALUE
    var min2 = Integer.MAX_VALUE

    for (el <- coll) {

      el match {
        case x if (x<min1) => min1=x
      }
    }


  }

}
