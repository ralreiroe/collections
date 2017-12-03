package example

import scala.collection.immutable.Stream
import scala.util.Random

class StreamExamples extends Spec {

  """turn a function into a stream of functions.
    |
    |Given:
    |Function f: U=>T
    |
    |define stream:
    |def fstream: Stream[U] = f #:: fstream
    |
    |
  """.stripMargin in {

    def nextAlphaNum: Char = {
      val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
      chars charAt (Random nextInt chars.length)
    }

    def alphanumericStream: Stream[Char] = nextAlphaNum #:: alphanumericStream

    println(alphanumericStream.take(10))
    alphanumericStream.take(10) foreach println

  }

  "b" in {

    def rep(i: Int): Stream[String] = s"${i} times" #:: rep(i+1)

    val s: Stream[String] = "once" #:: "twice" #:: rep(3)

    s.take(10) foreach println




  }
}
