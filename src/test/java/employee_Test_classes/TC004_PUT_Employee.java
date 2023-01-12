package employee_Test_classes;

import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Employees_BaseClass.Employee_Base_Class;
import Utilities_Package.Random_values;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC004_PUT_Employee extends Employee_Base_Class{
	
	String empname = Random_values.getempname();
	String empsal = Random_values.getempsalary();
	String empage = Random_values.getempage();
	
	@BeforeClass
	public void Putrequest() throws InterruptedException {
		
		log.info("***********88launching the url for PUT Request*************");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		HashMap<String,Object> hmap = new HashMap<String,Object>();
		hmap.put("employee_name", empname);
		hmap.put("employee_salary", empsal);
		hmap.put("employee_age", empage);
		
		
		Thread.sleep(3000);
		request = RestAssured.given();
		response  = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(hmap).put("/update/" + Putempid);
		
		Thread.sleep(3000);
		Response response2 = request.get("/employees/" +Putempid);
		
		
	}
	
	@Test
	public void getstuscode() {
		
		int statsuscode = response.getStatusCode();
		Assert.assertEquals(statsuscode, 200);
	}
	
	@Test
	public void getstsuscode2() {
		
		String responseBody = response.getBody().asString();
		System.out.println(responseBody);
	}
	
	@AfterClass
	public void afterrequest() {
		
		log.info("*****************Employee details got updated******************");
	}

}















