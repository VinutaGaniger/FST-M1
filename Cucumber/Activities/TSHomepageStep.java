package stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class TSHomepageStep extends BaseClass {
	@Given("user is on the TS homepage")
	 public void openTSPage() {
		//open the TS Page
		driver.get("https://training-support.net");
		
		//Assertion
		assertEquals(driver.getTitle(), "Training Support");
		
	}
    
	@When("the user clicks on the About Us link")
	public void clickAboutsUs() {
		//Find and click About Us Page 
		driver.findElement(By.linkText("About Us")).click();
		
	}

	@Then("they are redirected to another page")
	public void verifyNewPage() {
		//Verify new page 
		assertEquals(driver.getTitle(), "About Training Support");
	}
		
	}


