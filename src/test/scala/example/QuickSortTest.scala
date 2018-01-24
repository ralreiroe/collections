package example

import org.scalatest._

class QuickSortTest extends FlatSpec with Matchers {
  "Hello" should "have tests" in {


    def quicksort(l: List[Int]): List[Int] = {

      l match {
        case h :: t => quicksort(t.filter(_ < h)) ::: List(h) ::: quicksort(t.filter(_ >= h))
        case _ => l
      }
    }

    def quicksort2[T](l: List[T])(implicit o: Ordering[T]): List[T] = {

      l match {
        case h :: t => quicksort2(t.filter(a => o.lt(a, h))) ::: List(h) ::: quicksort2(t.filter(a => o.gteq(a, h)))
        case _ => l
      }
    }


    println(quicksort(List(3, 5, 1, 7, 2, 10, 2, 9, 8)))
    println(quicksort2(List(3, 5, 1, 7, 2, 10, 2, 9, 8)))

  }
}





