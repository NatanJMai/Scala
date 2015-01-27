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

package interpreter
import scala.collection.mutable.ArrayBuffer

class Operation {
  var typeOP    : String = ""
  var result    : Double = 0.0
  var variables = new ArrayBuffer[Variable]
  
  def run(vFile: File, line:String)= {
         if (line.contains("+")) sum(vFile, line)
    else if (line.contains("-")) less(vFile, line)
    else if (line.contains("/")) division(vFile, line)
    else if (line.contains("^")) exponential(vFile, line)
    else if (line.contains("*")) multiplication(vFile, line)
  }
  
/**
 * @author natanjmai
 *
 */
  
  def sum(vFile: File, vLine:String) = {
    var sum:Double = 0
    this.variables = vFile.getListVariable(vLine, "+")
    
    for(vari <- 0 to this.variables.length - 1)
      if(vFile.isNumeric(this.variables(vari).value))
        sum += valueString(this.variables(vari).value)

    this.typeOP = "+"
    this.result = sum
  }
  
/**
 * @author natanjmai
 *
 */
  
  def less(vFile:File, vLine:String) = {
    var less:Double = 0
    this.variables = vFile.getListVariable(vLine, "-")
    
    for(vari <- 0 to this.variables.length - 2)
      if(vFile.isNumeric(this.variables(vari).value))
        less = valueString(this.variables(vari).value) - valueString(this.variables(vari + 1).value)

    this.typeOP = "-"
    this.result = less
  }

/**
 * @author natanjmai
 *
 */  
  
  def division(vFile:File, vLine:String) = {
    var div:Double = 0
    this.variables = vFile.getListVariable(vLine, "/")
    
    for(vari <- 0 to this.variables.length - 2)
      if(vFile.isNumeric(this.variables(vari).value))
        div = valueString(this.variables(vari).value) / valueString(this.variables(vari + 1).value) 

    this.typeOP = "/"
    this.result = div
  }

/**
 * @author natanjmai
 *
 */  
  
  def exponential(vFile:File, vLine:String) = {
    var exp:Double = 0
    println(vLine)
    this.variables = vFile.getListVariable(vLine, "^")
    
    for(vari <- 0 to this.variables.length - 2)
      if(vFile.isNumeric(this.variables(vari).value)){
        exp = {
          var sum   :Double = 1
          var exp   :Double = valueString(this.variables(vari + 1).value)
          var number:Double = valueString(this.variables(vari).value)
                    
          while(exp > 0){
            sum = sum * number
            exp = exp - 1
          }
          
          sum
        }
      }

    this.typeOP = "^"
    this.result = exp
  }

/**
 * @author natanjmai
 *
 */  
  
  def multiplication(vFile:File, vLine:String) = {
    var mult:Double = 1
    this.variables = vFile.getListVariable(vLine, "*")
    
    for(vari <- 0 to this.variables.length - 1)
      if(vFile.isNumeric(this.variables(vari).value))
        mult = valueString(this.variables(vari).value) * mult

    this.typeOP = "*"
    this.result = mult
  }

/**
 * @author natanjmai
 *
 */  
  
  def valueString(stri:String):Double = {return stri.toDouble}
}