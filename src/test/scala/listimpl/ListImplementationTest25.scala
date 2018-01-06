package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest25 extends FlatSpec with Matchers {


  "Adding to the back" must "require tail to be a var as it must be reassigned on every add" in {

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
    }



    type MyList[T] = HeadTailObject[T]

    val list1 = new HeadTailObject[Object]("1", null)



    val iterator = new MyIterator[Object](list1)

    iterator.hasNext shouldBe(true)
    iterator.next shouldBe("1")
    iterator.hasNext shouldBe(false)
    intercept[NullPointerException]{
      iterator.next
    }

    val list2 = new HeadTailObject[Object]("2", null)

    list1.tail = list2



    def twoellistiterator = new MyIterator[Object](list1)

    twoellistiterator.foreach(println(_))
    println("--")
    for(el <- twoellistiterator) println(el)
    println("--")
    val iter = twoellistiterator
    while (iter.hasNext) println(iter.next())
    println("--")


  }
}




