package example

class PutValuesInSlots extends Spec {

  "put values in slots" in {

    def spreadValues(slots: List[Int], values: List[String]) = {

      val positionsOfOnes = slots.zipWithIndex.collect {  //note: map always produces a collection of the same size; use collect or filter to reduce
        case (1,i) => i
      }

      positionsOfOnes.zip(values).foldLeft(List.fill(slots.size)("")) {   //this algorithm updates an initial list of empty strings
        case (acc, (p,v)) => acc.updated(p, v)
      }
    }


    val values = List("11", "22", "33")


    spreadValues(List(1,1,0,1), values) shouldBe (values :+ "").updated(2, "").updated(3, "33")
    spreadValues(List(1,1,0,1), values) shouldBe List("11", "22", "", "33")

  }


}
