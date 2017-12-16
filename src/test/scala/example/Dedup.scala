package example

class Dedup extends Spec {

  "groupBy f:A->B, el becomes key, f(el) is added to value" in {

    Seq(1,1,3,4).groupBy(identity) shouldBe Map(4 -> List(4), 1 -> List(1, 1), 3 -> List(3))
    println(Seq(1,1,3,4).groupBy(identity).keys)


  }

}
