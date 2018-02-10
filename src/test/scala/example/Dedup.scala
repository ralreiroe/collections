package example

class Dedup extends Spec {

  "groupBy f:A->B, el becomes key, f(el) is added to value" in {

    Seq(3,1,4,1).groupBy(identity) shouldBe Map(4 -> List(4), 1 -> List(1, 1), 3 -> List(3))
    Seq(1,1,3,4).groupBy(identity).keys shouldBe Set(4, 1, 3)
  }

  "dedup with preserving order" in {

    def dedupPreservingOrder(ints: Seq[Int]): Seq[Int] = {
      val s = scala.collection.mutable.HashSet.empty[Int]
      ints.foldLeft(Seq.empty[Int]) {
        case (acc, curr) => {
          if (!s.apply(curr)) {
            s.+=(curr)
            curr +: acc
          } else acc
        }
      }.reverse
    }

    dedupPreservingOrder(Seq(8, 8, 3, 1, 4, 1)) shouldBe Seq(8, 3,1,4)
  }

}
