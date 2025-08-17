package activities;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestActivity2 {
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
		   driver.get("https://training-support.net/webelements/login-form");
		   
	   }
	   @Test(priority = 1)
	   
	   public void pageTitleTest() {
		   //Assertion for page title 
		   assertEquals(driver.getTitle(), "Selenium: Login Form");
		   
	   }
	   
	   @DataProvider(name = "InvalidCredentials")
	   public Object[][] creds() {
		   return new Object[][] {
			   { "admin", "incorrectPassword"},
			   {"incorrectAdmin", "password"},
			   {"admin", "@#%&$**(("},
			   {"DELECT TABLE user;" , "password"}
			   };
		   }
	   
	   
	   @Test(priority = 2, dataProvider = "InvalidCredentials")
	   public void invalidLoginTest(String username, String password) {
		   //Find the username, password and submit elements
		   WebElement usernameField = driver.findElement(By.id("username"));
		   WebElement passwordField = driver.findElement(By.id("password"));
		   WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
		   
		   //clear the input fields
		   usernameField.clear();
		   passwordField.clear();
		   
		   //Enter the username and password
		   usernameField.sendKeys(username);
		   passwordField.sendKeys(password);
		   //click the submit button
		   submitButton.click();
		   
		   //Assertion
		   String message = driver.findElement(By.id("subheading")).getText();
		   assertEquals(message, "Invalid credentials");
	   } 
		   @Test(priority = 3)
		   public void validLoginTest() {
			   //Find the username, password and submit elements
			   WebElement usernameField = driver.findElement(By.id("username"));
			   WebElement passwordField = driver.findElement(By.id("password"));
			   WebElement submitButton = driver.findElement(By.xpath("//button[text()='Submit']"));
			   
			   //clear the input fields
			   usernameField.clear();
			   passwordField.clear();
			   
			   //Enter the username and password
			   usernameField.sendKeys("admin");
			   passwordField.sendKeys("password");
			   //click the submit button
			   submitButton.click();
			   
			   //Assertion
			  String message = driver.findElement(By.cssSelector("h2.text-gray-800")).getText();
			   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.text-gray-800")));
			   assertEquals(message, "Welcome Back, Admin!");
		   }
			   
	   @AfterClass
	   public void tearDown() {
		   //Close the brower
		   driver.quit();
	   }
}

