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
    
    if (vFile.arrLine(0) != "@author") 
      return false
    
    if (vFile.arrLine(1) != "@email")
      return false
    
    vFile.email  = true
    vFile.author = true
      
    return true
  }
}