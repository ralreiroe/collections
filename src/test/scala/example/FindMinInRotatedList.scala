package example
import scala.collection.immutable

class FindMinInRotatedList extends Spec {

  "FindMinInRotatedList in O(log n) using binary search" in {

    val ints = List(5,6,1,2,3,4)    //
    val ints2 = List(3,4,5,6,1,2)   //rotating point in right half. right on right half (2) cannot be bigger than right of left half (5)
    val ints3 = List(1,2,3,4,5,6)   //rotating point in left half

    val int3 = List(5,3,4)    //mididx = 1, lefthalf=(5), righthalf=(3,4)

    def findMin(ints: Seq[Int]): Int = {

      if (ints.isEmpty) return -1
      if (ints.size==1) return ints.head

      val mididx = ints.size / 2

      val lefthalf = for (i <- 0 until mididx) yield ints(i)
      val righthalf: immutable.Seq[Int] = for (i <- mididx until ints.size) yield ints(i)

      val rightmostLefthalf = lefthalf.reverse.head
      val rightmostRighthalf = righthalf.reverse.head
      if (rightmostLefthalf > rightmostRighthalf) {
        //min must be in right half
        findMin(righthalf)
      } else {
        findMin(lefthalf)
      }

    }

    println(findMin(ints))
    println(findMin(ints2))
    println(findMin(int3))
    println(findMin(ints3))
  }

}
