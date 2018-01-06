package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest26 extends FlatSpec with Matchers {


  "HeadTailOject" can "be Iterable" in {

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

    class HeadTailObject[T](el: T, l: HeadTailObject[T]) extends Iterable[T] {

      override val head: T = el
      override val tail: HeadTailObject[T] = l

      override def iterator: Iterator[T] = new MyIterator[T](this)
    }

    type MyList[T] = HeadTailObject[T]

    val oneellist = new HeadTailObject[Object]("1", null)


    val iterator = new MyIterator[Object](oneellist)

    iterator.hasNext shouldBe(true)
    iterator.next shouldBe("1")
    iterator.hasNext shouldBe(false)
    intercept[NullPointerException]{
      iterator.next
    }

    val twoellist = new HeadTailObject[Object]("2", oneellist)

    def twoellistiterator = new MyIterator[Object](twoellist)

    twoellistiterator.foreach(println(_))
    println("--")
    for(el <- twoellist) println(el)
    println("--")
    val iter = twoellistiterator
    while (iter.hasNext) println(iter.next())
    println("--")


  }
}




