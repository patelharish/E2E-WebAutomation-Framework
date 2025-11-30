package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility{
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static final By MY_ACCOUNT_LINK_LOCATOR = By.id("i7lqmw");
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		 goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());   // reading data from the json
		 //goToWebsite(PropertiesUtil.readProperty(Env.QA, "URL")); // reading data from the properties file
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(Env.QA).getUrl());
	}

	public LoginPage goToLoginPage() throws InterruptedException {
		logger.info("Trying to perform click to go to Sign in Page");
		clickOn(MY_ACCOUNT_LINK_LOCATOR);
		Thread.sleep(3000);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
}
