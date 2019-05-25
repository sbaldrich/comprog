/**
  * Codeforces Round 391 A - Gotta Catch 'em All.
  * Source: http://codeforces.com/problemset/problem/757/A
  *
  * We must find how many times we can form the word 'Bulbasaur' using the letters in the text. Since we know how many
  * of each letter (two 'a's, one 'b', one 'B') we need to form the word, find out how many times we can get the required
  * number for each letter and return the minimum of these.
  */
object GottaCatchEmAll extends App{
  val textCount = io.StdIn.readLine().groupBy(_.toChar).mapValues(_.length)
  val bulbasaur = "Bulbasaur".groupBy(_.toChar).mapValues(_.length)
  val ans = bulbasaur.collect{ case (k, v) => textCount.getOrElse(k, 0) / v }.min
  println(ans)
}
