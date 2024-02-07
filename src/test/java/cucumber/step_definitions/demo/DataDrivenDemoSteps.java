package cucumber.step_definitions.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class DataDrivenDemoSteps {

	List<Map<String, String>> dataSet;

	@Given("a data table is provided below")
	public void a_data_table_is_provided_below(DataTable dataTable) {
		dataSet = dataTable.asMaps();
	}

	@When("the data is taken")
	public void the_data_is_taken() {
		assertNotNull(dataSet, "Data is not taken");
	}

	@Then("the result is displayed")
	public void the_result_is_displayed() {
		for (Map<String, String> dataRow : dataSet) {
			System.out.println(dataRow.get("first name") + ": " + dataRow.get("age"));
		}
	}

	private static int age;
	private static String drink = "milk";

	@Given("the age is {int}")
	public void the_age_is(int age) {
		DataDrivenDemoSteps.age = age;
	}

	@When("the age is verified")
	public void the_age_is_verified() {
		if (age >= 21)
			drink = "beer";
	}

	@Then("the drinking test is done")
	public void the_drinking_test_is_done() {
		System.out.println("This person can drink " + drink + ".");
	}

}
