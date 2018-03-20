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

  """A trie is a tree.
    |A short wide tree. Rather than a binary tree, it is a 32-ary tree
    |So each node is an Array[32]. On the 5th level that is already 32^5 ~ 33 Mill pointers. If these held a 4-byte primitive Int the data would already be 132Gb
    |Memory: Nodes are not preactively allocated for a level, only as needed.
    |Lookup/Insert time: log to base 32 which if "effectively constant"
    |Because it is a tree it can be made immutable through effective structural sharing.
  """.stripMargin in {

    //https://stackoverflow.com/questions/20612729/how-does-scalas-vector-work
  }

  /**
    * https://alvinalexander.com/scala/understanding-performance-scala-collections-classes-methods-cookbook
    */

}
