package example

import scala.annotation.tailrec

class TailrecReverse extends Spec {
  "reverse and reverse tailrec" in {

    def reverse[A](list: List[A]): List[A] = {
      list match {
        case h :: t => reverse(t) ::: List(h)                   //(*)
        case Nil => Nil
      }
    }

    @tailrec
    def reversetr[A](resultsofar: List[A], remainder: List[A]): List[A] = {
      remainder match {
        case h :: t => reversetr(h :: resultsofar, t)           //(*')
        case Nil => resultsofar                                 //(**)
      }
    }

    reverse(List(1, 2, 2, 2, 3)) shouldBe List(3, 2, 2, 2, 1)
    reversetr(List(), List(1, 2, 2, 2, 3)) shouldBe List(3, 2, 2, 2, 1)

    /**
      * (*) doing the thing *after* the recursive call
      * (*') doing the thing *before* the recursive call
      * (**): In the last call to reverstr, the argument equals the return value
      */
  }

  "reverse iterative version" in {
    def reversefoldleft[A](list: List[A]) = {
      list.foldLeft(List[A]()) {
        (acc, curr) => curr :: acc
      }
    }

    reversefoldleft(List(1, 2, 2, 2, 3)) shouldBe List(3, 2, 2, 2, 1)

    }
}
