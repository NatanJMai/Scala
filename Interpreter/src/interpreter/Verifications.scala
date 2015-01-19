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

class Verifications {
  
 /** This function check if the sentences @author 
   * and @email exists
   * These sentences needed are in the first line 
   **/
  
  def verifyFirstLine(vFile:File):Boolean = {
    
    var indexEq:Int = vFile.arrLine(0).indexOf("=") + 1
    
    if ((vFile.arrLine(0) != "@author") && (!vFile.arrLine(0).contains("=")))
      return false
    
    if ((vFile.arrLine(1) != "@email") && (!vFile.arrLine(1).contains("=")))
      return false
    
    vFile.author = vFile.arrLine(0).substring(indexEq, vFile.arrLine(0).length()).trim()   
    vFile.email  = vFile.arrLine(1).substring(indexEq, vFile.arrLine(1).length()).trim()
    
    return true
  }

  def containsDefine(vFile:File, line : String){
    if (line.contains("def var") && (line.contains("="))){
      var variable   = new Variable()
      def indexEql   = line.indexOf("=")   + "=".length()
      def indexVar   = line.indexOf("var") + "var".length() 
      
      variable.name  = line.substring(indexVar, indexEql - 1).trim()
      variable.value = line.substring(indexEql, line.length()).trim() 
      
      vFile.variables += variable  
    }
  }
  
  def manyOthers(vFile:File) = {
    
    /* All lines since the second line. */
    for(line <- 1 to vFile.arrLine.length - 1){
      containsDefine(vFile, vFile.arrLine(line))
    }
    
  }
  
  
}