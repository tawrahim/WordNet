import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * WordNet Class
 * 
 * @author tawheedabdul-raheem
 * 
 */
public class WordNet {

  private ArrayList<String> nouns = new ArrayList<>();
  private Digraph wordGraph;
  private HashMap<Integer, WordObject> map = new HashMap<>();

  /**
   * Constructor does a lot of work by building our
   * required data structures
   * Computation Cost:
   *                 All the time: O(E^2)
   * The cost is O(E^2) because we are processing two
   * inputs. A better optimization would be to try and
   * get it down to O(E) by combining the processing
   * @param synset
   * @param hypernyms
   */
  public WordNet(String synset, String hypernyms) {
    In synsetEntries = new In(synset);
    In hypernymsEntries = new In(hypernyms);

    int id;
    String sentence;
    String line;
    String[] temp;
    

    // Process the synset
    while (synsetEntries.hasNextLine()) {
      line = synsetEntries.readLine();
      temp = line.split(",");
      
      // get the id of the synset
      id = Integer.parseInt(temp[0]);
      
      // get the meaning of word
      sentence = temp[1];
      
      // get the synonyms
      String [] synonymArray = temp[2].split(" ");
      ArrayList<String> synonyms = new ArrayList<>();

      // build word list array
      for (int i = 0; i < synonymArray.length; i++) {
        synonyms.add(synonymArray[i]);
        
        // Also add the noun to our giant noun array list
        // make sure that there are no duplicates
        if (!nouns.contains(synonymArray[i])) {
          nouns.add(synonymArray[i]);
        }
          
      }
      
      // Make a new instance of word Object
      WordObject wo = new WordObject(id, sentence, synonyms);
      map.put(id, wo);
    }

    // Build the graph
    if (map != null) {
      wordGraph = new Digraph(map.size());
      
      // process the hypernyms
      while (hypernymsEntries.hasNextLine()) {
        line = hypernymsEntries.readLine();
        temp = line.split(",");
        id = Integer.parseInt(temp[0]);

        for (int i = 1; i < temp.length; i++) {
          wordGraph.addEdge(id, Integer.parseInt(temp[i]));
        }
      }
    }
  }

  /**
   * Finds the actual id of a given word
   * Computation cost:
   *               Worst case: O(E)
   *               Best case: O(1)
   *               Average Case: O(E/2)
   * @param word
   * @return
   */
  public int wordObj(String word) {
    for (final Entry<Integer, WordObject> entry : map.entrySet()) {
      int key = entry.getKey();
      if (map.get(key).getSynonyms().contains(word)) return key;
    }
    return -1;
  }
  
  /**
   * Checks to see whether a given word is a noun
   * Basically does it exist in our List
   * Computation cost:
   *                  All the time: O(1)
   * @param word
   * @return
   */
  public boolean isNoun(String word) {
    if (nouns != null) {
      if (nouns.contains(word)) return true;
    }
    return false;
  }
  
  /**
   * Call the sap method to get distance between two points
   * @param nounA
   * @param nounB
   * @return
   */
  public int distance(String nounA, String nounB) {
    return sap(nounA, nounB);
  }

  /**
   * Shortest ancestral path between two points is tricky 
   * Current implementation is O(E^2) in the worst case
   *  which is very BAD!!!
   * It takes E to find nounA and another E to find nounB
   * @param nounA
   * @param nounB
   */  
  public int sap(String nounA, String nounB) {
    if (nounA == null || nounB == null) return -1;
    if (!isNoun(nounA) || !isNoun(nounB)) return -1;
    
    int nounAKey = wordObj(nounA);
    int nounBKey = wordObj(nounB);
    return 1;
  }

  /**
   * @return the nouns
   */
  public ArrayList<String> nouns() {
    return nouns;
  }

}
