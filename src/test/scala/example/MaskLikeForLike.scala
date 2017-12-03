package example


import org.scalatest.Matchers

import scala.collection.immutable.Stream
import scala.util.Random

class MaskLikeForLike extends Spec with Matchers {

  "Mask an alphanumeric string can work by like-for-like randomization" in {

    val orig = "AB123456C"

    (1 to 10) foreach (_ => println (for (c <- orig) yield mask(c)))


    def mask(ch: Char) = {

      val letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      val sletters = "abcdefghijklmnopqrstuvwxyz"
      val numbers = "0123456789"

      ch match {
        case c if c >= 'A' && c <= 'Z' => letters charAt Random.nextInt(letters.length)
        case c if c >= 'a' && c <= 'z' => letters charAt Random.nextInt(sletters.length)
        case c if c >= '0' && c <= '9' => numbers charAt Random.nextInt(numbers.length)
        case _ => 'A'
      }
    }
  }

  "" in {

    def alphanumeric: Stream[Char] = {
      def nextAlphaNum: Char = {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        chars charAt (Random nextInt chars.length)
      }

      val charStream1: Stream[Char] = Stream continually nextAlphaNum
      Stream.cons(nextAlphaNum, Stream.continually(nextAlphaNum))
      nextAlphaNum #:: Stream.continually(nextAlphaNum)

      nextAlphaNum #:: alphanumeric
    }

    def i(x:Int, y:Int): Stream[Int] = (x*y) #:: i(x+1,y*2)


  }
}
