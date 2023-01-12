package RestAssuredAPI_BDD_Pavan;

import java.util.HashMap;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;

public class PostRequest {

		
	public static HashMap<String, Object> hmap = new HashMap<String,Object>();
	public static HashMap<String, Object> hmap2 = new HashMap<String,Object>();
	public static List<Headers> haed ;
	
	String empname = RestUtiles.getrandname();
	String empsal = RestUtiles.getrandsalary();
	String empage = RestUtiles.getrandage();
	
	String empname2 = RestUtiles.getrandname();
	String empsal2 = RestUtiles.getrandsalary();
	
	@BeforeClass
	public void test() {
		
		
		
		hmap.put("employee_name", empname);
		hmap.put("employee_salary", empsal);
		hmap.put("employee_age", empage);
		
	
		
		hmap2.put("name", empname2);
		hmap2.put("salary", empsal2);
		
		
		
	}
	
	@Test
	public void postRequest() {
		
		RestAssured.given()
					.baseUri("http://dummy.restapiexample.com/api/v1")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(hmap)
					.when()
					.post("/create")
					.then()
					.log()
					.all()
					.statusCode(200)
					.and()
					.body("employee_name",Matchers.equalTo(empname))
					.and()
					.body("ststus", Matchers.equalTo("success"));
		
					
	}
	
	@Test
	public void localpostrequest() {
		
		RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(hmap)
					.when()
					.post("/create")
					.then()
					.log()
					.all()
					.statusCode(201)
					.body("name",Matchers.equalTo(empname2));
					
									
		
	}

	
		
	}






















