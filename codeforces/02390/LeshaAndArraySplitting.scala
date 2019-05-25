/**
  * Codeforces Round 390 A - Lesha and Array Splitting.
  * Source: http://codeforces.com/problemset/problem/754/A
  *
  * The only way it isn't possible to split the array as desired is if all entries are zero, so firstly we must check for
  * this condition and answer NO if it is true. If not, greedily find the answer.
  */
object LeshaAndArraySplitting extends App{
  io.StdIn.readLine()
  val A : Array[Int] = io.StdIn.readLine().split("\\s+").map(_.toInt)
  if(A.count(_ == 0) == A.length){
    println("NO")
  } else{
    if(A.sum != 0) println(
      s"""
         |YES
         |1
         |1 ${A.length}
       """.stripMargin)
    else {
      def f(split : Int) : Int = {
        A.splitAt(split) match {
          case (l, r) if l.sum != 0 && r.sum != 0 => split
          case _ => f(split - 1)
        }
      }
      val split = f(A.length)
      println(
        s"""YES
           |2
           |1 $split
           |${split + 1} ${A.length}
         """.stripMargin)
    }
  }
}

