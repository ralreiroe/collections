package example

import scala.collection.mutable

class DedupHM extends Spec {


  "" in {

    val list = List(1,2,3,3,1,5,6,7,3)


    val set = new mutable.HashSet[Int]()

    list.map(set.add(_))

    println(set.toList)
  }
}
