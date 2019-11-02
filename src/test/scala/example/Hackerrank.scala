package example


class Hackerrank extends Spec {

  "sfjksjh" in {

    def minmaxSum(n: List[Int]) = {


      val sums = for (i <- 0 to 4) yield n.sum - n(i)

      println(sums.min)
      println(sums.max)




    }


    minmaxSum(List(1,3,5,7,9))

  }


}
