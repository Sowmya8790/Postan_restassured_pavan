package SeAndDeserialization;

import java.util.ArrayList;
import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GETandPostWithoutSerialization {
	
	
	HashMap<String, Object> hmap = new HashMap<String, Object>();
	String id;
		

	@Test(priority=1)
	public void postrequest() {
		
		hmap.put("name", "srin");
		hmap.put("salary", "4800");
		
		
	/*	ArrayList<String> courseList = new ArrayList<String>();
		courseList.add("Java");
		courseList.add("Seleniium");
		
		hmap.put("course", courseList);
		
		{
			"name" : "Sowmya",
			"salary" : "23457",
			"id" " : "67","
			 "course" : [ "java", "Selenium"]
	}*/
		
		Response response =RestAssured.given()
										.baseUri("http://localhost:3000/employees")
										.contentType(ContentType.JSON)
										.accept(ContentType.JSON)
										.body(hmap)
										.when()
										.post("/create")
										.then()
										.log()
										.all()
										.statusCode(201).extract().response();
										
		
		String ResponseBody = response.getBody().asString();
		
		JsonPath jpath = response.jsonPath();
		
		id = jpath.get(id);
		System.out.println("The id is *************************" +id);
	
	}
	
	@Test(priority=2)
	public void getrequest() {
		
						RestAssured .given()
									.baseUri("http://localhost:3000")
									.when()
									.get("/employees/" +id)
									.then()
									.log()
									.all();
												
	}
	

}
