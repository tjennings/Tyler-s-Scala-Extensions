import java.lang.reflect.Method


/**
* A simple object that lets you discover the capabilities of other objects 
* without referring to documentation immediately. Inspired by Ruby's elegant reflection.
*   
* Usage: 
* import MethodDiscovery._
*
* val aString = "Hello, folks"
* namesOf(methods(aString))
* signaturesOf(methods(aString))
*
*/
object MethodDiscovery {
  def methods(o: AnyRef): List[Method] = {
    List.fromArray(o.getClass.getMethods)
  }
  
  def declaredMethods(o: AnyRef): List[Method] = {
    List.fromArray(o.getClass.getDeclaredMethods)
  }
  
  def namesOf(l: List[Method]): List[String] = {
    sort(l.map(m => m.getName))
  }
  
  def signaturesOf(l: List[Method]): List[String] = {
    sort(l.map(formatSig))
  }
  
  def sort(l: List[String]): List[String] = {
    l.sort((a, b) => (a compareTo b) < 0 )
  }
    
  def formatSig(m: Method): String = {
    m.getName + 
    List.fromArray(m.getParameterTypes).map(c => c.getName).mkString("(", ", ", "): ") + 
    m.getReturnType.getName
  }
}
