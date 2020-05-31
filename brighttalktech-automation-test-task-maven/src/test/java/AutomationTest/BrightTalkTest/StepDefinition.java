package AutomationTest.BrightTalkTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;

import static AutomationTest.BrightTalkTest.HomePage.homePage;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import static AutomationTest.BrightTalkTest.HTTPMethods.getResponseStatus;
import static AutomationTest.BrightTalkTest.HTTPMethods.getResponseBodyFromBaseurl;
import static AutomationTest.BrightTalkTest.HTTPMethods.getPathValue;
import static AutomationTest.BrightTalkTest.HTTPMethods.isResponseContainsKey;
import static AutomationTest.BrightTalkTest.HTTPMethods.getJsonResponseAsString;


public class StepDefinition {
	
	String baseUrl="https://reqres.in/api";
 
    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() {
    	
           homePage();
    }
    @Given("^I get the default list of users for on 1st page$")
    public void getDefaultListOfUsers() throws JSONException {
    	String respose=getJsonResponseAsString(baseUrl+"/users?page=1");
    
    	
    	
         // convert to json object
    	  JSONObject json = new JSONObject(respose);
         // print object
    	 json.get("per_page").toString();
         System.out.println("TEST"+json.get("per_page"));
         // get value for a key
 
	
    
    }
    @When ("^I get the list of all users$")
    public void getFirstPageListOfUsers() {
    	int response=getResponseStatus(baseUrl+"/users?page=1");	
    	if(response==200) {
    		System.out.println("Defualt list of user are getting displayed");
    		
    	}

    	}
    @Then("^I should see total users count equals to number of user ids$")
    public void verifyUserCountEqualsuserId() {
    	boolean isFound=isResponseContainsKey(baseUrl+"/users?page=1","George");
    	

    	if(isFound) {
    		System.out.println("Total User count is equal to number of user IDs");
    	}
    	else {
    		System.out.println("Total User count is not equal to number of user IDs");
    	}
    	
    }
}

