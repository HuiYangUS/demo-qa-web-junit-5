package cucumber.step_definitions.boratech;

import io.cucumber.java.en.*;

import pages.boratech.HomePage;

public class CommonSteps {

	private HomePage homePage = new HomePage();

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		homePage.loadPage();
	}

	@Given("user clicks [Apply Now] menu")
	public void user_clicks_apply_now_menu() {
		homePage.toApplyPage();
	}

}
