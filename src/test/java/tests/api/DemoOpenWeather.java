package tests.api;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import unit.Base;
import utilities.ConfigReader;

public class DemoOpenWeather extends Base {

	static String cityName = "Woodbridge";
	static String stateCode = "VA";
	static String countryCode = "US";
	static String limit = "";

	@Test
	void demoTest() {
		RestAssured.baseURI = "http://api.openweathermap.org/geo/1.0";
		String apiKey = ConfigReader.getValue("config", "api_key");

		Response responseData = RestAssured.given().pathParam("city name", cityName).pathParam("state code", stateCode)
				.pathParam("country code", countryCode).pathParam("limit", limit).pathParam("API key", apiKey).when()
				.get("/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}");

		assertEquals(200, responseData.getStatusCode(),
				"API call failed, status code: " + responseData.getStatusCode());
		responseData.prettyPrint();
		System.out.println("Latitude: " + responseData.jsonPath().get("lat"));
		System.out.println("Longitude: " + responseData.jsonPath().get("lon"));
	}

	@Test
	void run2ndTest() {
		System.out.println("This is the 2nd test.");
		String data = RestAssured.baseURI;
		System.out.println(data);
		System.out.println("Endpoint: " + RestAssured.basePath);
	}

}
