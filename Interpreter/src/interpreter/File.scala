/**
 * ***********************************************************
 * |
 * |   NAME  : natanjmai
 * |   DATE  : Jan 16, 2015
 * |   PHONE : 
 * |   FILE  : File.scala
 * |   EMAIL : natan.mai@hotmail.com
 * |   GITHUB: @NatanJMai
 * |
 * \************************************************************
 */

/**
 * @TODO
 *
 *
 */
package interpreter
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

class File {
  var numberLines :Int    = 0
  var nameOfFile  :String = ""
  var pathFile    :String = ""
  var arrLine     = new ArrayBuffer[String] 
  
  def getContent() = {
    
    for(vcLine <- Source.fromFile(this.pathFile).getLines())
      this.arrLine += vcLine
      
    this.numberLines = this.arrLine.length  
  }
  
  
}