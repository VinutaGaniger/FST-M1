package Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity1 {
	WebDriver driver;
	
  @Test
  public void validateTitle() {
	  String actual = driver.getTitle();
	  String expected = "SuiteCRM";
	  
	  Assert.assertEquals(actual, expected);
  }
  
  @BeforeClass
  public void setUp() {
      // Initialize Firefox driver
      driver = new FirefoxDriver();
      // Open the page
      driver.get("http://alchemy.hguy.co/crm");
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
