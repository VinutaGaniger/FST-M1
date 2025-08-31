package Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity4 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void printHeaderUrl() {
     driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
     driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
     driver.findElement(By.xpath("//input[@name='Login']")).click();
     
     WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab0")));
     
     String loginMessage = driver.findElement(By.id("tab0")).getText();
     Assert.assertEquals(loginMessage ,"SUITECRM DASHBOARD");
  }
  
  @BeforeClass
  public void setUp() {
      // Initialize Firefox driver
      driver = new FirefoxDriver();
      
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      // Open the page
      driver.get("http://alchemy.hguy.co/crm");
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }

}
