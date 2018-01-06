package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest27 extends FlatSpec with Matchers {


  "Having an add-to-front method" should "work" in {

    class HeadTailObject[T](el: T, l: HeadTailObject[T]) {

      val head: T = el
      val tail: HeadTailObject[T] = l
      def add(el: T) = {
        new HeadTailObject[T](el, this)
      }
    }

    type MyList[T] = HeadTailObject[T]

    val oneellist = new HeadTailObject[Object]("1", null)

    val twoellist = oneellist.add("2")

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




