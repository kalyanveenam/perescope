package AutomationTest.BrightTalkTest;

import static AutomationTest.BrightTalkTest.LoadProp.getproperty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;


public class HomePage extends BasePage {

	@BeforeMethod
	public void init() {
	 WebDriver driver;
	 System.setProperty("webdriver.chrome.driver","/Users/kalyan/Desktop/chromedriver");
	 driver = new ChromeDriver();
	 driver.get("www.google.com");
	}
	
    public static void homePage() {
    	
    	
    	
    	
        driver.get(getproperty("url"));
    }
}


