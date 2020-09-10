package com.qa.api.get;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

/**
 * This API Test case is related to BDD Approach in the form of given,when and then
 */
public class GETBDDAPPROACHAPI {

	@Test
	public void getSpaceX_BDD_Approach_Test() {

		RestAssured.baseURI = "https://api.spacexdata.com/";
		given()
		.when()
			.get("v4/launches/latest")
		.then()
			.assertThat()
				.statusCode(200)
		.and()
			.body("ships[0]", equalTo("5ea6ed2e080df4000697c908"))
		.and()
			.body("fairings.recovery_attempt", equalTo(true));

	}

}
