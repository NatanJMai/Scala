package scala

object Main {
  def main(Args:Array[String]){
    var Exp = new Examples() 
    
    var Aab = {
        def Fatorial(a:Int):Int = if(a == 0) 1 else a * Fatorial(a - 1)
        
        Fatorial(5) 
    }
   
    println(Aab)     
  }
}