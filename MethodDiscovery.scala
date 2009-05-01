import java.lang.reflect.Method

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
