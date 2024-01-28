package tests.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoTest {

	@Test
	void runTest() {
		String endpoint = "https://official-joke-api.appspot.com/random_joke";
		Response responseData = RestAssured.get(endpoint);
		assertEquals(200, responseData.getStatusCode(),
				"API call failed, status code: " + responseData.getStatusCode());
		System.out.println("Joke: " + responseData.jsonPath().get("setup"));
		System.out.println("Punchline: " + responseData.jsonPath().get("punchline"));
	}

}
