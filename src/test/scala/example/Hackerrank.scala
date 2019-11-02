package example


class Hackerrank extends Spec {

  "sfjksjh" in {


    /**
      * 1am => 1, 11am => 11,
      * 12pm => 12
      * 1pm => 13, ..., 11pm => 23
      * 12am => 0
      */
    def convertHour(h: Int, isA: Boolean) = {

      (if (h == 12 && isA) 0 else if (isA) h else h + 12).toString
    }

    println(convertHour(1, true))
    println(convertHour(1, false))
    println(convertHour(12, true))
    println(convertHour(12, false))



    def convertString(s: String) = {

      val isA = s.substring(s.length-2,s.length).toUpperCase=="AM"
      convertHour(s.substring(0,2).toInt, isA)+s.substring(2,s.length-2)
    }


    println(convertString("01:05:34am"))
    println(convertString("01:05:34pm"))
  }


}
