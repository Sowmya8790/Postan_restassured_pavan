import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_req_checkall_nodes {
	
	 void googleMapTest()
	 {
			
			//Validating json response body
			
			RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
			RequestSpecification request = RestAssured.given();
			Response response = request.get("/Delhi");
			
			String responseBody = response.getBody().asString();
			
		JsonPath path = response.jsonPath();
	System.out.println(path.get("City"));
	System.out.println(path.get("Temperature"));
	System.out.println(path.get("Humidity"));
	System.out.println(path.get("WindSpeed"));
	
		Assert.assertEquals(path.get("City"), "39 degree celsious");
	  
	  
	
	 }
}
