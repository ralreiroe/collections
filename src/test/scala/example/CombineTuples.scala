package example

class CombineTuples extends Spec {

  "combine tuples using a map" in {

    val s1: Set[(Int, Int)] = Set((1, 2), (1, 3), (2, 4), (2, 5))

    def fold1(s: Set[(Int, Int)]): Set[(Int, Int)] = s.foldLeft(Map.empty[Int, Int]) {
      case (acc, curr: (Int, Int)) => {
        acc.get(curr._1) match {
          case None => acc + (curr._1 -> curr._2)
          case Some(r) => acc + (curr._1 -> (acc.get(curr._1).get + curr._2))
        }
      }
    }.toSet

    fold1(s1) shouldBe Set((1,5), (2,9))

  }
}
