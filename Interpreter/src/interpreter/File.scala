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
  var lines       :Int     = 0
  var name        :String  = ""
  var path        :String  = ""
  var author      :String  = ""
  var email       :String  = ""     
  var arrLine     = new ArrayBuffer[String] 
  var variables   = new ArrayBuffer[Variable]
  
  def getContent() = {
    
    for(vcLine <- Source.fromFile(this.path).getLines())
      this.arrLine += vcLine
      
    this.lines = this.arrLine.length  
  }
}