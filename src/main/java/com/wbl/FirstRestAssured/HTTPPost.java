package com.wbl.FirstRestAssured;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HTTPPost {

	@Test
	public void postRequest() {

		RestAssured.baseURI = "https://reqres.in";

		String endURL = "/api/users";

		RequestSpecification req = RestAssured.given();
		
		req.header("Content-Type", "application/json");
		
		JSONObject obj= new JSONObject();
		obj.put("name", "John");
		obj.put("job", "UI");
		obj.put("id", "1011");
    
		String payload= obj.toJSONString();
		req.body(payload);
		
		Response res = req.request(Method.POST, endURL);

		int statusCode = res.getStatusCode();

		System.out.println(" the  response statuscode of a post request is " + statusCode);

		Assert.assertEquals(statusCode, 201);

		String responseBody = res.asString();

		System.out.println("the response payload of get Reuest is" + responseBody);

		System.out.println("the response header of get Reuest is" + res.getHeaders());

	}

};
