import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Authentication {
	
	@Test
	public void test3() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentiation/";
		
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("Sowmya");
		auth.setPassword("Sowmya@123");
		
		RestAssured.authentication=auth;
		
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/");
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
		
		//validadate status code.
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
		
		
	}

}
