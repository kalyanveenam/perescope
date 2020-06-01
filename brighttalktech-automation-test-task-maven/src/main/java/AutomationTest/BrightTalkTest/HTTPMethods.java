package AutomationTest.BrightTalkTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;

public class HTTPMethods {
	static String ResponsePost;
	static String ResponseLogin;
	static String loginResponse;
	static String request_body;
	

// input: baseURL
// functionality: HTTP GET call and converts response to String
// return type: void
	public static void getResponseBodyFromBaseurl(String baseUrl) {
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(baseUrl);
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());

	}

// This method returns status code as return type 
	public static int getResponseStatus(String baseUrl) {
		int statusCode = given().when().get(baseUrl).getStatusCode();
		System.out.println("The response status is " + statusCode);
		return statusCode;

	}

//This method will take a key value as argument and returns true if key element
//is present in response	
	public static boolean isResponseContainsKey(String baseUrl, String key) {
		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(baseUrl);
		ResponseBody body = response.getBody();

		String bodyAsString = body.asString();
		System.out.println("Body of a String is " + bodyAsString);
		return bodyAsString.contains(key);
	}
	// This method will return String from response *refined

	public static String getJsonResponseAsString(String baseUrl) {
		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(baseUrl);
		try{
			assertEquals(200,response.statusCode());
			ResponseBody body = response.getBody();

			String bodyAsString = body.asString();
			System.out.println("RESPONSE IN STRING " + bodyAsString);
			return bodyAsString;

			}catch(AssertionError e){
				System.out.println("Failure Status code is:"+response.statusCode());
			return String.valueOf(response.statusCode());
			}

	}

	// This reusable method allows users to do POST Operation by providing required
	// fields
	public static void POSTRequestCreate(String baseUrl, String name, String job) {

		request_body = " '   {  '  + \r\n" + " '       \"name\": \"" + name + "+\",  '  + \r\n"
				+ " '       \"job\": \"\"" + job + "  '  + \r\n" + " '  }  ' ; ";
		RestAssured.baseURI = baseUrl;

	}

//Reusabe method which will verify Response coming after POST call to the server
	//This method is used to validate response during login as well as crate user
	public static String getResponsePostCall() throws JSONException {

		ResponsePost = given().body(request_body).when().post("/users").then().assertThat().statusCode(201).and()
				.contentType(ContentType.JSON).and().header("server", "cloudflare")
				.extract().response().asString();
		System.out.println(ResponsePost);
		return ResponsePost;

	}
	
	
	
//Validating the response 
	public static String validateResponseLogin(String baseUrl, String email, String password, String expectedStatus) {
		
			request_body = "    {\r\n" + "\"email\": \""+email+"\", \r\n"+"\"password\": \""+password +"\"}";
		
		RestAssured.baseURI = baseUrl;
		System.out.print(request_body);
		ResponseLogin = given().body(request_body).when().post("/login").then().assertThat().statusCode(Integer.valueOf(expectedStatus)).and()
				.contentType(ContentType.JSON).and().header("server", "cloudflare")
				.extract().response().asString();
		System.out.println(ResponsePost);
		return ResponseLogin;
		
		
		
	}
	

	
	
	
	
	
	

}
