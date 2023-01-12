package employee_Test_classes;

import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Employees_BaseClass.Employee_Base_Class;
import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_Gett_All_Employees extends Employee_Base_Class {
	
	@BeforeClass
	public void setup() throws InterruptedException {
		
		log.info("************Launching the URL***********");
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		request = RestAssured.given();
		response = request.request(Method.GET,"/employees");
		
		Thread.sleep(3000);
		
	}
	@Test
	public void getresponsebody() {
		
		log.info("******************Checking the responseBody of all employees***************");
		
		String responseBody = response.getBody().asString();		
		log.info("responseBody is :" +responseBody);
		System.out.println(responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	public void getstatuscode() {
		log.info("******Checking the statuscode*********");
		
		int statuscode = response.getStatusCode();
		log.info("check status code :" +statuscode);
		Assert.assertEquals(200, statuscode);
				
	}
	
	@Test
	public void getstatusline() {
		
		log.info("*********Checking status line**********");
		
		String Statusline = response.getStatusLine();
		log.info("Check status line :" +Statusline);
		Assert.assertTrue(Statusline!=null);
	}
	
	@Test
	public void getresponsetime() {

		log.info("*********Checking response time**********");
		
		float responsetime = response.getTime();
		log.info("Check responsetime:" +responsetime);
		if(responsetime>2000) {
			log.warn("The response time is greated than 2000");
		}
		Assert.assertTrue(responsetime<2000);
		
	}
	
	@Test
	public void checkcontentype() {
		
		log.info("***********Checking contentype header********" );
		
		String contentype = response.getHeader("Content-Type");
		log.info("*******Checking hearder*" +contentype);
		Assert.assertEquals("application/json", contentype);
	}

	
	@Test
	public void checkcontenencoding() {
		
		log.info("***********Checking contenencoding header********" );
		
		String contentype = response.getHeader("Content-Encoding");
		log.info("*******Checking hearder*" +contentype);
		Assert.assertEquals("gzip", contentype);
	}
	
	
/*	@Test
	public void checkcontentlength() {
		
		log.info("***********Checking contentlength header********" );
		
		String contenlength = response.getHeader("Content-Length");
		log.info("*******Checking hearder*" +contenlength);
		
		if(Integer.parseInt(contenlength)<100) {
			log.warn("The content length is < 100");
		}
		Assert.assertTrue(Integer.parseInt(contenlength) >100);
	}*/
	

	@Test
	public void checkcookies() {
		
		log.info("***********Checking cookies********" );
		
		Map<String, String> cookies  = response.getCookies();
		log.info("*******Checkingcookies*" +cookies.size());
		
		if(cookies.size()>0) {
			log.info("This server not having cookies");
		}
		else
		{
			log.info("This server having cookies" + cookies.size());
		}
	}

}
