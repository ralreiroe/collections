package example

class CombineTuples extends Spec {

  "combine tuples using a map explicitely" in {

    val s1: Set[(Int, Int)] = Set((1, 2), (1, 3), (2, 4), (2, 5))

    def fold1(s: Set[(Int, Int)]): Set[(Int, Int)] = s.foldLeft(Map.empty[Int, Int]) {
      case (acc, (left,right)) => {
        acc.get(left) match {
          case None => acc + (left -> right)
          case Some(r) => acc + (left -> (r + right))
        }
      }
    }.toSet

    fold1(s1) shouldBe Set((1,5), (2,9))

  }

  "combine tuples using a map implicitely" in {

    val s1: Set[(Int, Int)] = Set((1, 2), (1, 3), (2, 4), (2, 5))

    def fold1(s: Set[(Int, Int)]): Set[(Int, Int)] = {

      val f: ((Int,Int)) => Int = { case ((a,b)) => a}
      s.groupBy(f).map {
        case (int, setofintint) => (int, setofintint.map(_._2).reduce(_+_))
      }.toSet

    }

    fold1(s1) shouldBe Set((1,5), (2,9))

  }

}
