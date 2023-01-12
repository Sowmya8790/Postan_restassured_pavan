package Datadriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDriven_DataPovider_generic {

	
	@Test(dataProvider = "dataprovide")
	public void test2(String ename, String esalary, String eage) {

		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		
		JSONObject json = new JSONObject();
		json.put("name", ename);
		json.put("salary", esalary);
		json.put("age", eage);
		
		//Add a header stating the request body is a JSON
		request.header("Content-Type","application/json");
		
		//Add the Json to the body of the request
		request.body(json.toJSONString());
		
		//PostRequest
		
		Response response = request.request(Method.POST,"/create");
		
		String responsebody = response.getBody().asString();
		
		System.out.println("The string response is :" +responsebody);
		
		Assert.assertEquals(responsebody.contains(ename), true);
		Assert.assertEquals(responsebody.contains(esalary), true);
		Assert.assertEquals(responsebody.contains(eage), true);
		
		int statuscode = response.getStatusCode();
		System.out.println(statuscode);
		
		
	}
	
	@DataProvider(name="dataprovide")
	String[][] getdata(){
		
		String[][] data = {{"Sowmya","9000","20"} , {"Lavanya","9800","21"},{"Sowjanya","5600","22"}};
		return(data);
	}

}
