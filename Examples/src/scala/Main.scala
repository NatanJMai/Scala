package scala

object Main {
  def main(Args:Array[String]){
    var Exp = new Examples() 
    
    //Exp.arr(Array(1,2,3,4,5,6,7,8,9,10))
    
    
    def test(f:Int =>Int, x:Int, b:Int):Int = {return f(x) + b}
    
    def sum(x:Int):Int = {return x + x}
    
    println(test(x => x * x, 2, 3))
    println(test(sum, 2, 3))
  }
}