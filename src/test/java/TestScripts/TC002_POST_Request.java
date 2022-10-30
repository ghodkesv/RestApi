package TestScripts;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {

	@Test
	void userRegistration() {
		
		RestAssured.baseURI="https://demoqa.com/Account/v1";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		JSONObject requestparams=new JSONObject();
		
		requestparams.put("userName", "TEST_et");
		
		requestparams.put("password", "aBcxz@123");
		
		httpRequest.header("Content-Type", "application/json");
		
		httpRequest.body(requestparams.toJSONString());
		
		Response response=httpRequest.request(Method.POST,"/User");
		
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 201);
		
		String successCode=response.jsonPath().get("SuccessCode");
		System.out.println(successCode);
	
	}
}
