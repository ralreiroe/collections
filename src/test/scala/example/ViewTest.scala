package example

class ViewTest extends Spec {

  "views avoid intermediate collections...." in {

    val view = (1 to 1000000000).view
    val function: Int => Boolean = _ % 2 == 0
    val value = view.filter(function)
    val v2 = value.take(10)
    v2.toList

  }


  "views avoid intermediate collections!!" in {

    //https://books.google.co.uk/books?id=iwZwDQAAQBAJ&pg=PA144&lpg=PA144&dq=how+are+scala+views+implemented

    sealed trait PseudoView[A] {
      def map[B](f: A => B): PseudoView[B]

      def force: List[A]
    }

    final class InitialView[A](xs: List[A]) extends PseudoView[A] {
      def map[B](f: A => B) = new ComposedView(xs, f)

      def force: List[A] = xs
    }

    final class ComposedView[A, B](xs: List[A], fa: A => B) extends PseudoView[B] {
      def map[C](fb: B => C): PseudoView[C] = new ComposedView[A, C](xs, fa.andThen(fb))    //<=====COMPOSITION!! NO INTERMEDIATE COLLECTIONS...

      def force: List[B] = xs.map(fa)
    }

    val res: PseudoView[Int] = new InitialView(List(1, 2, 3)).
      map(i => {
        println(s"adding 1 to ${i}")
        i + 1
      }).
      map(i => {
        println(s"multiply ${i} with 2")
        i * 2
      })


    res.force

  }

}
