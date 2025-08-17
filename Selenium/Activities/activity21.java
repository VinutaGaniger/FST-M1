package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class activity21 {

	public static void main(String[] args) {
		
			 // Create a new instance of the Firefox driver
	        WebDriver driver = new FirefoxDriver();
	     // Create the Wait object
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            
	      //Open the page 
		    driver.get("https://training-support.net/webelements/tabs");
	    //Verify the page title 
			System.out.println("Page title is : " + driver.getTitle());
			
			
			// Print the handle of the parent window
	        System.out.println("Current tab: " + driver.getWindowHandle());

	       
			
	}

}
