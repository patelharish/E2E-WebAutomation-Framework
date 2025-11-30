package com.ui.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pojo.User;


@Listeners(com.ui.listeners.TestListener.class)
public class LoginCSVTest extends TestBase{
	
	@Test(description = "Verifies with the valid user is able to login into the application", 
			groups = {"e2e","sanity"}, 
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, 
			dataProvider = "LoginTestCSVDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginTest(User user) throws InterruptedException{
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
