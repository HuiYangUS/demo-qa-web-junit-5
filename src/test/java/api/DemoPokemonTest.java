package api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoPokemonTest {

	@BeforeAll
	static void allTestSetUp() {
		RestAssured.baseURI = "https://pokeapi.co/api/v2/pokemon/";
	}

	@Test
	void singlePokemonTest() {
		String endpoint = "101/";
		Response dataResponse = RestAssured.get(endpoint);
		assertEquals(200, dataResponse.getStatusCode(),
				String.format("Failed to get data, status code [%d].", dataResponse.getStatusCode()));
		System.out.println("name: " + dataResponse.jsonPath().get("name"));
	}

}
