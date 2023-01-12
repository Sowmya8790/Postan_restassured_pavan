package employee_Test_classes;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Employees_BaseClass.Employee_Base_Class;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class TC002_Employee_Get_Single extends Employee_Base_Class{
	
	@BeforeClass
	public void setup() {
		log.info("**********Launching the URL**************");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		response = request.request(Method.GET,"/employee/"+EmpID);
		
	}
	
	@Test
	public void checkResponseBody() {
		String ResponseBody =response.getBody().asString();
		Assert.assertEquals(ResponseBody.contains(EmpID), true);
		
	}
	
	@Test
	public void checkStatusCode() {
		
	 int statuscode = response.getStatusCode();
	 Assert.assertEquals(statuscode, 200);
	}
	
	
	@Test
	public void CheckStatusline() {
		
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline!=null, true);
	}
	
	@Test
	public void checkcontentlength() {
		
		String checklength = response.getHeader("Content-Length");

		if(Integer.parseInt(checklength)<100){
			
			log.warn("The contentlegth is less than 100");
		}
		
		Assert.assertEquals(Integer.parseInt(checklength)>100,true);
	}
	
	@Test
	public void checkresponsetime() {
		
		long responsetime = response.getTime();
		Assert.assertEquals(responsetime<2000, true);
	}
	
	
	

}
