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

public class AppTest extends FluentTest {
  @After
  public void tearDown() {
    Word.mDictionary.clear();
  }
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void _BlankInitialization() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Basic Java Spark/Velocity Dictionary");
    assertThat(pageSource()).contains("Add Word:");
  }
  @Test
  public void _AddWord() {
    goTo("http://localhost:4567/");
    fill("#word").with("Word");
    submit(".btn");
    click("a", withText("Back to Main"));
    assertThat(pageSource()).contains("Word");
  }
  @Test
  public void _AddWordWithDefinition() {
    goTo("http://localhost:4567/");
    fill("#word").with("Word");
    submit(".btn");
    click("a", withText("Back to Main"));
    assertThat(pageSource()).contains("Word");
    click("a", withText("Word"));
    fill("#definition").with("a unit of language");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Word"));
    assertThat(pageSource()).contains("a unit of language");
  }
  @Test
  public void _AddWordsWithDefinitions() {
    goTo("http://localhost:4567/");
    fill("#word").with("Word");
    submit(".btn");
    click("a", withText("Back to Main"));
    assertThat(pageSource()).contains("Word");
    click("a", withText("Word"));
    fill("#definition").with("a unit of language");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Word"));
    fill("#definition").with("to talk briefly");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    // word 2
    fill("#word").with("Zebra");
    submit(".btn");
    click("a", withText("Back to Main"));
    assertThat(pageSource()).contains("Zebra");
    click("a", withText("Zebra"));
    fill("#definition").with("an animal");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    click("a", withText("Zebra"));
    fill("#definition").with("species of African equids");
    submit(".btn");
    click("a", withText("Add Word/View Words"));
    //check
    click("a", withText("Word"));
    assertThat(pageSource()).contains("a unit of language");
    assertThat(pageSource()).contains("to talk briefly");
    webDriver.navigate().back();
    click("a", withText("Zebra"));
    assertThat(pageSource()).contains("an animal");
    assertThat(pageSource()).contains("species of African equids");
  }
}
