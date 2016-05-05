import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  @Test
  public void testWord_ConstructorObjectInstantiation() {
    Word yourApp = new Word("test");
    assertThat(yourApp);
  }
  @Test
  public void testWord_getword() {
    Word yourApp = new Word("word");
    String expected = "word";
    assertEquals(expected, yourApp.getWord());
  }
  @Test
  public void testWord_getId() {
    Word yourApp = new Word("word");
    int expected = 1;
    assertEquals(expected, yourApp.getId());
  }
  @Test
  public void testWord_getWordDefintions() {
    Word yourApp = new Word("word");
    ArrayList<String> expectedBlankArrayList = new ArrayList<String>();
    assertEquals(expectedBlankArrayList, yourApp.getWordDefintions());
  }
  @Test
  public void testWord_addDefintions() {
    Word yourApp = new Word("word");
    boolean functionPassed = true;
    ArrayList<String> expected = new ArrayList<String>();
    expected.add("a unit of language");
    expected.add("to talk briefly");

    assertThat(yourApp.addDefintion("a unit of language"));
    assertThat(yourApp.addDefintion("to talk briefly"));
    assertEquals(expectedAddedDefintion, yourApp.getWordDefintions());
  }

  //
  // @Test
  // public void testWord_ConstructorAll() {
  //   Word yourApp = new Word("word");
  //   String expected = "word";
  //   assertEquals(expected, yourApp.getWord());
  // }
  //
  //
  // @Test
  // public void testConstructor() {
  //   Word yourApp = new Word("word");
  //   String expected = "word";
  //   assertEquals(expected, yourApp.getWord());
  // }
}
