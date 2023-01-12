package RestAssuredAPI_BDD_Pavan;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class PutRequest {
	public static HashMap<String, Object> hmap = new HashMap<String,Object>();
	public static HashMap<String, Object> hmap2 = new HashMap<String,Object>();
	//public static List<Headers> haed ;
	
	String empname = RestUtiles.getrandname();
	String empsal = RestUtiles.getrandsalary();
	String empage = RestUtiles.getrandage();
	
	String empname2 = RestUtiles.getrandname();
	String empsal2 = RestUtiles.getrandsalary();
	
	String id = "1373";
	String id2 = "7";
	
	@BeforeClass
	public void test() {
		
		
		
		hmap.put("employee_name", empname);
		hmap.put("employee_salary", empsal);
		hmap.put("employee_age", empage);
		hmap.put("id", id);
		
	
		
		hmap2.put("name", empname2);
		hmap2.put("salary", empsal2);
		hmap2.put("id", id2);
		
		
					
		}
	
	@Test
	public void putrequest() {
		
		RestAssured.given()
				.baseUri("http://dummy.restapiexample.com/api/v1")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(hmap)
				.when()
				.put("/update/" +id)
				.then()
				.log()
				.all()
				.statusCode(200);
		
		
		
	}
	
	@Test
	public void localputrequest() {
		
		Response response = RestAssured.given()
					.baseUri("http://localhost:3000/employees")
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.body(hmap2)
					.when()
					.put("/" + id2)
					.then()
					.statusCode(200)
					.log()
					.all()
					.extract().response();
		
		String jsonresponse = response.asString();
		System.out.println(jsonresponse);
		Assert.assertEquals(jsonresponse.contains(empname2),true);
		Assert.assertEquals(jsonresponse.contains(empsal2),true);
		Assert.assertEquals(jsonresponse.contains(id2),true);
		System.out.println(response.getHeaders());
		
					
					
	}

	
}
