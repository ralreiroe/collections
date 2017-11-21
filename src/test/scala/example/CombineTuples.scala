package example

class CombineTuples extends Spec {

  "combine tuples using a map" in {

    val s1: Set[(Int, Int)] = Set((1, 2), (1, 3), (2, 4), (2, 5))

    def fold1(s: Set[(Int, Int)]): Set[(Int, Int)] = s.foldLeft(Map.empty[Int, Int]) {
      case (acc, (left,right)) => {
        acc.get(left) match {
          case None => acc + (left -> right)
          case Some(r) => acc + (left -> (acc.get(left).get + right))
        }
      }
    }.toSet

    fold1(s1) shouldBe Set((1,5), (2,9))

  }
}
