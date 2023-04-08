package com.test;

import org.testng.annotations.Test;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class LogoutTestPage extends AutomationBase {
	WebDriver driver;
	LogoutPage logoutpg;
	Properties prop;
	HomePage homepg;
	LoginPage loginpg;

	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();
	PropertyUtilities propUtil = new PropertyUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		loginpg = new LoginPage(driver);
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		logoutpg = homepg.navigateToLogoutPage();
	}

	@Test(priority = 38, enabled = true)
	public void validateLogoutPage() {
		logoutpg.clickOnLogout();
		waitUtil.waitForElementTobeClickable(driver, logoutpg.loginButton, 15);

		Assert.assertTrue(logoutpg.isLoginButtonDisplayed(), "Failure Message:Logout failed");
	}

}