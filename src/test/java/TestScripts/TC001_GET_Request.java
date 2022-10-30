package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {

	@Test
	void GetBooksDetails() {
		
		//Specify the base URL to the RESTful web service
		RestAssured.baseURI="https://demoqa.com/BookStore/v1";
		
		//request object--> Get the RequestSpecification of the request to be sent to the server. 
		RequestSpecification httpRequest=RestAssured.given();
		
		//response object-->specify the method type (GET) and the parameters if any.
		Response response=httpRequest.request(Method.GET,"/Books");
		
		//print response in console window
		String ResponseBody=response.getBody().asString();
		System.out.println("Response Body is : "+ResponseBody);
		
		//Validating status code
		int statusCode=response.getStatusCode();
		System.out.println("Status code : "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Validating status line
		String statusLine=response.getStatusLine();
		System.out.println("Status Line : "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
}
