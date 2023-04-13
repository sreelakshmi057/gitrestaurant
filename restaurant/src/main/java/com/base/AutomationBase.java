package com.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.pages.LoginPage;
import com.utilities.PropertyUtilities;
import com.utilities.WebbrowserUtilities;

public class AutomationBase {

	static WebDriver driver;
	LoginPage loginpg;
	Properties prop;
	WebbrowserUtilities brwsrUtil;
	PropertyUtilities propUtil;

	@BeforeTest
	public void preLaunch() throws IOException {
		loginpg = new LoginPage(driver);
		brwsrUtil = new WebbrowserUtilities();
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
	}

	@Parameters("browserName")
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
			System.out.println("Check the browser name entered");
			break;
		}

	}

	private void launchChromeBrowser() {

		try {

			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	private void launchEdgeBrowser() {

		try {
			driver = new EdgeDriver();
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	private void launchFirefoxBrowser() {

		try {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	public static WebDriver getDriver() {

		return driver;
	}

}
