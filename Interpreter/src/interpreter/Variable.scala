/**
 * ***********************************************************
 * |
 * |   NAME  : natanjmai
 * |   DATE  : Jan 19, 2015
 * |   PHONE :
 * |   FILE  : Variable.scala
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

/**
 * @author natanjmai
 *
 */
class Variable {
  var name   : String  = ""
  var value  : String  = ""
  var use    : Boolean = false
  
  def setValue(newValue : String) = {
    this.value = newValue
  }
  
  def setName(newName : String) = {
    this.name = newName
  } 
}
