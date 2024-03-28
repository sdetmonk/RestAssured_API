package DemoAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAPI {
	
//	Post API always give 201 response incase of any updation & it will 200 Response when it's not updating anything
//	Post API Mostly 90% will accepts a request body
	
	
	@Test
	public void PostAPIAutomation() {
		
	// Used to setup request with Base URI
		RestAssured.baseURI ="https://reqres.in/api";
		
	//Is an Interface, Allows us to handle header & the body
		RequestSpecification https = RestAssured.given();
		
		
	// As it's an post request, we need to pass the request body with json body in key & value using inputBody
		JSONObject inputBody= new JSONObject();		
		inputBody.put("name","morpheus");
		inputBody.put("job", "lender");
		
	//Added the header
		https.header("content-Type", "application/json");
	//Added the Body		
		https.body(inputBody.toJSONString());
		
	//Passing the Endpoint & storing it in Response	
		Response response = https.request(Method.POST,"/users");
		
	//Storing the response in String		
		String responseObject = response.getBody().asString();
		
		System.out.println("Response is :"+responseObject);
		
	//Storing status code in Int  & later for Assertion 					
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode,201);
		
	//Storing the StatusLine in String & later for Assertion		
		String statusLine = response.getStatusLine();


		System.out.println("Status Line is :"+statusLine);
		
		
		
		
	}
	
	

}
