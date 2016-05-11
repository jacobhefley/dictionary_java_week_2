import java.util.*;

public class Definition {

  private ArrayList<String> mDefinitions = new ArrayList<String>();

  public Definition(){
    mDefinitions = new ArrayList<String>();
  }

  public Definition(String def){
    String temp = def;
    mDefinitions.add(temp);
  }

  public void addDef(String newDef){
    String temp = newDef;
    mDefinitions.add(temp);
  }

  public ArrayList<String> getDef() {
    return mDefinitions;
  }

}
