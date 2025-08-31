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

public class Activity9 {
	WebDriver driver;
	WebDriverWait wait;
	
	  @BeforeClass
	    public void setUp() {
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("http://alchemy.hguy.co/crm");
	    }

	    @Test
	    public void printLeadsNamesAndUsers() {
	        // Login
	        driver.findElement(By.id("user_name")).sendKeys("admin");
	        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
	        driver.findElement(By.xpath("//input[@name='Login']")).click();

	        // Wait for dashboard and click Sales -> Leads
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tab0")));
	        driver.findElement(By.xpath("//a[text()='Sales']")).click();
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Leads']"))).click();

	        // Wait for table to load
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[contains(@class,'table-responsive')]/tbody")));

	        // Get all table rows
	        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'table-responsive')]/tbody/tr"));

	        System.out.println("First 10 Leads:");

	        for (int i = 0; i < 10 && i < rows.size(); i++) {
	            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
	            String name = cells.get(2).getText();  // 3rd column is usually Name
	            String user = cells.get(7).getText();  // 8th column is usually Assigned User
	            System.out.println("Name: " + name + ", User: " + user);
	        }
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	}