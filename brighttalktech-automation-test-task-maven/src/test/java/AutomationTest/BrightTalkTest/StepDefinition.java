package AutomationTest.BrightTalkTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static AutomationTest.BrightTalkTest.HomePage.homePage;
import static AutomationTest.BrightTalkTest.HTTPMethods.getResponseStatus;
import static AutomationTest.BrightTalkTest.HTTPMethods.getResponseBodyFromBaseurl;


public class StepDefinition {
	
	String baseUrl="https://reqres.in/api";
 
    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
    	
           homePage();
    }
    @Given("^I get the default list of users for on 1st page$")
    public void getDefaultListOfUsers() {
    System.out.println(	getResponseBodyFromBaseurl(baseUrl+"/users?page=1"));
    	
    
    }
    @When ("^I get the list of all users$")
    public void getFirstPageListOfUsers() {
    	
    }
    @Then("^I should see total users count equals to number of user ids$")
    public void verifyUserCount() {
    	  System.out.println("get total users");
    	     	
    	//
    }
}

