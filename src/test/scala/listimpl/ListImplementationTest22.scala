package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest22 extends FlatSpec with Matchers {


  "Hello" should "have tests" in {

    class HeadTailObject[T](el: T, l: HeadTailObject[T]) {

      var head: T = el
      var tail: HeadTailObject[T] = l

      def iterator = new Iterator[T] {
        private var curr = HeadTailObject.this

        override def hasNext: Boolean = {
          curr != null
        }
        override def next(): T = {
          val current = curr
          curr = curr.tail
          current.head
        }
      }
    }

    type MyList[T] = HeadTailObject[T]

    val oneellist = new MyList[Object]("1", null)

    val iterator = oneellist.iterator
    iterator.hasNext shouldBe(true)
    iterator.next shouldBe("1")
    iterator.hasNext shouldBe(false)
    intercept[NullPointerException]{
      iterator.next
    }

    val twoellist = new HeadTailObject[Object]("2", oneellist)

    twoellist.iterator.foreach(println(_))
    println("--")
    for(el <- twoellist.iterator) println(el)
    println("--")
    val iter = twoellist.iterator
    while (iter.hasNext) println(iter.next())
    println("--")


  }
}




