import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void justPennies() {
    goTo("http://localhost:4567/");
    fill("#userAmount").with("4");
    submit(".btn");
    assertThat(pageSource()).contains("0 Quarter(s), 0 Dime(s), 0 Nickel(s), and 4 Pennie(s)");
  }

  @Test
  public void penniesNickelsDimesAndQuarters() {
    goTo("http://localhost:4567/");
    fill("#userAmount").with("41");
    submit(".btn");
    assertThat(pageSource()).contains("1 Quarter(s), 1 Dime(s), 1 Nickel(s), and 1 Pennie(s)");
  }
}
