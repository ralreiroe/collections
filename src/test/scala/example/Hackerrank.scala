package example


class Hackerrank extends Spec {

  "sfjksjh" in {



    def cesar(s: String, r: Int =3) = {


      val alphabet = "abcdefg"
      val alphabetr = alphabet.substring(r,alphabet.length)+alphabet.substring(0,r)

      println(alphabet)
      println(alphabetr)
      println(alphabet,alphabetr)


      println(alphabet.indexOf('d'))

    }


    cesar("")
  }



}
