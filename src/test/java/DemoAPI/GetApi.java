package DemoAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetApi {
	
	
	@Test
	public void GetAPIAutomation() {
// GET API Response should always be 200
		
		//https://reqres.in/api/users/2
		
		
//		Base URI is maintaiend at propery file
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		
		// RequestSpecification is an interface allows us to modify the request
		RequestSpecification http= RestAssured.given();
		
		Response response = http.request(Method.GET,"/2");
		
		String responseObject = response.asString();
		
		System.out.println("My response is "+ responseObject);
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
			
		
	}
}
