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

object System {
  var name:String    = ""
  var result:String  = ""
  var command:String = ""
  var arrArgs        = new ArrayBuffer[String]
  
  def run(vFile: File, vLine:String) = {
         if (vLine.contains("sys_tar"))       tar(vLine)
    else if (vLine.contains("sys_zip"))       zip(vLine)
    else if (vLine.contains("sys_mail"))      mail(vLine)
    else if (vLine.contains("sys_crypt"))     crypt(vLine)
    else if (vLine.contains("sys_shell"))     shell(vLine)
    else if (vLine.contains("sys_su-shell"))  su_shell(vLine)
    else if (vLine.contains("sys_translate")) translate(vLine)
    
  }
  
  def tar(vLine:String) = {
    
    
    
    
    
    
    
  }
  
  def zip(vLine:String) = {
    
  }
  
  def mail(vLine:String) = {
    
  }
  
  def crypt(vLine:String) = {
    
  }
  
  def shell(vLine:String) = {
    
  }
  
  def su_shell(vLine:String) = {
    
  }
  
  def translate(vLine:String) = {
    
  }
}