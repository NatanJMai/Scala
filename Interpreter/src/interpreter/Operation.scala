/**
 * ***********************************************************
 * |
 * |   NAME  : natanjmai
 * |   DATE  : Jan 19, 2015
 * |   PHONE :
 * |   FILE  : Operation.scala
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

/**
 * @author natanjmai
 *
 */
class Operation {
  var typeOP    : String = ""
  var result    : Double = 0.0
  var variables = new ArrayBuffer[Variable]()
  
  def run(){
    if (this.typeOP == "+") sum()
    else if (this.typeOP == "-") less()
    else if (this.typeOP == "/") division()
    else if (this.typeOP == "^") exponential()
    else if (this.typeOP == "*") multiplication()
  }
  
  def valueString(stri:String):Double = {
    return stri.toDouble
  }
  
  def sum(){
    var sum:Double = 0
    
    for (x <- this.variables){
      sum += valueString(x.value)
      println(sum)  
    }
    
    this.result = sum
  }
  
  def less(){}
  
  def division(){}
  
  def exponential(){}
  
  def multiplication(){}
  
  
}