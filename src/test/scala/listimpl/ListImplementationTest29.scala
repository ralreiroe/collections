package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest29 extends FlatSpec with Matchers {


  "HeadTailOject" can "have add-to-back method using loop direct on tail" in {

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
        var curr: HeadTailObject[T] = HeadTailObject.this
        var lastnonnull: HeadTailObject[T] = null
        while(curr != null) {
          lastnonnull = curr
          curr = curr.tail
        }
        lastnonnull.tail = new HeadTailObject[T](el, null)
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




