package example

import scala.collection.mutable.ListBuffer


class Hackerrank extends Spec {

  "sfjksjh" in {

    def fourSumCount(A: List[Int], B: List[Int], C: List[Int], D: List[Int]): Int = {

      val n = A.size - 1
      var cnt = 0

      val absums = ListBuffer.empty[Int]

      for (i <- 0 to n)
        for (j <- 0 to n) {
          absums.+=(A(i)+B(j))
        }
      val cdsums = ListBuffer.empty[Int]

      for (i <- 0 to n)
        for (j <- 0 to n) {
          cdsums.+=(C(i)+D(j))
        }

      for (abs <- absums) {
        for (cds <- cdsums) {
          if (abs+cds==0) cnt = cnt+1
        }
      }

      cnt
    }

    val A = List(1, 2)
    val B = List(-2, -1)
    val C = List(-1, 2)
    val D = List(0, 2)


    println(fourSumCount(A,B,C,D))

  }

}
