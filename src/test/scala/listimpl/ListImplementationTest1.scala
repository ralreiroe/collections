package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest1 extends FlatSpec with Matchers {


  "Hello" should "have tests" in {

    class MyList[T <: AnyRef] {

      var head: T = null.asInstanceOf[T]
      var tail: MyList[T] = null
      def add(el: T, l: MyList[T]) = {
        head = el
        tail = l
        this
      }
      def iterator = new Iterator[T] {
        private var curr = MyList.this
        override def hasNext: Boolean = {
//          print("t"+tail+"|")
          curr.head!=null
        }
        override def next(): T = {
          val res = curr
          curr = curr.tail
          res.head
        }
      }
    }

    val l = new MyList[String]().add("1", new MyList[String]())
    l.add("2", new MyList[String]())

    l.iterator.take(10).foreach(println(_))



  }
}




