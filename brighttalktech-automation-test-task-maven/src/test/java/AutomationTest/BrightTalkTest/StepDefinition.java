package AutomationTest.BrightTalkTest;

import cucumber.api.java.en.Given;

import static AutomationTest.BrightTalkTest.HomePage.homePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class StepDefinition {
 
    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
    	
           homePage();
    }
}

