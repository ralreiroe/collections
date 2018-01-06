package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest21 extends FlatSpec with Matchers {


  "HeadTailObject" can "work without Null" in {

    abstract class AbstractHeadTailObject[+T] {
      def head: T
      def tail: AbstractHeadTailObject[T]
    }

    object TheEmptyList extends AbstractHeadTailObject[Nothing] {
      override def head: Nothing = throw new NoSuchElementException("head of empty list")
      override def tail: AbstractHeadTailObject[Nothing] = throw new UnsupportedOperationException("tail of empty list")
    }

    class HeadTailObject[T](el: T, l: AbstractHeadTailObject[T]) extends AbstractHeadTailObject[T] {

      override def head: T = el
      override def tail: AbstractHeadTailObject[T] = l

      def iterator = new Iterator[T] {
        private var curr = HeadTailObject.this.asInstanceOf[AbstractHeadTailObject[T]]

        override def hasNext: Boolean = {
          curr != TheEmptyList
        }

        override def next(): T = {
          val current = curr
          curr = curr.tail
          current.head
        }
      }
    }

    val l = new HeadTailObject[String]("1", TheEmptyList)
    val iterator = l.iterator
    iterator.hasNext shouldBe (true)
    iterator.next shouldBe ("1")
    iterator.hasNext shouldBe (false)
    intercept[UnsupportedOperationException] {
      iterator.next
    }

    val l2 = new HeadTailObject[Object]("2", l)
    l2.iterator.foreach(println(_))
  }
}




