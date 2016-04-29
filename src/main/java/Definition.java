// import java.util.*;

public class Definition {
  ArrayList<String> mDefinitions = new ArrayList<>();
	String mLastDefinition;
	private int hash;

  public Definition(String d){
  ArrayList<String> mDefinitions = new ArrayList<>();
    mLastDefinition = d;
    mDefinitions.add(mLastDefinition);
  }

  public Definition addDefinition(String newD){
  	mLastDefinition = newD;
  	mDefinitions.add(mLastDefinition);
  	return mDefinitions;
  }
}
