import java.util.*;

public class Word {

  private int mId;
  private String mWord;
  private Definition mWordDefinitions;

  private static ArrayList<Word> mDictionary = new ArrayList<Word>();

  public Word(String word){
    mWord = word;
    mWordDefinitions = new Definition();
    mDictionary.add(this);
    mId = mDictionary.size();
  }

  public ArrayList<String> getWordDefintions() {
    return mWordDefinitions.getDef();
  }
  public void addDefintion(String newDef) {
    mWordDefinitions.addDef(newDef);
  }
  public String getWord() {
    return mWord;
  }
  public int getId() {
    return mId;
  }
  public static ArrayList<Word> allWords() {
    return mDictionary;
  }
  public static Word find(int id) {
    try {
      return mDictionary.get(id - 1);
    }
    catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}
