import scala.io.StdIn.readLine

object AmrAndTheLargeArray{
  case class Triplet( left : Int, right : Int, count : Int)
  def main(args : Array[String]) : Unit = {
      readLine()
      val a = readLine().split("\\s+").map( _.toInt )
      val map = scala.collection.mutable.HashMap[Int, Triplet]()
      (a.zipWithIndex).foreach({
        case (a,i) => map.get(a) match {
          case None => map(a) = Triplet(i,i,1)
          case Some(Triplet(l,r,k)) => map(a) = Triplet(l,i,k+1) 
        }
      })
      
      val ans = map.valuesIterator.reduceLeft( (thiz, that) => {
         if(thiz.count != that.count)
          if(thiz.count >= that.count) thiz else that
        else if ((thiz.right - thiz.left) <= (that.right - that.left)) thiz else that
      })
      
      val l = ans.left + 1 
      val r = ans.right + 1
      println(l + " " + r)   
  }
}