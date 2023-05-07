package com.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.constants.AutomationConstants;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;
import com.utilities.WebbrowserUtilities;

public class AutomationBase {
	static WebDriver driver;
	LoginPage loginpg;
	Properties prop;
	PropertyUtilities propUtil;
	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();;

	@BeforeTest
	@Parameters("browserName")
	public void preLaunch(String browserName) {
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

	public static WebDriver getDriver() {
		return driver;
	}
}
