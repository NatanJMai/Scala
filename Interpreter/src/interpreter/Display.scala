/**
 * ***********************************************************
 * |
 * |   NAME  : natanjmai
 * |   DATE  : Jan 23, 2015
 * |   PHONE :
 * |   FILE  : Display.scala
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
import scala.actors.Exit

class Display(msg:String){
  var message:String = msg
  
  def display(vFile:File){
    var indexCer = this.message.indexOf("#")
    
    if (vFile.getNumberOfOperators(this.message, ':') > 1){
      println("ERROR - Just ONE ':' Character! ")
      
      Exit
    }
    
    if (this.message.contains(":")){
      var indexDot = this.message.indexOf(":") + 1
      var line     : String = ""
      var name     : String = ""
      
      name = this.message.substring(indexDot, indexCer).trim()
      line = this.message.substring(0, indexDot - 1).trim()
      
      println(line + " " + vFile.getVariable(name).value)
      
    }else{
      println(this.message.substring(0, indexCer).trim())      
    } 
  }
}