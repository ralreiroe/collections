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
        case h :: t => reversetr(resultsofar ::: List(h), t)    //(*')
        case Nil => resultsofar                                 //(**)
      }
    }

    println(reverse(List(1, 2, 2, 2, 3)))
    println(reversetr(List(), List(1, 2, 2, 2, 3)))

    /**
      * (*) doing the thing *after* the recursive call
      * (*') doing the thing *before* the recursive call
      * (**): In the last call to reverstr, the argument equals the return value
      */


  }
}
