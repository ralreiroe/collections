package example

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


class Hackerrank extends Spec {

  "sfjksjh" in {

    def fourSumCount(A: List[Int], B: List[Int], C: List[Int], D: List[Int]): Int = {

      val n = A.size - 1
      var cnt = 0

      val absumToCnt = mutable.Map.empty[Int,Int]

      for (i <- 0 to n)
        for (j <- 0 to n) {
          val sum = A(i)+B(j)
          absumToCnt.+=(
            (sum, absumToCnt.getOrElse(sum, 0)+1))
        }
      for (i <- 0 to n)
        for (j <- 0 to n) {
          val sum = C(i)+D(j)
          if (absumToCnt.isDefinedAt(-sum)) cnt = cnt+absumToCnt(-sum)
        }

      cnt
    }

    var A = List(1, 2)
    var B = List(-2, -1)
    var C = List(-1, 2)
    var D = List(0, 2)

    println(fourSumCount(A,B,C,D))

    A = List(-1, -1)
    B = List(-1, 1)
    C = List(-1, 1)
    D = List(1, -1)

    println(fourSumCount(A,B,C,D))
  }

}
