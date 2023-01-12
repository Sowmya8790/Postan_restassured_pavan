package Datadriven;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriven_DataProvider {
	
	@Test
	public void test1() {

		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		
		JSONObject json = new JSONObject();
		json.put("name", "Sowmya");
		json.put("salary", "8000");
		json.put("age", "20");
		
		//Add a header stating the request body is a JSON
		request.header("Content-Type","application/json");
		
		//Add the Json to the body of the request
		request.body(json.toJSONString());
		
		//PostRequest
		
		Response response = request.request(Method.POST,"/create");
		
		String responsebody = response.getBody().asString();
		
		System.out.println("The string response is :" +responsebody);
		
		Assert.assertEquals(responsebody.contains("Sowmya"), true);
		Assert.assertEquals(responsebody.contains("8000"), true);
		Assert.assertEquals(responsebody.contains("20"), true);
		
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		
	}
	
	

}
