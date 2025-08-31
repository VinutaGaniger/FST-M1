package Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity2 {
	WebDriver driver;
	
  @Test
  public void printHeaderUrl() {
	 String text = driver.findElement(By.xpath("//a[@id='admin_options']")).getText();
	 System.out.println(text);
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
