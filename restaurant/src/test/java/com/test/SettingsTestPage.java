package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SettingsPage;
import com.utilities.PropertyUtilities;

public class SettingsTestPage extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	SettingsPage settingpg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		settingpg = homepg.navigateToSettingsPage();
	}

	@Test(priority = 35, enabled = true)
	public void validateAddStorePageHasElementsDisplayed() {
		settingpg.clickOnCompanyName();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(settingpg.isCompanyNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(settingpg.isCompanyPhoneDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(settingpg.isDefaultDiscountDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(settingpg.isReceiptHeaderDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(settingpg.isReceiptFooterDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(settingpg.isStripeSecretKeyDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(settingpg.isStripeSecretPublishedKeyDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();

	}
}
