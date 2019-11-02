package example


class Hackerrank extends Spec {

  "sfjksjh" in {

    def staircase(n: Int) = {

      for (i <- 1 to n) {
        println(createString(" ", n-i) + createString("#", i))
      }

    }

    def createString(p: String, n: Int) = {

      val seq = for (_ <- 1 to n) yield p
      seq.foldLeft("") {
        (acc, curr) => acc+curr
      }
    }

    println
    println(createString(" ", 5))
    println(createString("#", 1))
    println
    staircase(6)


  }


}
