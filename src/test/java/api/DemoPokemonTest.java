package api;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DemoPokemonTest {

	@BeforeAll
	static void allTestSetUp() {
		System.out.println("Default baseURI: " + RestAssured.baseURI);
		RestAssured.baseURI = "https://pokeapi.co/api/v2/pokemon/";
	}

	@Test
	void singlePokemonTest() {
		String endpoint = "101/";
		Response responseData = RestAssured.get(endpoint);
		assertEquals(200, responseData.getStatusCode(),
				String.format("Failed to get data, status code [%d].", responseData.getStatusCode()));
		System.out.println("name: " + responseData.jsonPath().get("name"));
	}

	@Test
	@Disabled
	void getJsonTest() {
		String endpoint = "3/";
		Response responseData = RestAssured.get(endpoint);
		assertEquals(200, responseData.getStatusCode(),
				String.format("Failed to get data, status code [%d].", responseData.getStatusCode()));
		InputStream data = responseData.getBody().asInputStream();
		File targetFile = new File("src/test/resources/test-data/pokemon-data/data.json");
		try {
			FileUtils.copyInputStreamToFile(data, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void getPokemonFrontImgTest() {
		String endpoint = "6/";
		Response responseData = RestAssured.get(endpoint);
		assertEquals(200, responseData.getStatusCode(),
				String.format("Failed to get data, status code [%d].", responseData.getStatusCode()));
		String imgLink = responseData.getBody().jsonPath().get("sprites.front_default");
		String pokemonName = responseData.getBody().jsonPath().get("name");
		if (imgLink != null && !imgLink.isBlank())
			System.out.println(imgLink);
		// second API call
		responseData = RestAssured.get(imgLink);
		System.out.println(responseData.getStatusLine());
		InputStream imgData = responseData.getBody().asInputStream();
		File targetFile = new File("src/test/resources/test-data/pokemon-data/pokemon.png");
		try {
			FileUtils.copyInputStreamToFile(imgData, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Name: " + pokemonName);
	}

}
