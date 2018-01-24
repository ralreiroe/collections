package example

class DifferenceBetweenTwoLists extends Spec {

  "aSet(1) ~= aSet.apply(1) with apply _ = Int=>Boolean" in {

    val list1 = List(1, 2, 3)
    val list2 = List(1, 3, 4)

    list2.filterNot(list1.toSet) shouldBe List(4)

    val aSet = Set(1, 2, 3)
    list1.toSet shouldBe aSet
    aSet(1) shouldBe true
    aSet.apply(3) shouldBe true      //def apply(elem: A): Boolean = this contains elem so apply is A=>Boolean
    val res: Int => Boolean = aSet.apply _
    aSet.apply(4) shouldBe false

    list2.filterNot(list1.toSet) shouldBe list2.filterNot(e => list1.toSet.apply(e))

  }
}




