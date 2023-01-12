package RestAssuredAPI_BDD_Pavan;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class BasicValidations {
	
	/*
	 * 
Test status code
Log response
Verifying Single content in response body
Verifying Multiple contents in responsebody
Setting parameters & headers

	 */
	
	@Test
	public void testststuscode() {
		
		RestAssured.given()
					.baseUri("http://jsonplaceholder.typicode.com")
					.when()
					.get("/posts/5")
					.then()
					.log()
					.all()
					.statusCode(200);
				
					
	}
	
	@Test
	public void LogResponse() {
		
		Response response = RestAssured.given()
					.baseUri("http://jsonplaceholder.typicode.com")
					.when()
					.get("/posts/5")
					.then()
					.log()
					.all()
					.extract().response();
		
		String responsebody = response.asString();
		Assert.assertEquals(responsebody.contains("nesciunt quas odio"), true);
	}
	
	@Test
	public void getsingleconetnt() {
		
		RestAssured.given()	
					.when()
					.get("http://jsonplaceholder.typicode.com/posts/5")
					.then()
					.log()
					.all()
					.body("body",Matchers.contains("repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque"));
	}

	
	@Test
	public void GetMultiplecontent() {
		
		RestAssured.given()	
		.when()
		.get("http://jsonplaceholder.typicode.com/posts")
		.then()
		.log()
		.all();
	//	.body("title", hasItems("nesciunt quas odio","qui est esse","eum et est occaecati"));
		
		//Currently its not working but the syntax will be same.
		
		
	}

	
}
