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
 * > Array[String].
 * > Clean up.
 */

package interpreter
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Interpreter {
  def main(Args:Array[String]){
    var nFile    = new File()
    
    nFile.pathFile = "/home/natanjmai/Documents/natan.txt"
    nFile.getContent()

    /* Just a test :) */
    for(vlLine <- nFile.arrLine)
      println(vlLine)
    
  }
}