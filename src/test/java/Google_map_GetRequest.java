import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Google_map_GetRequest {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/maps/api/place/nearbysearch/xml?location=33.8670522.151.1957362&radius=1500&type=supermarket&key=AlzaSyBjGCE3VpLU4lgSTDmHmJ2HoELbJy1s	\r\n"
				);
		String ResponseBody = response.getBody().asString();
		
		System.out.println("The response is :" +ResponseBody);
		
		Headers head= response.getHeaders();
		
		for(Header headers:head) {
			
			System.out.println(headers.getName() + " ::: " + headers.getValue());
		}
	}

}
