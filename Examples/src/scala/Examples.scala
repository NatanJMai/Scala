package scala

class Examples {
  
  /*  */
  def Fatorial(a:Int):Int = 
    if(a == 0) 1 else a * Fatorial(a - 1)
    
  
  /*  */
  def IsPrime(a:Int): Boolean = 
    return false
  
  /*  */
  def arr(array:Array[Int]){
    for(x <- 0 to array.length - 1)
      println(array(x))
    
  }
  
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    f(a) + sum(f, a + 1, b)
  }
}