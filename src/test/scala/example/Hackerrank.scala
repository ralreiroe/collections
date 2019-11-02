package example


class Hackerrank extends Spec {

  "sfjksjh" in {

    def props(a: List[Int]) = {

      val pos = a.filter(_>0).size * 1.0/a.size
      val neg = a.filter(_<0).size * 1.0/a.size
      val zeros = a.filter(_==0).size * 1.0/a.size

      println(pos)
      println(neg)
      println(zeros)
    }

    props(Array(1,2,3, -1, 0).toList)

  }


}
