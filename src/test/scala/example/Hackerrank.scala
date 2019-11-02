package example


class Hackerrank extends Spec {

  "sfjksjh" in {

    def minmaxSum(n: List[Int]) = {


      val sums = for (i <- 0 to 4) yield n.sum - n(i)

      println(sums.max)


      val min = sums.reduce {
        (acc,curr) => Math.min(acc,curr)
      }

      println(min)

    }


    minmaxSum(List(1,3,5,7,9))

  }


}
