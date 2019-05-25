/**
  * Codeforces Round 388 A - Bachgold Problem.
  * Source: http://codeforces.com/problemset/problem/749/A
  *
  * The problem is trivial.
  */
object BachgoldProblem extends App{
  val n = io.StdIn.readInt()
  println(n / 2)
  println(n match{
    case n if n <= 3 => n
    case n if n % 2 == 0 => "2" + " 2" * (n / 2 - 1)
    case _ => "2" + " 2" * (n / 2 - 2) + " 3"
  })
}
