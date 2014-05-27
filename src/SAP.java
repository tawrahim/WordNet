/**
 * The SAP class
 * @author tawheedabdul-raheem
 *
 */
public class SAP {
  
  /**
   * 
   * @param G
   */
  public SAP(Digraph G) {
    
  }
  
  /**
   * length of shortest ancestral path between v 
   * and w; -1 if no such path
   * @param v
   * @param w
   * @return
   */
  public int length(int v, int w) {
    return -1;
  }
  
  /**
   * a common ancestor of v and w that participates in a 
   * shortest ancestral path; -1 if no such path 
   * @param v
   * @param w
   * @return
   */
  public int ancestor(int v, int w) {
    return -1;
  }
  
  /**
   * a common ancestor that participates in shortest ancestral 
   * path; -1 if no such path
   * @param v
   * @param w
   * @return
   */
  public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
    return -1;
  }
  /**
   * length of shortest ancestral path between any vertex in v 
   * and any vertex in w; -1 if no such path
   * @param v
   * @param w
   * @return
   */
  public int length(Iterable<Integer> v, Iterable<Integer> w) {
    return -1;
  }

}
