/**
  * Codeforces Good Bye 2016 A - New Year Hurry.
  * Source: http://codeforces.com/problemset/problem/750/A
  *
  * The problem is trivial.
  */
object NewYearHurry extends App{
  val Array(n,k) = io.StdIn.readLine.split("\\s+").map(_.toInt)
  val ans = (1 to n).map(5 * _).scanLeft(0)(_ + _).drop(1).takeWhile(_ <= 240 - k).size
  println(ans)
}
