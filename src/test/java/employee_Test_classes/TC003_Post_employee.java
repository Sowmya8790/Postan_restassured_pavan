package employee_Test_classes;

import java.util.HashMap;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Employees_BaseClass.Employee_Base_Class;
import Utilities_Package.Random_values;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;

public class TC003_Post_employee extends Employee_Base_Class {
	

	@BeforeClass
	public void postemployee() throws InterruptedException {
		
		log.info("************Launching the url and posting in data***************");
		
		empname = Random_values.getempname();
		empsal = Random_values.getempsalary();
		empage = Random_values.getempage();
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		HashMap<String,Object> hmap = new HashMap<String,Object>();
		hmap.put("employee_name", empname);
		hmap.put("employee_salary", empsal);
		hmap.put("employee_age", empage );
		
		Thread.sleep(3000);
		request = RestAssured.given();
		response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(hmap).post("/create");		
	}
	
	@Test
	public void getstatsuscodepost() {
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(empname +"The employee name is ");
		
	}
	
	@Test
	public void gethearders() {

		Headers head = response.headers();
		
		for(Header allhead:head) {
			System.out.println(allhead);
		}
	}
	
	@Test
	public void checkresponsebody() {
		
		String responsebody = response.getBody().asString();
		Assert.assertEquals(responsebody.contains(empname), true);
		Assert.assertEquals(responsebody.contains(empsal), true);
		Assert.assertEquals(responsebody.contains(empage), true);
		
		
		System.out.println(response.getStatusLine());
	}
	
	@AfterClass
	public void afterclass()
	{
		log.info("End of the class");
		}
}
            
















