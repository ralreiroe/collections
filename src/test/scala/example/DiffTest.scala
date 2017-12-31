package example

import scala.annotation.tailrec

class DiffTest extends Spec {
  "Find matching pairs in two sorted lists" in {

    def matchingPairs(l1: List[Int], l2: List[Int]): List[(Int, Int)] = matchingPairs0(l1, l2, List.empty[(Int, Int)])

    @tailrec
    def matchingPairs0(l1: List[Int], l2: List[Int], pairs: List[(Int, Int)]): List[(Int, Int)] = {

      if (!(l1.isEmpty || l2.isEmpty)) {
        if (l1.head==l2.head) {
          matchingPairs0(l1.tail, l2.tail, (l1.head, l2.head) :: pairs)
        } else {
          if(l1.head<l2.head) matchingPairs0(l1.tail, l2, pairs) else matchingPairs0(l1, l2.tail, pairs)
        }
      } else pairs.reverse
    }

    val list1 = List(1, 2, 3)
    val list2 = List(1, 3, 4)
    matchingPairs(list1, list2) shouldBe List((1,1), (3,3))

  }
}




