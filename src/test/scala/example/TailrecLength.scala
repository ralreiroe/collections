package example

import scala.annotation.tailrec

class TailrecLength extends Spec {
  "length and length tailrec" in {

    def length[A](xs: List[A]): Int = {
      xs match {
        case Nil => 0
        case h :: t => 1 + length(t)
      }
    }

    @tailrec
    def lengthtr[A](res: Int, xs: List[A]): Int = {

      xs match {
        case Nil => res
        case h :: t => lengthtr(res + 1, t)
      }
    }

    length(List(13,4,5,1,6)) shouldBe 5
    lengthtr(0, List(13,4,5,1,6)) shouldBe 5

  }

}
