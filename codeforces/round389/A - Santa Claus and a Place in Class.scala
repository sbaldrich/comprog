/**
  * Codeforces Round 389 A - Santa Claus and a Place in Class.
  * Source: http://codeforces.com/problemset/problem/748/A
  *
  * Some simple divisions.
  */
object SantaClausAndAPlaceInAClass extends App{
  val Array(n, m, k) = io.StdIn.readLine.split("\\s+").map(_.toInt)
  val lane = Math.ceil(k / (2.0 * m)).toInt
  val desk = Math.ceil((k - (lane - 1) * 2 * m) / 2.0).toInt
  println(s"""$lane $desk ${if(k % 2 == 0) "R" else "L"}""")
}

