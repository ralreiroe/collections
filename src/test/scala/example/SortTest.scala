package example

import org.scalatest._

import scala.util.Try

/**
  * https://stackoverflow.com/questions/15564199/scala-sort-based-on-a-number-in-the-string
  */
class SortTest extends FlatSpec with Matchers {
  "sorting by length then head" can "work" in {

    val words = "the quick brown fox jumped over the lazy dog".split(' ')
    // this works because scala.Ordering will implicitly provide an Ordering[Tuple2[Int, Char]]
    var res = words.sortBy(x => (x.length, x.head)).toList

    println(res)

    res = words.sortBy(x => (x.head)).toList

    println(res)

    res = List("the", "The").sortBy(x => (x.head)).toList

    println(res)
  }

  "sorting b" can " work " in {


    var coperStrings = List("20645", "3694", "2963", "38961")
    var coperStringsSorted = coperStrings.sortBy(str => -str.toInt)

    coperStringsSorted.foreach(println(_))

    coperStrings = List("20645", "3694", "2963", "38961", "***")
    coperStringsSorted = coperStrings.sortBy(str => -str.toInt)

    coperStringsSorted.foreach(println(_))
  }

  "sorting c" can "work" in {

    var coperStrings = List("20645", "3694", "2963", "38961", "***")
    var coperStringsSorted = coperStrings.sortBy(str => Try(-str.toInt).getOrElse(0))

    coperStringsSorted.foreach(println(_))

  }

  "sorting alphabetically " can "work" in {

    var coperStrings = List("20645", "3694", "2963", "38961")

    coperStrings.sortBy(identity).foreach(println(_))


    coperStrings.sortBy(identity).grouped(2).foreach(println(_))

  }
}




