package example


class Hackerrank extends Spec {

  "sfjksjh" in {

    def fourSumCount(A: List[Int], B: List[Int], C: List[Int], D: List[Int]): Int = {

      val n = A.size - 1
      var cnt = 0

      for (i <- 0 to n)
        for (j <- 0 to n) {
          val ir = A(i)+B(j)
          for (k <- 0 to n) {
            val ir2 = ir+C(k)
            for (l <- 0 to n) {
              if (ir2 + D(l) == 0) cnt = cnt + 1
            }

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
