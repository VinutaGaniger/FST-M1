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
import java.util.List;

public class Activity8 {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void printHeaderUrl() throws InterruptedException {
     driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
     driver.findElement(By.xpath("//input[@id='username_password']")).sendKeys("pa$$w0rd");
     driver.findElement(By.xpath("//input[@name='Login']")).click();
     
     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab0")));
     driver.findElement(By.xpath("//a[text()='Sales']")).click();
     
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Accounts']"))).click();

     // Wait for table to load
     wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class, 'list view')]/tbody")));

     // Get all table rows
     List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'list view')]/tbody/tr"));

     System.out.println("Printing names from the first 5 odd-numbered rows:");

     int count = 0;
     for (int i = 0; i < rows.size() && count < 5; i++) {
         if (i % 2 == 0) {  // 0-based index: 0, 2, 4 = 1st, 3rd, 5th rows
             WebElement nameCell = rows.get(i).findElement(By.xpath("./td[3]"));
             String name = nameCell.getText();
             System.out.println("Row " + (i + 1) + " - Account Name: " + name);
             count++;
         }
     }

     Thread.sleep(3000); // just for visual pause
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
