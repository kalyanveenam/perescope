package AutomationTest.BrightTalkTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import org.json.JSONException;

import static io.restassured.RestAssured.*;

public class HTTPMethods {
	static String Resp;
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
	// This method will return String from response

	public static String getJsonResponseAsString(String baseUrl) {
		RestAssured.baseURI = baseUrl;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(baseUrl);
		if (response.statusCode() == 200) {
			System.out.println("User found");
			ResponseBody body = response.getBody();

			String bodyAsString = body.asString();
			System.out.println("RESPONSE IN STRING " + bodyAsString);
			return bodyAsString;

		} else {
			System.out.println("User not found");
			return "User not found";
		}

	}

	// This reusable method allows users to do POST Operation by providing required
	// fields
	public static void POSTRequest(String baseUrl, String name, String job) {

		request_body = " '   {  '  + \r\n" + " '       \"name\": \"" + name + "+\",  '  + \r\n"
				+ " '       \"job\": \"\"" + job + "  '  + \r\n" + " '  }  ' ; ";

		RestAssured.baseURI = baseUrl;

		  given().body(request_body).when().post("/api/users").then().assertThat().statusCode(201)
				.and().contentType(ContentType.JSON).and().header("server", "cloudflare").and()
				.header("content-length", "51").extract().response().asString();

		System.out.println("Response is\t" + Resp);

	}

//POST call for login Functionality
	public static void getResponsePostCall() throws JSONException {

		Resp = given().body("bo").when().post("/users").then().assertThat().statusCode(201).and()
				.contentType(ContentType.JSON).and().header("server", "cloudflare").and().header("content-length", "51")
				.extract().response().asString();
		System.out.println(Resp);

	}

//Validating the response 
	public static void validateResponse(String baseUrl, String email, String password) {
		String bo = " '   {  '  + \r\n" + " '       \"email\": \"eve.holt@reqres.in\",  '  + \r\n"
				+ " '       \"password\": \"cityslicka\"  '  + \r\n" + " '  }  ' ; ";

		RestAssured.baseURI = "https://reqres.in";

		String Resp = given().body(bo).when().post("/api/login").then().assertThat().statusCode(400).and()
				.contentType(ContentType.JSON).and().header("server", "cloudflare").and().header("content-length", "37")
				.extract().response().asString();

		System.out.println("Response is\t" + Resp);
	}

}
