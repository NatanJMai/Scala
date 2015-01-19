/**
 * ***********************************************************
 * |
 * |   NAME  : natanjmai
 * |   DATE  : Jan 16, 2015
 * |   PHONE : 
 * |   FILE  : Interpreter.scala
 * |   EMAIL : natan.mai@hotmail.com
 * |   GITHUB: @NatanJMai
 * |
 * \************************************************************
 */

/**
 * @TODO
 * # Array[String] of file.
 * # Verify 'author' and 'email'
 * # def var
 * > assign 
 * > small garbage-collector
 * >
 */

package interpreter
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Interpreter {
  def main(Args:Array[String]){
    var nFile    = new File()
    var nVeri    = new Verifications()
    
    nFile.path = "/home/natanjmai/Documents/JavaMenosMenos/Fonte/natan.txt"
    nFile.getContent()
    
    nVeri.checkFirstLine(nFile)
    nVeri.manyOthers(nFile)
    
    for(x <- nFile.variables)
      println(x.name, x.value)
        
            
    
  }
}