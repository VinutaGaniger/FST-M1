package activities;


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



public class TestActivity7 {
	
	
	    WebDriver driver;
	    WebDriverWait wait;

	    @BeforeClass
	    public void setUp() {
	        // Initialize driver
	        driver = new FirefoxDriver();
	        // Initialize wait
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        // Open the page
	        driver.get("https://training-support.net/webelements/login-form");
	    }

	    @DataProvider(name = "invalidCredentials")
	    public static Object[][] creds() {
	        return new Object[][] { 
	            { "admin1", "password1"},
	            { "wrongAdmin", "wrongPassword" }
	        };
	    }

	    @Test(dataProvider = "invalidCredentials",priority=1)
	    public void invalidloginTest(String username, String password) {
	        // Find the input fields and the login button
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));

	        // Clear the input fields
	        usernameField.clear();
	        passwordField.clear();
	        // Enter the credentials and click Log in
	        usernameField.sendKeys(username);
	        passwordField.sendKeys(password);
	        loginButton.click();

	        // Assert login message
	        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("subheading"))));
	        String loginMessage = driver.findElement(By.id("subheading")).getText();
	        Assert.assertEquals(loginMessage, "Invalid credentials");
	    }
	    @Test(priority=2)
	    public void validloginTest() {
	        // Find the input fields and the login button
	        WebElement usernameField = driver.findElement(By.id("username"));
	        WebElement passwordField = driver.findElement(By.id("password"));
	        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));

	        // Clear the input fields
	        usernameField.clear();
	        passwordField.clear();
	        // Enter the credentials and click Log in
	        usernameField.sendKeys("admin");
	        passwordField.sendKeys("password");
	        loginButton.click();

	        // Assert login message
	        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back')]"))));
	        String loginMessage = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back')]")).getText();
	        Assert.assertEquals(loginMessage, "Welcome Back,Admin!");
	    }

	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
}

