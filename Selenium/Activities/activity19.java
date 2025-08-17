package activities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class activity19 {

	public static void main(String[] args) {
		 // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

            
      //Open the page 
	    driver.get("https://training-support.net/webelements/alerts");
    //Verify the page title 
		System.out.println("Page title is : " + driver.getTitle());
		
	//Find and click the simple button on the page
		driver.findElement(By.id("confirmation")).click();
		//Switch focus to the alert
		Alert confirmAlert = driver.switchTo().alert();
		//Print the text from the alert
		System.out.println(confirmAlert.getText());
		//Close the alert
		confirmAlert.accept();
		
		//Print the message
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//close the browser
		driver.quit();

	}

}
