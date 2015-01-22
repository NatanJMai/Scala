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
  
  def getContent() = {
    for(vcLine <- Source.fromFile(this.path).getLines())
      this.arrLine += vcLine
      
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
  
  def isNumeric(nameVar: String): Boolean = nameVar.forall(_.isDigit)
  
  def getListVariable(vLine:String, operat:String):ArrayBuffer[Variable] = {
    var variab = new ArrayBuffer[Variable]
    var indexOp    :Int    = 0
    var indexEq    :Int    = 0
    var nameFVar   :String = ""
    var nameSVar   :String = ""
    
    var variable : Variable = null
    
    indexOp      = vLine.indexOf(operat)
    indexEq      = vLine.indexOf("=") + 1
    nameFVar     = vLine.substring(indexEq, indexOp).trim()
    nameSVar     = vLine.substring(indexOp + 1, vLine.length()).trim()
    
    if (!isNumeric(nameFVar)){
      if (existVariable(nameFVar))
        variable = getVariable(nameFVar)
            
      else{
          //ERROR
      }
    }
        
    else{
      variable       = new Variable()
      variable.name  = ""
      variable.value = nameFVar
    }
    
    variab += variable
    
    if (!isNumeric(nameSVar)){
      if (existVariable(nameSVar))
        variable = getVariable(nameSVar)
        
      else{
        //ERROR
      }
    }
    
    else{
      variable       = new Variable()
      variable.name  = ""
      variable.value = nameSVar
    }    

    variab += variable
    
    return variab
  }
}