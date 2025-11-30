package com.ui.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver wd = new ChromeDriver();
		HomePage homePage = new HomePage(wd);
		LoginPage loginpage = homePage.goToLoginPage();
		Thread.sleep(3000);
		loginpage.doLoginWith("mukeshkumar01.gh@gmail.com", "11111111");
	}
}
