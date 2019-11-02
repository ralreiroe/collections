package example


class Hackerrank extends Spec {

  "sfjksjh" in {

    def staircase(n: Int) = {

      for (i <- 1 to n) {
        println(createString(" ", n-i) + createString("#", i))
      }

    }

    def createString(p: String, n: Int): String = {
      if (n<=0) return ""
      p + createString(p, n-1)
    }

    println
    println(createString("x", 5))
    println
    staircase(6)


  }


}
