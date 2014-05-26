import org.junit.Test;

public class WordNetTest {

  String synset = null;
  String hypernyms = null;

  WordNet wn = new WordNet(synset, hypernyms);
  String word = null;

  String nounA = null;
  String nounB = null;

  @Test
  public void testConstructor() {
    
  }

  @Test
  public void testNoun() {
   wn.nouns();
  }

  @Test
  public void testIsNoun() {
    wn.isNoun(word);
  }

  @Test
  public void testDistance() {
    wn.distance(nounA, nounB);
  }

  @Test
  public void testSap() {
    wn.sap(nounA, nounB);
  }

}
