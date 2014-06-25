package com.epam.steps;

import java.sql.SQLException;
import java.util.Map;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

import com.epam.general.SetUpForPage;
import com.epam.pages.HomePage;
import com.epam.pages.RegistrationPage;
import com.epam.pages.ResultPage;



public class Steps extends SetUpForPage{

	private Map<String, String> message;


	String login ="new";
	String validlogin ="igor";
	String password ="123";
	String confpassword ="123";
	String phone ="123456789012";
	String invalidPassword ="12345";
	String unConfpassword ="123";

	@Given("home page $url")
	public void givenBasePase(String url) {
		open(url);
	}

	@When("the user click on registration page")
	public void clickOnRegistration() throws InterruptedException {
		HomePage.typeRegistrationButton();
	}

	@When("the user has entered login, password")
	public void loginIntoSystem() {
		HomePage.enterUserName(validlogin);
		HomePage.enterPassord(password);
		HomePage.pressEnterButton();
	}

	@When("the user has entered login, invalid password")
	public void InValidloginIntoSystem() {
		HomePage.enterUserName(login);
		HomePage.enterPassord(invalidPassword);
		HomePage.pressEnterButton();
	}

	@When("the user has entered login password, confirmed password, phone and check that all fields and email are editable")
	public void whenEnteredValidData() {
		RegistrationPage.typeLogin(login);
		RegistrationPage.typePassword(password);
		RegistrationPage.confirmPassword(confpassword);
		RegistrationPage.typephone(phone);
		RegistrationPage.checkEmail();
	}

	@When("the user has entered invalid login, invalid password, unconfirmed password, invalid phone and check that all fields and email are editable")
	public void whenEnteredInValidData() {
		RegistrationPage.typeLogin(login);
		RegistrationPage.typePassword(invalidPassword);
		RegistrationPage.confirmPassword(invalidPassword);
		RegistrationPage.typephone(phone);
		RegistrationPage.checkEmail();
	}

	@When("check-box button has been pressed")
	public void whenPressedLoginButton() {
		RegistrationPage.agreeChekB();
	}

	@When("submit button has been pressed")
	public void whenPressedSubmitButton() {
		RegistrationPage.typeSubmButton();
	}

	@Then("the user should see logout button and his log above img")
	public void thenExpectingLogoutButtton() {
		assertTrue(ResultPage.isLoginPass());
	}

	@Then("the user should see corresponding message: $examplesTable")
	public void thenExpectingErrorMessage(ExamplesTable examplesTable) {
		message = examplesTable.getRow(0);
		Assert.assertTrue(ResultPage.errorMessage(message.get("message")));
	}

	@Then("the user should see message: $examplesTable")
	public void ExpectingErrorMessage(ExamplesTable examplesTable) {
		message = examplesTable.getRow(0);
		Assert.assertTrue(ResultPage.isLoginErrorMessage(message.get("message")));
	}

	@Then("delete this new user from DB")
	public void deleteNewUser() throws SQLException {
		deleteRecordFromDbUserTable(login);
	}


}