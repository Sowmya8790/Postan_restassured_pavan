package RestAssuredAPI_BDD_Pavan;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicDemoxml_Path {
	
	/*
	 * Verifying Single content in xml response
Verifying Multiple content in xml response
Verifying all the content in xml response in one go
Find values using XML Path in XML Response
Xpath with text() function

	 */
	
	//Verifying Single content in xml response
	
	@Test
	public void Singlecontent() {
		
		RestAssured.given()
					.baseUri("http://thomas-bayer.com/sqlrest")
					.when()
					.get("/CUSTOMER/15")
					.then()
					.body("CUSTOMER.FIRSTNAME", Matchers.equalTo("Bill"))
					.log()
					.all();
		
		
	}
	
	
	
	//Verifying Multiple content in xml response
	@Test
	public void multiplecontent() {
		
		RestAssured.given()
					.baseUri("http://thomas-bayer.com/sqlrest")
					.when()
					.get("/CUSTOMER/15")
					.then()
					.body("CUSTOMER.FIRSTNAME", Matchers.equalTo("Bill"))
					.body("CUSTOMER.LASTNAME", Matchers.equalTo("Clancy"))
					.body("CUSTOMER.STREET", Matchers.equalTo("319 Upland Pl."))
					.body("CUSTOMER.CITY", Matchers.equalTo("Seattle"))
					.body("CUSTOMER.ID", Matchers.equalTo("15"));
					
					
					
	}
			
			//Verifying all the content in xml response in one go
			
			@Test
			public void allonecotent() {
				
				RestAssured.given()
							.baseUri("http://thomas-bayer.com/sqlrest")
							.when()
							.get("/CUSTMOER/15")
							.then()
							.body("CUSTOMER.text()", Matchers.equalTo("15BillClancy319Upland P1.Seattle"))
							.log()
							.all();
				
				// syntax is correct but not working
			}
		
			
				//Find values using XML Path in XML Response
			@Test
			
			public void xpathxml() {
				
				RestAssured.given()
							.baseUri("http://thomas-bayer.com")
							.when()
							.get("/sqlrest/INVOICE")
							.then()
						//	.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
							.log()
							.all();
			}
			
			
			//Xpath with text() function
			@Test
			public void xpathtext() {
				
				RestAssured.given()
							.baseUri("http://thomas-bayer.com")
							.when()
							.get("/sqlrest/INVOICE")
							.then()
						//	.body(hasXPath("/INVOICEList/INVOICE[text()='2']"));
							.log()
							.all();
			}



				
			
		}
