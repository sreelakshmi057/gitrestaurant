package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;

public class LoginPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	Properties prop;
	PropertyUtilities propUtil;

	@Test(priority = 1, enabled = true)
	public void validateLoginPage_ByEnteringUsernameAndPassword() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		loginpg.performLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homepg.isProductLinkDisplayed(), AutomationConstants.loginCheck);
	}

}
