package com.wbl.FirstRestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTPDelete {

	@Test
	public void putRequest() {

		RestAssured.baseURI = "https://reqres.in";

		String endURL = "/api/users/2";

		RequestSpecification req = RestAssured.given();
		
				
		
		Response res = req.request(Method.DELETE, endURL);

		int statusCode = res.getStatusCode();

		System.out.println(" the  response statuscode of a Delete request is " + statusCode);//

		Assert.assertEquals(statusCode, 204);

		String responseBody = res.asString();

		System.out.println("the response payload of Delete Reuest is" + responseBody);

		System.out.println("the response header of Delete Reuest is" + res.getHeaders());

	}

};