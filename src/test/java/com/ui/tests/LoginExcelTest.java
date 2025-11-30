package com.ui.tests;

import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginExcelTest extends TestBase{
	static HomePage homePage;
	
	@Test(description = "Verifies with the valid user is able to login into the application", 
			groups = {"e2e","sanity"}, 
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
			dataProvider = "LoginTestExcelDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public static void loginTest(User user) throws InterruptedException{
		/* Test method(key points to write good test cases)
		 * Test script small 
		 * you cannot not write conditional statement, loops, try catch
		 * Test scripts should only following the test step
		 * Reduce the use of local variables
		 * write atleast one assertion
		 */
		homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword());
	}
}
