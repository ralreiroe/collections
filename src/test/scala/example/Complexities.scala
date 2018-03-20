package example

class Complexities extends Spec {


  "appending to end of array buffer takes constant amortized time" in {

    """def +=(elem: A): this.type = {
      |      ensureSize(size0 + 1)
      |      array(size0) = elem.asInstanceOf[AnyRef]
      |      size0 += 1
      |      this
      |    }"""

  }


  "appending to end of immutable list takes O(n) as last pointer must be modified requiring a copy of the whole list" in {

  }

  "appending to end of mutable ListBuffer is constant as the structure may be modified" in {

  }

  "Stack is deprecated. just use list" in {

    def push[A](el: A, stack: List[A]) = el :: stack
    def pop[A](stack: List[A]) = (stack.head, stack.tail)

  }

  "Queue holds two lists, one for incoming, the other outgoing. When outgoing empty, incoming becomes Nil, outgoing becomes incoming" in {


  }

  /**
    * https://alvinalexander.com/scala/understanding-performance-scala-collections-classes-methods-cookbook
    */

}
