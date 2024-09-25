package com.test;

import files.Payload;
import io.restassured.RestAssured;

public class AddPlace_and_Validate_Status_Code {

	/*Build Rest API Automation to addPlace and Validate Status Code.*/
	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		RestAssured.given().log().all().queryParam("key ", "qaclick123")
				.body(Payload.addPlace())
				.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200);

	}

}
