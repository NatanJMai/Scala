/**
 * ***********************************************************
 * |
 * |   NAME  : natanjmai
 * |   DATE  : Feb 2, 2015
 * |   PHONE :
 * |   FILE  : System.scala
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
import scala.sys.process._

class System(line :String) {
  var name:String    = ""
  var result:String  = ""
  var command:String = line.trim()
  var numberArgs:Int = 0    
  var arrayArgs      = new ArrayBuffer[String]
  
  
  def run(vFile: File) = {
    separate()
    
    if (this.command.contains("sys_tar"))           tar(vFile)
    else if (this.command.contains("sys_zip"))      zip()
    else if (this.command.contains("sys_mail"))     mail()
    else if (this.command.contains("sys_crypt"))    crypt()
    else if (this.command.contains("sys_shell"))    shell()
    else if (this.command.contains("sys_su-shell")) su_shell()
    else if (this.command.contains("sys_translate"))translate()
    
  }
  
  def separate(){
    var indexDot:Int  = 0
    var indexPar:Int  = this.command.indexOf("(") + 1
    var indexT  : Int = 0
      
    var indexTT:Int = 0
    
    this.numberArgs = this.command.substring(indexPar, indexPar + 1).toInt
    
    indexDot = this.command.indexOf(",") + 1
    indexTT  = this.command.indexOf(",", indexDot)
    
    this.arrayArgs += this.command.substring(indexDot, indexTT)
    
    for(x <- 1 to this.numberArgs - 1){
      indexTT = indexTT + 1
      indexDot = indexTT 
      indexTT = this.command.indexOf(",", indexTT)
      this.arrayArgs += this.command.substring(indexDot, indexTT)
    }
  }
  
  def tar(vFile:File) = {
    var variable : Variable = null    
    var path     : String   = ""
    var message  : String   = "tar -"
    
    for(x <- 0 to this.numberArgs - 2)
      message = message + this.arrayArgs(x)
      
    variable = vFile.getVariable(this.arrayArgs(this.numberArgs - 1))
      
    if (variable != null)
      path = variable.value
    else
      path = this.arrayArgs(this.numberArgs - 1)
    
    message = message + " " + path
      
    Process(message).!!
    println("The file is in this path: " + Process("pwd").!!)
  }
  
  def zip() = {
    //print(this.numberArgs)
    
  }
  
  def mail() = {
    
  }
  
  def crypt() = {
    
  }
  
  def shell() = {
    
  }
  
  def su_shell() = {
    
  }
  
  def translate() = {
    
  }
}