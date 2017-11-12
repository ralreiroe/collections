package example

import org.scalatest.{FlatSpec, Matchers}

class SetTests extends FlatSpec with Matchers {
  "subset" should "work" in {

    Set(1,2) subsetOf Set(1,2,3) shouldBe true
    Set(1,2) forall Set(1,2,3) shouldBe true      //takes right side as a predicate function ie. given

    Set(1,2,3)(1) shouldBe true
    Set(1,2,3)(2) shouldBe true
    Set(1,2,3)(4) shouldBe false

    //this is the same as

    Set(1,2).foldLeft(true) {
      case (a,c) => a && Set(1,2,3)(c)
    }

    Set(1,2).foldLeft(true)(_ && Set(1,2,3)(_)) shouldBe true

    Set(1,2) filterNot (Set(1,2,3).contains(_)) shouldBe (Set(1,2) filter (!Set(1,2,3).contains(_)))

    Set(1,2) filter (!Set(1,2,3).contains(_)) shouldBe empty
    Set(1,2) filter (!Set(1,3).contains(_)) shouldBe Set(2)

    Set(1,2) find {case el => !Set(1,2,3).contains(el)} shouldBe None
    Set(1,2) find {case el => !Set(1,3).contains(el)} shouldNot be(None)


  }
}




