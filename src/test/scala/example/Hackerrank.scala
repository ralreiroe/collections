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
      val cdsumToCnt = mutable.Map.empty[Int,Int]

      for (i <- 0 to n)
        for (j <- 0 to n) {
          val sum = C(i)+D(j)
          cdsumToCnt.+=(
            (sum, cdsumToCnt.getOrElse(sum, 0)+1))
        }

      for (abs <- absumToCnt.keys) {
        for (cds <- cdsumToCnt.keys) {
          if (abs+cds==0) cnt = cnt+(absumToCnt(abs)*cdsumToCnt(cds))
        }
      }

      println(absumToCnt)
      println(cdsumToCnt)

      cnt
    }

    val A = List(1, 2)
    val B = List(-2, -1)
    val C = List(-1, 2)
    val D = List(0, 2)


    println(fourSumCount(A,B,C,D))

  }

}
