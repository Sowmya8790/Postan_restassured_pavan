import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_validate_json_res {
	
	@Test
	public void test2() {
		
		//Validating json response body
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/Delhi");
		
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("Delhi"));
	}

}
