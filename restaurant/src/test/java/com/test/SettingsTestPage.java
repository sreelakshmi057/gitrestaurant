package com.test;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SettingsPage;
import com.utilities.GenericUtilities;
import com.utilities.PropertyUtilities;

public class SettingsTestPage extends AutomationBase {
	LoginPage loginpg;
	SettingsPage settingpg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;
	GenericUtilities genericUtil = new GenericUtilities();

	@Test(priority = 34, enabled = true)
	public void validateSettingsPageHasElementsDisplayed_WhileClickingOnSettingsLink() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		settingpg = homepg.navigateToSettingsPage();
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

	@AfterMethod
	public void postRun() {
		settingpg.closeTheWindow();
	}
}
