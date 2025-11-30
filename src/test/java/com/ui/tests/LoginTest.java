package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		
		BrowserUtility browserUtility = new BrowserUtility(wd);
		
		browserUtility.goToWebsite("https://www.parempire.com/");
		browserUtility.maximizeWindow();
		
		By myAccountLinkLocator = By.id("i7lqmw");
		browserUtility.clickOn(myAccountLinkLocator);
		
		Thread.sleep(3000);
		By emailInputLocator = By.id("user_email");
		browserUtility.enterText(emailInputLocator, "mukeshkumar01.gh@gmail.com");
		
		By passwordInputLocator = By.id("user_password");
		browserUtility.enterText(passwordInputLocator, "11111111");
		
		By submitBtnLocator = By.xpath("(//button[normalize-space()='Login'])[1]");
		browserUtility.clickOn(submitBtnLocator);
	}

}
