package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
	}

	@BeforeGroups("smoke")
	@Parameters("browserName")
	public void grouping(String browserName) {
		launchBrowser(browserName);
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

	public WebDriver getDriver() {
		return driver;
	}

}
