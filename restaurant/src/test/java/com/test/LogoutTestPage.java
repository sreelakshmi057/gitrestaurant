package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.utilities.PropertyUtilities;

public class LogoutTestPage extends AutomationBase {
	WebDriver driver;
	LogoutPage logoutpg;
	Properties prop;
	HomePage homepg;
	LoginPage loginpg;
	PropertyUtilities propUtil;

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		logoutpg = homepg.navigateToLogoutPage();
	}

	@Test(priority = 37, enabled = true)
	public void validateLogoutPage() {
		logoutpg.clickOnLogout();

		Assert.assertTrue(logoutpg.isLoginButtonDisplayed(), AutomationConstants.logoutCheck);
	}

}
