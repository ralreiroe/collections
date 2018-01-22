package example

class CollectExamples extends Spec {

    val id:String=>String = identity
    val removeCountryCode: String=>String = str=>str.substring(Math.min(str.size,2),str.size)
    val takeEnd: String=>String = { str => val aftrlastfwslash = ".*/([^/]+)$".r; str match { case aftrlastfwslash(res) => res; case _ => str } }
    val rowfunction1: List[String]=>String = row => (row(2)+row(3)).substring(0,2)

    val functions: List[String => String] = List(id, removeCountryCode, takeEnd)
    val functions2: List[String with List[String] => String] = List(id, removeCountryCode, takeEnd, rowfunction1)

  "type erasure will scupper matching" in {

    val onlys = functions.collect {
      case scalarf: (String=>String) => scalarf
    }

    onlys.size shouldBe 3

    //type erasure will make these just Lists and the type to match on just a Function1
    val onlys2 = functions2.collect {
      case scalarf: (String=>String) => scalarf
    }
    onlys2.size shouldBe 4

    val onlys3 = functions2.collect {
      case scalarf: Function1[_,_] => scalarf
    }
    onlys3.size shouldBe 4

    //pattern matching works with non-generic types
    val test = List("name", 1.5, 3.5)
    test.collect {case e: String => e}.size shouldBe 1
    test.collect {case e: Double => e}.size shouldBe 2

  }



}
