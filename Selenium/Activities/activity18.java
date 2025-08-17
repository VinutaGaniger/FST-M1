package activities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class activity18 {

	public static void main(String[] args) {
		
     // Create a driver object
	    WebDriver driver = new FirefoxDriver();
			     
    //Open the page 
	    driver.get("https://training-support.net/webelements/alerts");
    //Verify the page title 
		System.out.println("Page title is : " + driver.getTitle());
		
	//Find and click the simple button on the page
		driver.findElement(By.id("simple")).click();
		//Switch focus to the alert
		Alert simpleAlert = driver.switchTo().alert();
		//Print the text from the alert
		System.out.println(simpleAlert.getText());
		//Close the alert
		simpleAlert.accept();
		
		//Print the message
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//close the browser
		driver.quit();

	}

}
