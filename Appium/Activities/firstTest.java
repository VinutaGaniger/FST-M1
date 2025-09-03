package example;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class firstTest {
    //Declaring the required objects 
	AppiumDriver driver;
	WebDriverWait wait;
	
	
	//setup function
	@BeforeClass
	public void setUp() {
		UiAutomator2Options options= new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.noReset();
		//options.setApp("C:\\Users\\VinutaGaniger\\Downloads\\Calculator.apk\");
	
        //ONLY for android
		options.setAppPackage("com.miui.calculator");
		options.setAppActivity(".cal.Calculator");
	}
	
	
}
