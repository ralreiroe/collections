package example

class ZipallTest extends Spec {
  "zipping different sizes" in {

    Seq(1, 1, 1, 1).zip(Seq(2, 2, 2, 2)) shouldBe List((1,2), (1,2), (1,2), (1,2))

    Seq(1, 1, 1, 1).zip(Seq(2, 2)) shouldBe List((1,2), (1,2))

    Seq(1, 1, 1, 1).zipAll(Seq(2, 2), 3, 4) shouldBe List((1,2), (1,2), (1,4), (1,4))       //3 for filling if left shorter, 4 for if right right shorter
  }

  "zipping more than two" in {

    //https://stackoverflow.com/questions/1664439/can-i-zip-more-than-two-lists-together-in-scala

    Seq(1, 1, 1, 1) zip Seq(2, 2) zip Seq(3,3) map {
      case ((a,b), c) => (a,b,c)
    } shouldBe List((1,2,3), (1,2,3))
    Seq(1, 1, 1, 1) zip Seq(2, 2) zip Seq(3,3) zip Seq(4,4) map {
      case (((a,b),c),d) => (a,b,c,d)
    } shouldBe List((1,2,3,4), (1,2,3,4))

  }

}
