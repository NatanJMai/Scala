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

object System {
  var name:String    = ""
  var result:String  = ""
  var command:String = ""
  
  
  def run(vFile: File, line:String) = {
         if (line.contains("sys_tar"))       tar()
    else if (line.contains("sys_zip"))       zip()
    else if (line.contains("sys_mail"))      mail()
    else if (line.contains("sys_crypt"))     crypt()
    else if (line.contains("sys_shell"))     shell()
    else if (line.contains("sys_su-shell"))  su_shell()
    else if (line.contains("sys_translate")) translate()
  }
  
  
  
  def tar()       = {}
  def zip()       = {}
  def mail()      = {}
  def crypt()     = {}
  def shell()     = {}
  def su_shell()  = {}
  def translate() = {}
  
}