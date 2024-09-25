package com.test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPlce_Update_Place {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = RestAssured.given().log().all().queryParam("key ", "qaclick123")
				.body(Payload.addPlace())
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		String placeId = js.getString("place_id");
		System.out.println(placeId);

	}

}
