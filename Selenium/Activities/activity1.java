package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class activity1 {

	public static void main(String[] args) {
		 // Create a driver object
	       WebDriver driver = new FirefoxDriver();
	     //Open the page 
	       driver.get("https://training-support.net");
	     //Verify the page title 
	       System.out.println("Page title is : " + driver.getTitle());
	       
	     //Find and click About us page
	       driver.findElement(By.linkText("About Us")).click();
	     //Print the title of new page 
	       System.out.println("New Page title is : " + driver.getTitle());
	     //close the browser
	     //driver.close(); //will close the currently active tab
	     driver.quit();// 

	}

}
