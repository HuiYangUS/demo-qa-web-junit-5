package api;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import unit.BaseTest;
import utils.TestConfigReader;

public class DemoOpenWeatherTest extends BaseTest {

    static String cityName = "Woodbridge";
    static String stateCode = "VA";
    static String countryCode = "US";
    static String limit = "";
    static String apiKey = TestConfigReader.getTextValue("config", "openweather_api_key");

    @Test
    @DisplayName("Demo Weather Test")
    void demoTest() {
	RestAssured.baseURI = "http://api.openweathermap.org/geo/1.0";

	Response responseData = RestAssured.given().pathParam("city name", cityName).pathParam("state code", stateCode)
		.pathParam("country code", countryCode).pathParam("limit", limit).pathParam("API key", apiKey).when()
		.get("/direct?q={city name},{state code},{country code}&limit={limit}&appid={API key}");

	assertEquals(200, responseData.getStatusCode(),
		"API call failed to retrieve location data, status code: " + responseData.getStatusCode());
	ArrayList<Double> latList = responseData.jsonPath().get("lat");
	String lat = String.valueOf(latList.get(0));
	ArrayList<Double> lonList = responseData.jsonPath().get("lon");
	String lon = String.valueOf(lonList.get(0));
	System.out.println("Latitude: " + lat);
	System.out.println("Longitude: " + lon);
	String weatherDataEndpoint = String
		.format("https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s", lat, lon, apiKey);
	responseData = RestAssured.get(weatherDataEndpoint);
	assertEquals(200, responseData.getStatusCode(),
		"API call failed to retrieve weather data, status code: " + responseData.getStatusCode());
	ArrayList<String> weatherTypeList = responseData.jsonPath().get("weather.main");
	String weatherType = weatherTypeList.get(0);
	float tempNum = responseData.jsonPath().get("main.temp");
	// convert Kelvin to Fahrenheit
	tempNum = (float) ((tempNum - 273.15) * 9 / 5 + 32);
	String temp = String.valueOf(tempNum);
	System.out.println("Weather: " + weatherType);
	System.out.println("Temperture: " + temp);
    }

    private static String getGeoEndpoint() {
	String defaultLocation = "Beijing";
	String endpoint = String.format("http://api.openweathermap.org/geo/1.0/direct?q=%s&limit=%s&appid=%s",
		defaultLocation, limit, apiKey);
	return endpoint;
    }

    @Test
    void geoTest() {
	Response responseData = RestAssured.get(getGeoEndpoint());
	assertEquals(200, responseData.getStatusCode(),
		"API call failed, status code: " + responseData.getStatusCode());
	System.out.println("Test passed.");
    }

}
