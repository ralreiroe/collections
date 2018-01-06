package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest2 extends FlatSpec with Matchers {


  "List" can "work without constructor" in {

    class MyIterator[T](var curr: HeadTailObject[T]) extends Iterator[T] {

      def hasNext: Boolean = {
        curr != null
      }
      def next(): T = {
        val current = curr
        curr = curr.tail
        current.head
      }
    }

    class HeadTailObject[T] {

      var head = null.asInstanceOf[T]
      var tail: HeadTailObject[T] = null
      def add(el: T) = {
        val newHT = new HeadTailObject[T]()
        newHT.head = el
        newHT.tail = this
        newHT
      }

    }

    val myl: HeadTailObject[Int] = new HeadTailObject[Int]()
    val myl2 = myl.add(1).add(2).add(3)

//    new MyIterator[Int](myl2).next()

    for (el <- new MyIterator[Int](myl2)) println(el)

  }
}




