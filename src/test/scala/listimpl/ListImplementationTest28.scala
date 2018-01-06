package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest28 extends FlatSpec with Matchers {


  "HeadTailOject" can "have add-to-back method using iterator" in {

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

    class HeadTailObject[T](el: T, l: HeadTailObject[T]) {

      val head: T = el
      var tail: HeadTailObject[T] = l

      def iterator: Iterator[T] = new MyIterator[T](this)

      def addToBack(el: T) = {
        val iter = new Iterator[HeadTailObject[T]] {
          var curr: HeadTailObject[T] = HeadTailObject.this
          override def hasNext: Boolean = curr != null
          override def next(): HeadTailObject[T] = {
            val current = curr
            curr = curr.tail
            current
          }
        }
        var last: HeadTailObject[T] = null
        while(iter.hasNext) {
          last = iter.next()
        }
        last.tail = new HeadTailObject[T](el, null)
        this
      }
    }

    type MyList[T] = HeadTailObject[T]

    val oneellist = new HeadTailObject[String]("1", null)
    val threeellist = oneellist.addToBack("2").addToBack("3")

    def twoellistiterator = new MyIterator[String](threeellist)

    twoellistiterator.foreach(println(_))

  }
}




