package listimpl

import org.scalatest.{FlatSpec, Matchers}

class ListImplementationTest extends FlatSpec with Matchers {


  "Hello" should "have tests" in {

    class MyList {

      var head: Integer = null
      var tail: MyList = null
      def add(el: Int, l: MyList) = {
        head = el
        tail = l
      }
//      def iterator = new Iterator {
//        override def hasNext: Boolean = ???
//
//        override def next(): = ???
//      }
    }

    new MyList().add(1, new MyList())



  }
}




