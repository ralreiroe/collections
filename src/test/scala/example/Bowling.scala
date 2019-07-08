package example

import scala.collection.mutable.ListBuffer

object BowlingFunctions {

  def score(i : Int)(implicit rolls: List[Int]): Int = {

    (i, i % 2) match {
      case (0,_) => rolls(0)
      case (_,0) => score(i-1)+rolls(i)
      case (_,1) => scoreOdd(i)
      case (_,_) => throw new Exception("unexpected")
    }

  }

  def scoreOdd(i: Int)(implicit rolls: List[Int]): Int = {

    (rolls(i-1),rolls(i)) match {
      case (10, 0) => score(i-1) + rolls(i) + rolls.drop(i+1).filter(_ > 0).take(2).sum              //strike
      case (a,b) if a+b==10 => score(i-1) + rolls(i) + rolls.drop(i+1).filter(_ > 0).take(1).sum     //spare
      case (a,b) => score(i-1) + rolls(i)
    }

  }

}

class Bowling extends Spec {

  import BowlingFunctions._

  "score bowling game" in {


    implicit val rolls = List(1,4,2,8,5,3,10,0,6,2)

    score(0) shouldBe 1
    score(1) shouldBe 5
    score(2) shouldBe 7
    score(3) shouldBe 20
    score(4) shouldBe 25
    score(5) shouldBe 28
    score(6) shouldBe 38
    score(7) shouldBe 46


  }


  "strike" in {
    implicit val rolls = List(10,0,6,2)

    score(0) shouldBe 10
    score(1) shouldBe 18

  }

  "many strikes" in {
    implicit val rolls = List(10,0,10,0,10)

    score(0) shouldBe 10
    score(1) shouldBe 30

  }
  "not enough rolls" in {
    implicit val rolls = List(10,0,10,0,10)

    score(0) shouldBe 10
    score(1) shouldBe 30
    score(2) shouldBe 40
    score(3) shouldBe 50

  }

  "spare" in {
    var rolls = List(5,5,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    score(19)(rolls) shouldBe 16

    rolls = List(0,10,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    score(19)(rolls) shouldBe 16
  }

  "strike 2" in {
    var rolls = List(10,0,3,8,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
    score(19)(rolls) shouldBe 10+2*3+2*8
  }

  "12 strikes" in {
    implicit val rolls = List(10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0,10,0)
    println(rolls.size)

    score(0) shouldBe 10
    score(1) shouldBe 30
    score(19) shouldBe 300

  }

  "others" in {
    var rolls = List(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
    score(19)(rolls) shouldBe 20
  }


  "api" in {

    trait BowlingGameI {
      def roll(pins: Int): Unit
      def score(): Int
    }
    class Game extends BowlingGameI {
      val rolls = ListBuffer.fill(24)(0)
      var currentRoll = 0
      def roll(pins: Int) = {
        (currentRoll % 2, pins) match {
          case (0, 10) => rolls(currentRoll) = 10; currentRoll = currentRoll+2   //strike
          case (_,_) => rolls(currentRoll) = pins; currentRoll = currentRoll+1
        }
      }
      def score(): Int = BowlingFunctions.score(currentRoll)(rolls.toList)


      val g = new Game()

      List(1,4,2,8,5,3,10,0,6,2).foreach(g.roll(_))
      g.score() shouldBe(46)
    }

  }
}
