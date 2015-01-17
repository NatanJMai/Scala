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
}