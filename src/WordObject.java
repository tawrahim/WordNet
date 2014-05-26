import java.util.ArrayList;

/**
 * The word Object holds information
 * about the word net entry
 * @author tawheedabdul-raheem
 *
 */
public class WordObject {
  
  private int id;
  private String sentence;
  private ArrayList<String> synonyms;
  
  /**
   * Constructor
   * @param id
   * @param sentence
   * @param synonyms
   */
  public WordObject(int id, String sentence, ArrayList<String> synonyms) {
    this.id = id;
    this.sentence = sentence;
    this.synonyms = synonyms;
  }

  /**
   * @return the id
   */
  public int getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * @return the sentence
   */
  public String getSentence() {
    return sentence;
  }

  /**
   * @param sentence the sentence to set
   */
  public void setSentence(String sentence) {
    this.sentence = sentence;
  }

  /**
   * @return the synonyms
   */
  public ArrayList<String> getSynonyms() {
    return synonyms;
  }

  /**
   * @param synonyms the synonyms to set
   */
  public void setSynonyms(ArrayList<String> synonyms) {
    this.synonyms = synonyms;
  }

}
