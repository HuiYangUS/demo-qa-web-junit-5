package cucumber.step_definitions;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IceCreamSteps {

    private String name;

    @Given("I have ice cream {string}")
    public void i_have_ice_cream(String name) {
	String errorText = "You don't even give me any ice cream.";
	assertNotNull(name, errorText);
	assertFalse(name.isEmpty(), errorText);
	this.name = name;
    }

    @When("I check for the rating {string} of this ice cream")
    public void i_check_for_the_of_this_ice_cream(String rating) {
	int num = Integer.valueOf(rating);
	if (num < 0 || num > 10)
	    fail("Invalid rating, please enter a number between 1 to 10.");
    }

    @Then("I verify that I have the {string}")
    public void i_verify_that_i_have_the(String bestIceCream) {
	assertEquals(bestIceCream, name);
    }

}
