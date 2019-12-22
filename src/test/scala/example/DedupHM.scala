package example

import scala.collection.mutable

class DedupHM extends Spec {


  "" in {

    val list = List(1,2,3,3,1,5,6,7,3)


    val set = new mutable.HashSet[Int]()


    for (el <- list) {
      if (!set.contains(el)) {
        set.add(el)
      }
    }

    println(set.toList)
  }
}
