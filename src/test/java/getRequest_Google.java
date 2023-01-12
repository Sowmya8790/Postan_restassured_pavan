import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getRequest_Google {
	
	 @Test
	 void googleMapTest()
	 {
	  
			RestAssured.baseURI = "https://maps.googleapis.com";
			RequestSpecification request = RestAssured.given();
			Response response =
					request.contentType(ContentType.JSON).accept(ContentType.JSON).post("/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
			String responsebody = response.getBody().asString();
			System.out.println(responsebody);
			
	  //print response in console window
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);
	  
	  //validating headers
	  String contentType=response.header("Content-Type");// capture details of Content-Type header
	  System.out.println("Content Type is:"+contentType);
	  Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
	  
	  String contentEncoding=response.header("Content-Encoding");// capture details of Content-Encoding  header
	  System.out.println("Content Encoding is:"+contentEncoding);
	  Assert.assertEquals(contentEncoding, "gzip");
	  
	  System.out.println(response.headers());
	  
	  
	 }
	 
	}



