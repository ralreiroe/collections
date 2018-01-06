package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest24 extends FlatSpec with Matchers {


  "Hello" should "have tests" in {

    class HeadTailObject[T](el: T, l: HeadTailObject[T]) {

      val head: T = el
      val tail: HeadTailObject[T] = l
    }

    type MyList[T] = HeadTailObject[T]

    val oneellist = new HeadTailObject[Object]("1", null)

    val iterator = new Iterator[Object] {
      var curr = oneellist

      override def hasNext: Boolean = {
        curr != null
      }
      override def next(): Object = {
        val current = curr
        curr = curr.tail
        current.head
      }
    }

    iterator.hasNext shouldBe(true)
    iterator.next shouldBe("1")
    iterator.hasNext shouldBe(false)
    intercept[NullPointerException]{
      iterator.next
    }

    val twoellist = new HeadTailObject[Object]("2", oneellist)

    def twoellistiterator = new Iterator[Object] {
      private var curr = twoellist

      override def hasNext: Boolean = {
        curr != null
      }
      override def next(): Object = {
        val current = curr
        curr = curr.tail
        current.head
      }
    }

    twoellistiterator.foreach(println(_))
    println("--")
    for(el <- twoellistiterator) println(el)
    println("--")
    val iter = twoellistiterator
    while (iter.hasNext) println(iter.next())
    println("--")


  }
}




