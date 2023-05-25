package com.test;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.LogoutPage;
import com.utilities.PropertyUtilities;

public class LogoutTestPage extends AutomationBase {
	LogoutPage logoutpg;
	Properties prop;
	HomePage homepg;
	LoginPage loginpg;
	PropertyUtilities propUtil;

	@Test(priority = 37, enabled = true)
	public void validateLogoutPage_ByClickingLogoutLink() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		logoutpg = homepg.navigateToLogoutPage();
		logoutpg.clickOnLogout();
		Assert.assertTrue(logoutpg.isLoginButtonDisplayed(), AutomationConstants.logoutCheck);
	}

}
