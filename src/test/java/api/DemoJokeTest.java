package api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.module.jsv.JsonSchemaValidator;

import pojos.api.Joke;

public class DemoJokeTest {

    @Test
    void runTest() {
	String endpoint = "https://official-joke-api.appspot.com/random_joke";
	Response responseData = RestAssured.get(endpoint);
	assertEquals(200, responseData.getStatusCode(),
		"API call failed, status code: " + responseData.getStatusCode());
	System.out.println("Joke: " + responseData.jsonPath().get("setup"));
	System.out.println("Punchline: " + responseData.jsonPath().get("punchline"));
    }

    @Test
    void pojoTest() {
	String endpoint = "https://official-joke-api.appspot.com/random_joke";
	Response responseData = RestAssured.get(endpoint);
	assertEquals(200, responseData.getStatusCode(),
		"API call failed, status code: " + responseData.getStatusCode());
	Joke joke = responseData.as(Joke.class);
	Joke targetJoke = new Joke();
	targetJoke.type = joke.type;
	targetJoke.setup = joke.setup;
	targetJoke.punchline = joke.punchline;
	targetJoke.id = joke.id;
	Joke badJoke = new Joke();
	assertTrue(joke.equals(targetJoke));
	assertFalse(joke.equals(badJoke));
	System.out.println(joke.toString());
    }

    @Test
    @Disabled(value = "Too bothersome to do right now.")
    void schemaValidation1stTest() {
	String endpoint = "https://official-joke-api.appspot.com/random_joke";
	Response responseData = RestAssured.get(endpoint);
	assertEquals(200, responseData.getStatusCode(),
		"API call failed, status code: " + responseData.getStatusCode());
	JsonSchemaValidator jsonSchema = JsonSchemaValidator
		.matchesJsonSchema(new File("src/test/resources/test-data/json-schemas/joke-schema.json"));
	responseData.then().assertThat().body(jsonSchema);
	System.out.println("Matched joke schema.");
    }

    @BeforeEach
    void beforeTest() {

    }

    @AfterEach
    void afterTest() {
	System.out.println();
    }

}
