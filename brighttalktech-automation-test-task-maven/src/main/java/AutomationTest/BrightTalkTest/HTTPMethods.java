package AutomationTest.BrightTalkTest;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers.*;
import org.testng.Assert;

import static io.restassured.RestAssured.*;        
        
public class HTTPMethods {

	public static void getResponseBodyFromBaseurl(String baseUrl){
		RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get(baseUrl);
		 ResponseBody body = response.getBody();
		 System.out.println("Response Body is: " + body.asString());
	
	
		}
	
	public static int getResponseStatus(String baseUrl){
		   int statusCode= given().when().get(baseUrl).getStatusCode();
		   System.out.println("The response status is "+statusCode);
           return statusCode;
           

		}
	public static void getPathValue(String baseUrl) {


String user_Id =given().when().get(baseUrl).then().extract().path("data");
System.out.println(user_Id);	
	}
	public static  boolean isResponseContainsKey(String baseUrl, String key)
	{
		 RestAssured.baseURI = baseUrl;
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get(baseUrl);
		 ResponseBody body = response.getBody();

		 String bodyAsString = body.asString();
		 System.out.println("Body of a String is "+bodyAsString);
	return bodyAsString.contains(key);	
	}
	public static  String getJsonResponseAsString(String baseUrl)
	{
		 RestAssured.baseURI = baseUrl;
		 RequestSpecification httpRequest = RestAssured.given();
		 Response response = httpRequest.get(baseUrl);
		 ResponseBody body = response.getBody();

		 String bodyAsString = body.asString();
		 System.out.println("RESPONSE IN STRING "+bodyAsString);
		 return bodyAsString;

	  
		 
		 
	}
	
	
}
