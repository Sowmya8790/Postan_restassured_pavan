package RestAssuredAPI_BDD_Pavan;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetRequest {
	
	/*Keywords : Scenario ,
 Given, : set cookies, add auth, add param, set headers info etc……….
 When : get, post, put, delete 
Then : validate status code, extract response, extract headers

*/
	@Test
	public void getRequest() {
				
		
					RestAssured.given()
					.when()
					.get("http://dummy.restapiexample.com/api/v1/employees")
					.then()
					.log()
					.all()
					.statusCode(200)
					.header("Content-Type", "application/json")
					.body("message", Matchers.equalTo("Successfully! All records has been fetched."));
					
												
					
	}

	@Test
	public void test2() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000")
					.when()
					.get("employees/1")
					.then()
					.log()
					.all()
					.statusCode(200)
					.body("name", Matchers.equalTo("Pankaj"));
					
		
	}
	
	}


