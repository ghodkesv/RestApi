package TestScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_003_GET_RequestHeader {

	@Test
	void checkHeaders() {
		RestAssured.baseURI="https://demoqa.com/Account/v1";
		
		RequestSpecification request=RestAssured.given();
		
		Response response=request.request(Method.GET);
		
		String contentType=response.header("Content-Type");
		System.out.println(contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
		
		String contentEncoding=response.header("Content-Encoding");
		System.out.println(contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}
}
