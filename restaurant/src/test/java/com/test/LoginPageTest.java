package com.test;

import org.testng.annotations.Test;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class LoginPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	Properties prop;

	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();
	PropertyUtilities propUtil = new PropertyUtilities();

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
	}

	@Test(priority = 1, enabled = true, groups = { "smoke" })
	public void validateLoginPage() {
		loginpg.enterValueToUsername(prop.getProperty("username"));
		loginpg.enterValueToPassword(prop.getProperty("password"));
		loginpg.clickLoginButton();

		Assert.assertTrue(homepg.isProductLinkDisplayed(), "Failure Message:Login failed");
	}

}
