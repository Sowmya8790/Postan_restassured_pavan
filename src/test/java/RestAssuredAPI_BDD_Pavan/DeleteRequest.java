package RestAssuredAPI_BDD_Pavan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteRequest {
	
	String id = "1213";
	String id2 = "13";
	
	@Test
	public void deleterequest() {
		
		RestAssured.given()
					.baseUri("http://dummy.restapiexample.com/api/v1")
					.when()
					.delete("/delete/" +id)
					.then()
					.log()
					.all()
					.statusCode(200);
	}
	
	@Test
	public void localdeleterequest() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.when()
					.delete("/" +id2)
					.then()
					.log()
					.all()
					.statusCode(200);
	}
}
