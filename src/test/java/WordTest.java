import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class WordTest {
  @After
  public void tearDown() {
    Word.mDictionary.clear();
  }
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
    // assertThat will check if true and allow us to addDefintion
    yourApp.addDefintion("a unit of language");
    yourApp.addDefintion("to talk briefly");
    assertEquals(expected, yourApp.getWordDefintions());
  }
  @Test
  public void testWordClass_allwordsBlank() {
    ArrayList<Word> expectedBlankArrayList = new ArrayList<Word>();
    assertEquals(expectedBlankArrayList.size(), Word.allWords().size());
  }
  @Test
  public void testWordClass_allwords() {
    Word first = new Word("zebra");
    Word second = new Word("city");
    Word third = new Word("abacus");
    Word fourth = new Word("swim");
    // ids go in order of instantiation
    ArrayList<Word> expectedArrayList = new ArrayList<Word>();
    expectedArrayList = Word.allWords();
    // clear all words once saced to new ArrayList
    Word.mDictionary.clear();
    // assertThat will check if true and allow us to instantiate Word
    Word one = new Word("zebra");
    Word two = new Word("city");
    Word three = new Word("abacus");
    Word four = new Word("swim");
    //now test
    assertEquals(expectedArrayList, Word.allWords());
  }
}
