/**
 * ***********************************************************
 * |
 * |   NAME  : natanjmai
 * |   DATE  : Jan 17, 2015
 * |   PHONE : 
 * |   FILE  : Verifications.scala
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
import scala.actors.Exit

class Verifications {
  
 /** This function check if the sentences author 
   * and email exists
   * These sentences needed are in the first line 
   **/
  
  def checkFirstLine(vFile:File):Boolean = {
    
    var indexEq:Int = vFile.arrLine(0).indexOf("=") + 1
    
    if ((vFile.arrLine(0) != "@author") && (!vFile.arrLine(0).contains("=")))
      return false
    
    if ((vFile.arrLine(1) != "@email") && (!vFile.arrLine(1).contains("=")))
      return false
    
    vFile.author = vFile.arrLine(0).substring(indexEq, vFile.arrLine(0).length()).trim()   
    vFile.email  = vFile.arrLine(1).substring(indexEq, vFile.arrLine(1).length()).trim()
    
    return true
  }

/** 
  *  This function check if the sentence "def var" exist. 
  *  If exist, is created a new variable. 
  **/
  
  def containsDefine(vFile:File, line : String){
    if (line.contains("def var") && (line.contains("="))){
      var variable   = new Variable()
      def indexEql   = line.indexOf("=")   + "=".length()
      def indexVar   = line.indexOf("var") + "var".length() 
      
      variable.name  = line.substring(indexVar, indexEql - 1).trim()
      variable.value = line.substring(indexEql, line.length()).trim() 
      variable.use   = true
      
      vFile.variables += variable  
    }
  }
  
/** 
  *  This function check if the sentence "assign" exist. 
  *  If exist, is assigned a new valor to the variable. 
  **/
  
  def containsAssign(vFile:File, line:String){
    if (line.contains("assign") && (line.contains("="))){
      var name       : String = ""
      var value      : String = ""
      var indexEql   = line.indexOf("=")      + "=".length()
      var indexAsg   = line.indexOf("assign") + "assign".length()
      
      name  = line.substring(indexAsg, indexEql - 1).trim()
      value = line.substring(indexEql, line.length()).trim()
      
      if (!vFile.existVariable(name)){
        println("Variable not exist!")
        Exit
      }
      
      var variable = vFile.getVariable(name)
      variable.setName(name)
      
      containsOperat(vFile, line, indexEql)
      
      //variable.setValue(value)
      
    }
  }
  
/**  
  *  This function check if exists any operator. 
  **/
  
  def containsOperat(vFile:File, line:String, indexEq:Int):String = {
    var indexOp    :Int    = 0
    var nameFVar   :String = ""
    var nameSVar   :String = ""
    var operation          = new Operation()
    
    for (operat <- vFile.arrOperations){
      if (line.contains(operat.typeOP)){
        indexOp   = line.indexOf(operat.typeOP)
        nameFVar  = line.substring(indexEq, indexOp).trim()
        nameSVar  = line.substring(indexOp + 1, line.length()).trim()
        
        if (vFile.existVariable(nameFVar) || (vFile.existVariable(nameSVar))){
          if (vFile.existVariable(nameFVar)){
            var variable = vFile.getVariable(nameFVar)
            
            operat.variables += variable
          }
          
          if (vFile.existVariable(nameSVar)){
            var variable = vFile.getVariable(nameFVar)
            
            operat.variables += variable
          }
          
          operat.run()
        }
        
        for(x <- operat.variables)
          println(x.value)
        
        println(operat.result)
        
        if (isNumeric(nameFVar)){
          
        }
      }
    }
    
    println(nameFVar, nameSVar)
    
    return ""
  }
  
  def isNumeric(nameVar: String): Boolean = nameVar.forall(_.isDigit)
  
  def manyOthers(vFile:File) = {
    /* All lines since the second line. */
    for(line <- 1 to vFile.arrLine.length - 1){
      containsDefine(vFile, vFile.arrLine(line))
      containsAssign(vFile, vFile.arrLine(line))
    }
    
  }
  
  
}