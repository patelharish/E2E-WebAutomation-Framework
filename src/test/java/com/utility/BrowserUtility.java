package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // instance variable created in heap
																					// memory

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String browserName) {
		logger.info("Launching Browser for " + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver.set(new FirefoxDriver());
		} else {
			logger.info("Invalid Browser Name...Please select chrome, edge and firefox");
			System.err.print("Invalid Browser Name...Please select chrome, edge and firefox");
		}
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		} else {
			System.err.print("Invalid Browser Name...Please select chrome, edge and firefox");
		}
	}

	// for headless mode
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--no-sandbox");
				options.addArguments("disable-gpu");
				driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("disable-gpu");
				options.addArguments("--no-sandbox");
				driver.set(new EdgeDriver(options));
			} else {
				driver.set(new EdgeDriver());
			}
		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("disable-gpu");
				options.addArguments("--no-sandbox");
				driver.set(new FirefoxDriver(options));
			} else {
				driver.set(new FirefoxDriver());
			}
		} else {
			System.err.print("Invalid Browser Name...Please select chrome, edge and firefox");
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now Performing Click");
		element.click();
	}

	public void enterText(By locator, String textToEnter) {
		logger.info("Finding Element with the locator" + locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element Found and now enter text" + textToEnter);
		element.sendKeys(textToEnter);
	}

	public String takeScreenShot(String name) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
		File screenshotData = takesScreenshot.getScreenshotAs(OutputType.FILE);

		Date date = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("HH-ss-ss");
		String timestamp = formate.format(date);

		String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timestamp + ".png";
		File screenShotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
	
	public void quit() {
        WebDriver d = driver.get();
        if (d != null) {
            try {
                d.quit();
                logger.info("Browser session quit successfully.");
            } catch (Exception e) {
                logger.error("Error while quitting browser: " + e.getMessage());
            } finally {
                driver.remove();  // ⚠️ CRITICAL TO PREVENT MEMORY LEAKS
            }
        }
    }

}
