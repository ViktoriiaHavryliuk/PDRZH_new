package com.epam.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.epam.general.SetUpForPage;

public class RegistrationPage extends SetUpForPage  {

	private static By Login = By.xpath("//*[@id='login']");
	private static By RegPassword = By.xpath("//*[@id='password']");
	private static By ConfPassword = By.xpath("//*[@id='confirmPassword']");
	private static By Phone = By.xpath("//*[@id='phone']");
	private static By Submit = By.id("b");
	private static By agree = By.xpath("//*[@id='agree']/input");
	private static By email = By.xpath("//*[@id='email']");

	public static void typeLogin(String login) {
		assertTrue(isElementPresent(Login));
		driver.findElement(Login).clear();
		driver.findElement(Login).sendKeys(login);
	}


	public static void typePassword(String password) {
		assertTrue(isElementPresent(RegPassword));
		driver.findElement(RegPassword).clear();
		driver.findElement(RegPassword).sendKeys(password);
	}
	
	public static void confirmPassword(String confpassword) {
		assertTrue(isElementPresent(ConfPassword));
		driver.findElement(ConfPassword).clear();
		driver.findElement(ConfPassword).sendKeys(confpassword);
	}
	
	public static void typephone(String phone) {
		assertTrue(isElementPresent(Phone));
		driver.findElement(Phone).clear();
		driver.findElement(Phone).sendKeys(phone);
	}
	
	public static void checkEmail() {
		assertTrue(isElementPresent(email));
	}
	
	public static void agreeChekB() {
		assertTrue(isElementPresent(agree));
		driver.findElement(agree).click();
		driver.findElement(agree).isSelected();
	}
	
	public static ResultPage typeSubmButton() {
		assertTrue(isElementPresent(Submit));
		driver.findElement(Submit).click();
		return new ResultPage();
	}

}

