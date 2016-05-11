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

public class DefinitionTest {
  @Test
  public void testDefinition_ConstructorObjectInstantiation() {
    Definition yourApp = new Definition();
    assertThat(yourApp);
  }

  @Test
  public void testDefinition_Constructor() {
    Definition yourApp = new Definition("new");
    assertEquals(1, yourApp.getDef().size());
  }

  @Test
  public void testDefinition_addDef() {
    Definition yourApp = new Definition();
    yourApp.addDef("new");
    assertEquals(1, yourApp.getDef().size());
  }

  @Test
  public void testDefinition_getDef() {
    Definition yourApp = new Definition();
    yourApp.addDef("new");
    ArrayList<String> expected = new ArrayList<String>();
    expected.add("new");
    assertEquals(expected, yourApp.getDef());
  }

}
