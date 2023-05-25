package com.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.constants.AutomationConstants;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;
import com.utilities.WebbrowserUtilities;

public class AutomationBase {
	public WebDriver driver;
	LoginPage loginpg;
	Properties prop;
	PropertyUtilities propUtil;
	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();;

	@BeforeMethod
	@Parameters("browserName")
	public void preLaunch(String browserName) {
		launchBrowser(browserName);
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
	}

	@BeforeGroups("smoke")
	@Parameters("browserName")
	public void grouping(String browserName) {
		launchBrowser(browserName);
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
	}

	public void launchBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			launchChromeBrowser();
			break;

		case "edge":
			launchEdgeBrowser();
			break;

		case "firefox":
			launchFirefoxBrowser();
			break;

		default:
			throw new RuntimeException(AutomationConstants.browserNameCheck);
		}
	}

	private void launchChromeBrowser() {
		driver = new ChromeDriver();
		brwsrUtil.browserMaximize(driver);
	}

	private void launchEdgeBrowser() {
		driver = new EdgeDriver();
		brwsrUtil.browserMaximize(driver);
	}

	private void launchFirefoxBrowser() {
		driver = new FirefoxDriver();
		brwsrUtil.browserMaximize(driver);
	}
	
//	@AfterMethod(alwaysRun = true)
//	public void onTestFailure(ITestResult result) {
//		System.out.println(
//				"=============================TEST CASE : " + testName + ":FAILED==============================");
//		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED!!", ExtentColor.RED));
//		String path = System.getProperty("user.dir") + "/test-output/" + System.currentTimeMillis() + ".png";
//		File scrFile = ((TakesScreenshot) (result.getInstance())).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(scrFile, new File(path));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
//		driver.quit();
//	}
}
