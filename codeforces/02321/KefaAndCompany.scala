object KefaAndCompany {
  def main(args : Array[String]) : Unit = {
    val sc = new java.util.Scanner(System.in)
    val (n,d) = (sc.nextInt(), sc.nextInt())
    var a = new Array[(Int,Int)](n)
    
    for( i <- 0 until n )
      a(i) = (sc.nextInt(), sc.nextInt())
    a = a.sortBy(_._1)
    
    var best = 0L
    var currentTotal = 0L
    var low = 0     
    
    for( i <- 0 until n ){
      currentTotal += a(i)._2
      while(low < i && math.abs(a(low)._1 - a(i)._1) >= d){
        currentTotal -= a(low)._2
        low += 1
      }
      best = math.max(currentTotal, best)
    }
    
    println(best)    
  }  
}