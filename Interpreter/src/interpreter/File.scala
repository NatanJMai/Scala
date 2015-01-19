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
  var lines          :Int     = 0
  var name           :String  = ""
  var path           :String  = ""
  var author         :String  = ""
  var email          :String  = ""     
  var arrLine        = new ArrayBuffer[String] 
  var variables      = new ArrayBuffer[Variable]
  var arrOperations  = new ArrayBuffer[Operation]()
  
  def getContent() = {
    var operations = Array("+", "-", "*", "^", "/")
    
    for(vcLine <- Source.fromFile(this.path).getLines())
      this.arrLine += vcLine
    
    for(vcOper <- operations){
      var newOperat  = new Operation()
      newOperat.typeOP = vcOper
      
      this.arrOperations += newOperat
    }
      
    this.lines = this.arrLine.length  
  }
  
/** 
  *  This function check if the variable exist. 
  **/
  
  def existVariable(varName:String):Boolean = {
    for (x <- this.variables)
      if (x.name == varName) return true       
    
    return false
  }
  
/** 
  *  This function return the variable with 'varName' 
  **/
  
  def getVariable(varName:String):Variable = {
    if (existVariable(varName)){
      for (x <- this.variables)
        if (x.name == varName) return x
    }
    
    return null 
  }
  
  def existOperation(varOp:String):Boolean = {
    for (x <- this.arrOperations)
      if(x.typeOP == varOp) return true    
    
    return false
  }
  
  def getOperation(varOp:String):Operation = {
    if (existOperation(varOp)){
      for (x <- this.arrOperations)
        if(x.typeOP == varOp) return x            
    }
    
    return null
  }
}