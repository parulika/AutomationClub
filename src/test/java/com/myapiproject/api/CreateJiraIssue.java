package com.myapiproject.api;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.IOException;

public class CreateJiraIssue extends GetJiraAUTH {

	GetJiraAUTH authObj = new GetJiraAUTH();

	@Test
	public void createIssue() throws IOException {

		String createIssueBody = authObj.generateString("createIssue.json");

		Response res = given().contentType(ContentType.JSON).header("cookie", "JSESSIONID=" + authObj.session_ID).
				body(createIssueBody).

				when().post("/rest/api/2/issue/").then().assertThat()
				.statusCode(200).log().all().

				extract().response();

	}
}
