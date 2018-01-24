package example

class TransformListBySeriesOfFunctions extends Spec {

  //column functions
  val id: String => String = identity
  val removeFirst2: String => String = str => str.substring(Math.min(str.size, 2), str.size)
  val takeEnd: String => String = { str =>
    val aftrlastfwslash = ".*/([^/]+)$".r
    str match {
      case aftrlastfwslash(res) => res;
      case _ => str
    }
  }

  //apply turns a list of column functions into a row function
  val apply: List[String => String] => List[String] => List[String] = colfuncs => vals => vals.zip(colfuncs).map { case (v, f) => f(v) }

  //row functions
  val withCountryCode: List[String] => List[String] = row => row(0) :: row(1) :: findCountryCode(row) :: Nil
  private val findCountryCode: List[String] => String = row => (row(2), row(3)) match {
    case ("", b) => b;
    case (a, b) => a
  }

  //combining them all
  val combiner: List[String] => List[String] = apply(List(id, removeFirst2, takeEnd, takeEnd)).andThen(withCountryCode)


  "combine column and row functions" in {

    combiner(List("12", "GB123456XX78", "c1/GB", "c2/US")) shouldBe List("12", "123456XX78", "GB")
    combiner(List("12", "GB123456XX78", "", "c2/US")) shouldBe List("12", "123456XX78", "US")
    combiner(List("12", "GB123456XX78", "", "")) shouldBe List("12", "123456XX78", "")

  }


}
