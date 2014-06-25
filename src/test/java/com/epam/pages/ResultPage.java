package com.epam.pages;

import org.openqa.selenium.By;
import com.epam.general.SetUpForPage;

public class ResultPage extends SetUpForPage {

	private static By img = By.cssSelector(".col-lg-3>img");
	private static By name = By.cssSelector(".col-lg-3>span");
	private static By error = By.xpath("//*[@id='login.errors']");	
	private static By errorLogin = By.xpath("//*[@id='clientLogin']/fieldset/div[3]/div/div");


	public static boolean isLoginPass() {
		boolean value = false;
		if (driver.findElement(img)!=null && driver.findElement(name)!=null );
		{
			value = true;
		}	
		return value;
	}

	public static boolean isLoginErrorMessage(String message) {
		if (driver.findElement(errorLogin).isEnabled()){
			return driver.getPageSource().contains(message);
		} else{
			return false;
		}

	}

	public static boolean errorMessage(String message) {
		if (driver.findElement(error).isEnabled()){
			return driver.getPageSource().contains(message);
		} else{
			return false;
		}

	}

}
