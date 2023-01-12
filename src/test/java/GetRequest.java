import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("utilities/weather/city/Hyderabad");
		String responseBody = response.getBody().asString();
		System.out.println("The response will be : " +responseBody);
		int statuscode = response.getStatusCode();
		System.out.println("The status code of response is :" +statuscode);
		
		//status line verification
		String statusline = response.getStatusLine();
	}

}
