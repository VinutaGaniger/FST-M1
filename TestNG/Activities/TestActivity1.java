package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestActivity1 {
	//Declare the object
	   WebDriver driver;
	 //Declare the wait object
	   WebDriverWait wait;
	   
	 //Firefox Setup fuction
	   @BeforeClass
	   public void setUp() {
		   //Initialize the driver
		   driver = new FirefoxDriver();
		   //Initialize the wait 
		   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		   //Open the Page
		   driver.get("https://training-support.net");
		   
	   }
	   @Test(priority = 1)
	   public void homePageTest() {
		   //Assertion for page title 
		   Assert.assertEquals(driver.getTitle(), "Training Support");
	   }

	   @Test(priority = 2)
	   public void aboutPageTest() {
		   //Find and click the About Us link
		   driver.findElement(By.linkText("About Us")).click();
		   //Assertion for page title 
		   Assert.assertEquals(driver.getTitle(), "About Training Support");
	   }
		  //Browser clean up function
	   @AfterClass
	   public void tearDown() {
		   //Close the brower
		   driver.quit();
	   }
}


