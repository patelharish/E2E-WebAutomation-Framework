package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest ;
	
	@Parameters({"browser", "isLambdaTest", "isHeadless"})
	@BeforeMethod(description = "load the homepage of the website")
	public void setUp(
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest, 
			@Optional("true") boolean isHeadless, ITestResult result) {
		this.isLambdaTest = isLambdaTest;	
		WebDriver lambdadriver;
		if (isLambdaTest) {
			lambdadriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdadriver);
		} else {
			logger.info("Load theb Homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {
		return homePage;
	}

	@AfterMethod(description = "Quiting the sessions")
	public void tearDown() {
         if(isLambdaTest) {
        	 LambdaTestUtility.quiteSession();
         }else {
        	 homePage.quit();
         }
	}

}
