package com.qa.api.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This API Test case is related to Non BDD Test Approach
 */

public class GETNonBDDAPI {

	int statusCode;	
	String ResponseOutPut;
	
	@Test
	public void getSpaceX_Non_BDD_Test() {
	
		RestAssured.baseURI = "https://api.spacexdata.com/";
		
		RequestSpecification request = RestAssured.given();
		Response response = request.get("v4/launches/latest");
		
		statusCode = response.statusCode();
		ResponseOutPut = response.prettyPrint();
		System.out.println(statusCode);
		System.out.println(ResponseOutPut);
		Assert.assertEquals(statusCode, Constants.SUCCESS_STATUS_CODE);
		JsonPath js = response.jsonPath();
		Assert.assertEquals(js.getString("ships[0]"), Constants.SHIPS_STATUS_CODE);
		Assert.assertEquals(js.getString("details"), Constants.RESPONSE_DETAILSE);
	}
	
}
