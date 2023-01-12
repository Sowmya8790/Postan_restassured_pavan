package employee_Test_classes;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Employees_BaseClass.Employee_Base_Class;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC005_Delete_Employee extends Employee_Base_Class {
	
	Response response2;
	@BeforeClass
	public void deleterequest() {
		
		log.info("***********launching the url for PUT Request*************");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		request = RestAssured.given();
		response  = request.delete("/delete/" +Putempid);
		
		response2 = request.get("/employees/" +Putempid);
			
	}
	
	@Test
	public void getstsuscodeis() {
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test
	public void getstsusafterdelete() {
		Assert.assertEquals(response2.getStatusCode(), 404);
	}
	

}
