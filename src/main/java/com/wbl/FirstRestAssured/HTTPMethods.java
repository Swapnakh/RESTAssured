package com.wbl.FirstRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTPMethods {

	@Test
	public void getRequest() {

		RestAssured.baseURI = "https://reqres.in";

		String endURL = "/api/users/2";

		RequestSpecification req = RestAssured.given();

		Response res = req.request(Method.GET, endURL);

		int statusCode = res.getStatusCode();

		System.out.println(" the  response statuscode of a get request is " + statusCode);

		Assert.assertEquals(statusCode, 200);

		String responseBody = res.asString();

		System.out.println("the response payload of get Reuest is" + responseBody);

		System.out.println("the response header of get Reuest is" + res.getHeaders());

	}

}
