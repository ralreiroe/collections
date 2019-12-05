package example

import scala.annotation.tailrec

class TailrecRemoveDupsFromSorted extends Spec {
  "remove dups from sorted recursive and tailrec" in {

    def rdfs[Int](xs: List[Int]): List[Int] = {
      xs match {
        case Nil => Nil
        case h :: t => _rdfs(List(h), t)
      }
    }

    @tailrec
    def _rdfs[Int](resr: List[Int], xs: List[Int]): List[Int] = {
      assert(resr.nonEmpty)

      xs match {
        case Nil => resr.reverse
        case h :: t if resr.head != h => _rdfs(h :: resr, t)
        case h :: t => _rdfs(resr, t)
      }
    }

    rdfs(List(1)) shouldBe List(1)
    rdfs(List(1, 1)) shouldBe List(1)
    rdfs(List(1, 2)) shouldBe List(1, 2)


    rdfs(List(1, 2, 2, 2, 3)) shouldBe List(1, 2, 3)

    _rdfs(List(2, 1), List(2, 3)) shouldBe List(1, 2, 3)


    _rdfs(List(2, 1), List(3)) shouldBe List(1, 2, 3)
    _rdfs(List(2, 1), List(2)) shouldBe List(1, 2)
  }


  "dropEvery3rdEl recursive iterative" in {

    def dropEvery3rdEl[A](list: List[A]): List[A] = {
      list match {
        case Nil => Nil
        case _ => list.take(2) ::: dropEvery3rdEl(list.drop(3))
      }
    }

    dropEvery3rdEl(List(1, 2, 3, 4, 5, 6, 7, 8, 9)) shouldBe List(1, 2, 4, 5, 7, 8)

    def dropEvery3rdEltr[A](res: List[A], list: List[A]): List[A] = {

      list match {
        case Nil => res
        case _ => dropEvery3rdEltr(res ::: list.take(2), list.drop(3))
      }
    }

    dropEvery3rdEltr(Nil, List(1, 2, 3, 4, 5, 6, 7, 8, 9)) shouldBe List(1, 2, 4, 5, 7, 8)

    dropEvery3rdEl(List(1)) shouldBe List(1)
    dropEvery3rdEl(List(1, 2)) shouldBe List(1, 2)
    dropEvery3rdEl(List(1, 2, 3)) shouldBe List(1, 2)


    def dropEvery3rdElit[A](list: List[A]): List[A] = {
      var j = 0

      list.foldLeft(List[A]()) {
        (acc, curr) => {
          j = j + 1
          if (j % 3 != 0) {
            curr :: acc
          } else {
            acc
          }
        }
      }.reverse
    }

    println(1 :: List(2))

    dropEvery3rdElit(List(1)) shouldBe List(1)
    dropEvery3rdElit(List(1, 2)) shouldBe List(1, 2)
    dropEvery3rdElit(List(1, 2, 3)) shouldBe List(1, 2)
    dropEvery3rdElit(List(1, 2, 3, 4, 5, 6, 7, 8, 9)) shouldBe List(1, 2, 4, 5, 7, 8)


    def dropEvery3rdElmap[A](list: List[A]): List[A] = {

      list.grouped(3).flatMap {
        case g => g.take(2)
      }.toList

    }

    dropEvery3rdElmap(List(1, 2, 3, 4, 5, 6, 7, 8, 9)) shouldBe List(1, 2, 4, 5, 7, 8)

    }

}
