package api;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

import pojos.api.BoraTechLogin;
import utilities.ConfigReader;

public class BoraTechDemoTest {

	String boratechURL = ConfigReader.getValue("boratech", "url");
	String email = ConfigReader.getValue("boratech", "email");
	String password = ConfigReader.getValue("boratech", "password");

	@Test
	void loginTokenTest() {
		String authEndpoint = "api/auth";
		RestAssured.baseURI = boratechURL;
		BoraTechLogin login = new BoraTechLogin();
		login.email = email;
		login.password = password;
		long startTime = Timestamp.valueOf(LocalDateTime.now()).getTime();
		;
		Response responseData = RestAssured.given().contentType(ContentType.JSON).body(login).post(authEndpoint);
		assertEquals(200, responseData.getStatusCode(), "Failed to login to BoraTech.");
		String token = responseData.jsonPath().getString("token");
		Response responseDataProfile = RestAssured.given().header(new Header("X-Auth-Token", token)).get(authEndpoint);
		assertEquals(200, responseData.getStatusCode(), "Failed to get the account profile.");
		String name = responseDataProfile.jsonPath().getString("name");
		long endTime = Timestamp.valueOf(LocalDateTime.now()).getTime();
		long timePass = endTime - startTime;
		System.out.println("Name: " + name);
		System.out.println("Time passed: " + timePass / 1000);
	}

}
