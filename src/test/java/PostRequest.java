import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	@Test
	public void test2() {
		
		HashMap<String, Object> requestParams = new HashMap<String, Object>();
		
		  requestParams.put("FirstName","JohnXYZ");
		  requestParams.put("LastName","XYZJohn");
		  requestParams.put("UserName","JohnXYZ");
		  requestParams.put("Password","JohnXYZxyx");
		  requestParams.put("Email","JohnXYZ@gmail.com");
		
		RestAssured.baseURI = "http://restapi.demoqa.com/customer/register";
		RequestSpecification request = RestAssured.given();
		Response response = request.contentType(ContentType.JSON).accept(ContentType.JSON).post("/register");
		String responsebody = response.getBody().asString();
		System.out.println(responsebody);
		
		//print response in console window
		  
		  String responseBody=response.getBody().asString();
		  System.out.println("Response Body is:" +responseBody);
		  
		  //status code validation
		  int statusCode=response.getStatusCode();
		  System.out.println("Status code is: "+statusCode);
		  Assert.assertEquals(statusCode, 201);
		  
		  //success code validation
		  String successCode=response.jsonPath().get("SuccessCode");
		  Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		
	}

}
