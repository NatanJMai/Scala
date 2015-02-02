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
      var name       : String    = ""
      var value      : String    = ""
      var variable   : Variable  = null      
      var operation  : Operation = null
      var indexEql   = line.indexOf("=")      + "=".length()
      var indexAsg   = line.indexOf("assign") + "assign".length()
      
      name  = line.substring(indexAsg, indexEql - 1).trim()
      value = line.substring(indexEql, line.length()).trim()
      
      if (!vFile.existVariable(name)){
        println("Variable " + name + " not exist!")
        Exit
      }
      
      variable = vFile.getVariable(name)
      variable.setName(name)
      
      operation = new Operation()
      operation.run(vFile, line)
      
      variable.setValue(operation.result.toString())
      
    }
  }
 
  def containsDisplay(vFile:File, line:String){
    if (line.contains("disp") && line.contains("#")){
      var disp = new Display(line.replaceFirst("disp", "").trim())
      disp.display(vFile)
    }
  } 
  
  def containsSystem(vFile:File, line:String){
    
    
    
    
    
    
  }
  
  def lowerCase(vFile:File) = {
    for (str <- 0 to vFile.arrLine.length - 1)
      vFile.arrLine(str) = vFile.arrLine(str).toLowerCase()
  }
  
/**
  * Is Numeric?  
  * 
  **/
  
  def isNumeric(nameVar: String): Boolean = nameVar.forall(_.isDigit)
  
  def verifyLines(vFile:File) = {
    for(vLine <- vFile.arrLine){
      if (!vLine.contains("&")){
        containsDefine(vFile, vLine)
        containsAssign(vFile, vLine)
        containsDisplay(vFile, vLine)
        containsSystem(vFile, vLine)
      }
    }
  }
  
  def mainChecks(vFile:File) = {
    lowerCase(vFile)
    
    verifyLines(vFile)
  }
}