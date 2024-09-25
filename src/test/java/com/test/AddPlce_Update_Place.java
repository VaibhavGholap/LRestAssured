package com.test;

import files.AddPlacePayload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class AddPlce_Update_Place {
	

	public static void main(String[] args) {
		String placeId="";
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = RestAssured.given().log().all().queryParam("key ", "qaclick123")
				.body(AddPlacePayload.addPlace())
				.when().post("maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response);
		js.getString("place_id");
		System.out.println(placeId);
		
		// Update Place

		String updatePlace = RestAssured.given().queryParam("key ", "qaclick123")
		.body("{\r\n"
				+ "\"place_id\":\""+placeId+"\",\r\n"
				+ "\"address\":\"72 Summer walk\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		
	}

}
