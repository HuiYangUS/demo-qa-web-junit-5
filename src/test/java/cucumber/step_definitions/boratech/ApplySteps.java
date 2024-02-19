package cucumber.step_definitions.boratech;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import pages.boratech.ApplyPage;

public class ApplySteps {

	private ApplyPage applyPage = new ApplyPage();

	@When("user submits application data")
	public void user_submits_application_data(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		applyPage.enterFirstName(data.get("first name"));
		applyPage.enterLastName(data.get("last name"));
		applyPage.enterDateOfBirth(data.get("date of birth"));
		applyPage.selectGender(Integer.parseInt(data.get("gender")));
		applyPage.enterEmail(data.get("email"));
		applyPage.enterPhoneNumber(data.get("phone number"));
		applyPage.selectCourse(data.get("course"));
		applyPage.selectSource(data.get("source"));
	}

	@When("user checks [Not A Robot] checkbox")
	public void user_checks_not_a_robot_checkbox() {
		applyPage.checkPreApplyStatus();
		applyPage.isNotRobot();
	}

	@When("user clicks [Submit] button")
	public void user_clicks_submit_button() {
		applyPage.submitApplication();
	}

	@Then("user sees submission success display")
	public void user_sees_submission_success_display() {
		System.out.println(applyPage.getSuccessAlertText());
	}

}
