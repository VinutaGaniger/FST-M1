package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
	public class Activity1 {
	    //Declaring the required objects 
		AppiumDriver driver;
		WebDriverWait wait;
		
		
		//setup function
		@BeforeClass
		public void setUp() throws MalformedURLException, URISyntaxException {
			UiAutomator2Options options= new UiAutomator2Options();
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			options.noReset();
			options.setApp("C:/Users/VinutaGaniger/Downloads/Calculator.apk");
		
	        //ONLY for android
			//options.setAppPackage("com.miui.calculator");
			//options.setAppActivity(".cal.Calculator");
			
			//Server Address
			URL serverURL = new URI("http://localhost:4723").toURL();
			
			//Driver Initialization
			driver = new AndroidDriver(serverURL, options);
		}
		@Test
		public void multiplyTest() {
			//Find and tap the digit 2
			driver.findElement(AppiumBy.id("digit_2")).click();
			//Find and tap the multiply symbol
			driver.findElement(AppiumBy.accessibilityId("multiply")).click();
			//Find and tap the digit 5
			driver.findElement(AppiumBy.id("digit_5")).click();
			//Find and tap the equals symbol
			driver.findElement(AppiumBy.accessibilityId("equals")).click();
		    String result = driver.findElement(AppiumBy.id("result_final")).getText();		
		    // assertion
		Assert.assertEquals(result ,"10");
		}
		//Tear down method
		@AfterClass
		public void teardown() {
			//close the app
			driver.quit();
		}
	}

