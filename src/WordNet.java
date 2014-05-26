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

  private Bag<String> nouns;
  private Digraph wordGraph;
  private HashMap<Integer, WordObject> map = new HashMap<>();
  private int objId;

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

      // build world list array
      for (int i = 0; i < synonymArray.length; i++) {
        synonyms.add(synonymArray[i]);
        
        // Also add the noun to our giant noun bag
        nouns.add(synonymArray[i]);
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
   * Computation cost is the number of Edges (E)
   * @param word
   * @return
   */
  public boolean isNoun(String word) {
    boolean found = false;
    for (Entry<Integer, WordObject> entry : map.entrySet()) {
      int key = entry.getKey();
      
      if (map.get(key).getSynonyms().contains(word)) {
        found = true;
        objId = key;
      }
    }
    return found;
  }
  
  /**
   * Distance between two points is tricky 
   * Current implementation is E^2 which is very BAD!
   * It takes E to find nounA and another E to find nounB
   * @param nounA
   * @param nounB
   */
  public void distance(String nounA, String nounB) {
    if (nounA == null || nounB == null) return;
    
    // finding nounA also modifies the objectId so we
    // store it in a key
    isNoun(nounA);
    int nounAKey = objId;
    
    // finding nounA also modifies the objectId so we
    // store it in a key
    isNoun(nounB);
    int nounBKey = objId;
    
    // Now we call the depth first search on the two id's
    
  }

  public void sap(String nounA, String nounB) {

  }

  /**
   * @return the nouns
   */
  public Bag<String> nouns() {
    return nouns;
  }

}
