package example

import scala.collection.mutable.ArrayBuffer

class SideEffectDetriment extends Spec {

  """in the presence of side effect we have less chance to optimize""" in {

    val builder = ArrayBuffer.empty[Int]

    Seq(4,5,6,1,2).filter(x => { builder.append(x); x > 3 }).headOption shouldBe
    Seq(4,5,6,1,2).find(x => { builder.append(x); x > 3 })

    //but cannot do this as it leaves the out of scope builder in different state

    //https://pavelfatin.com/scala-collections-tips-and-tricks/





  }
}
