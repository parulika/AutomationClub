package com.myapiproject.api;

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetJiraAUTH{
	
	String session_ID;

	@Test
	public void getAuthtication() throws IOException {

		String bodyRequset = generateString("requset.json");
		RestAssured.baseURI = "http://localhost:8080/";

		Response res = given().contentType(ContentType.JSON).body(bodyRequset).

		when().post("/rest/auth/1/session").then().assertThat().statusCode(200)
				.

				extract().response();

		String responseString = res.asString();
		JsonPath jsonP = new JsonPath(responseString);
	    session_ID = jsonP.getString("session.value");

		System.out.println("session_ID: " + session_ID);
		
		CreateJiraIssue obj = new CreateJiraIssue();
		obj.createIssue();

	}

	public String generateString(String Filename) throws IOException {
		String filePath = System.getProperty("user.dir") + "//payloads//"
				+ Filename;
		return new String(Files.readAllBytes(Paths.get(filePath)));
	}
	
	

}
