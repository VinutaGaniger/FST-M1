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

public class Activity7 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void printHeaderUrl() throws InterruptedException {
     driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
     driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
     driver.findElement(By.xpath("//input[@name='Login']")).click();
     
     WebElement tab = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab0")));
     driver.findElement(By.xpath("//a[text()='Sales']")).click();
     
     WebElement leads = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[text()='Leads'])[1]")));
     driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
     
     WebElement additional = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@title='Additional Details'])[1]")));
     driver.findElement(By.xpath("(//span[@title='Additional Details'])[1]")).click();
     
     WebElement phone = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='phone'])[1]")));
     String mobile = driver.findElement(By.xpath("(//span[@class='phone'])[1]")).getText();
     System.out.println("Phone is:" + mobile);
     Thread.sleep(10000);
     
     
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
