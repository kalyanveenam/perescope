package AutomationTest.BrightTalkTest;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;        
        
public class HTTPMethods {

	public static String getResponseBodyFromBaseurl(String baseUrl){
		String data=   given().when().get(baseUrl).then().extract()
	          .path("total_pages");
	return data;
	
		}
	
	public static int getResponseStatus(){
		   int statusCode= given().when().get("https://reqres.in/api/users?page=2").getStatusCode();
		   System.out.println("The response status is "+statusCode);
           return statusCode;

		}
	
}
