package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {	
	
	private static final By EMAIL_INPUT_LOCATOR = By.id("user_emailh");
	private static final By PASSWORD_INPUT_LOCATOR = By.id("user_password");
	private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("(//button[normalize-space()='Login'])[1]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}	
	
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_INPUT_LOCATOR, emailAddress);
		enterText(PASSWORD_INPUT_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}
}
