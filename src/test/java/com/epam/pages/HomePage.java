package com.epam.pages;

import org.openqa.selenium.By;

import static org.junit.Assert.*;
import com.epam.general.SetUpForPage;

public class HomePage extends SetUpForPage  {

	private static By username = By.id("inputUsername");
	private static By passWord = By.id("inputPassw");
	private static By button = By.name("submit");
	private static By regButton = By.linkText("Register a new user");

	public static void enterUserName(String userName) {
		assertTrue(isElementPresent(username));
		driver.findElement(username).sendKeys(userName);
	}

	public static void enterPassord(String password) {
		assertTrue(isElementPresent(passWord));
		driver.findElement(passWord).sendKeys(password);
	}

	public static void pressEnterButton() {
		assertTrue(isElementPresent(button));
		driver.findElement(button).click();
	}

	public static void typeRegistrationButton() {
		assertTrue(isElementPresent(regButton));
		driver.findElement(regButton).click();
	}

}



