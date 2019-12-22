package example

import scala.collection.mutable

class DedupHM extends Spec {


  "dedup preserving order" in {

    val list = List(1,2,3,3,1,5,6,7,3)

    val set = new mutable.HashSet[Int]()

    val reslist = mutable.ListBuffer.empty[Int]

    for (el <- list) {

      if (!set.contains(el)) {
        set.+=(el)
        reslist.+=(el)
      }

    }

    reslist shouldBe mutable.ListBuffer(1, 2, 3, 5, 6, 7)

  }
}
