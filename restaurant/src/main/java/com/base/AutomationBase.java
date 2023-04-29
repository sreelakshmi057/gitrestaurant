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
	public void preLaunch(String browserName){
		launchBrowser(browserName);
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		try {
			prop = PropertyUtilities.getProperty("config.properties");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
	}

	public void launchBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			try {
				launchChromeBrowser();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
			}
			break;

		case "edge":
			try {
				launchEdgeBrowser();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
			}
			break;

		case "firefox":
			try {
				launchFirefoxBrowser();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println(e.getCause());
			}
			break;

		default:
			System.out.println(AutomationConstants.browserNameCheck);
			break;
		}

	}

	private void launchChromeBrowser() {

		try {
			driver = new ChromeDriver();
			brwsrUtil.browserMaximize(driver);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	private void launchEdgeBrowser() {

		try {
			driver = new EdgeDriver();
			brwsrUtil.browserMaximize(driver);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	private void launchFirefoxBrowser() {

		try {
			driver = new FirefoxDriver();
			brwsrUtil.browserMaximize(driver);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
