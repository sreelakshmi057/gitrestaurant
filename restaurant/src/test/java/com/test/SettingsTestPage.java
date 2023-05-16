package com.test;

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
	public void prerun() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		settingpg = homepg.navigateToSettingsPage();
	}

	@Test(priority = 34, enabled = false)
	public void validateSettingsPageHasElementsDisplayed() {
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

	@Test(priority = 34, enabled = true)
	public void validateUpdateSettingsInSettingsPage() {
		settingpg.clickOnCompanyName();
		String companyName = settingpg.enterValueToCompanyName();
		String companyPhone = settingpg.enterValueToCompanyPhone();
		String defaultDiscount = settingpg.enterValueToDefaultDiscount();
		String defaultTax = settingpg.enterValueToDefaultTax();
		String currencyCode = settingpg.enterValueToCurrencyCode();
		String receiptHeader = settingpg.enterValueToReceiptHeader();
		String receiptFooter = settingpg.enterValueToReceiptFooter();
		String stripeKey = settingpg.enterValueToStripeKey();
		String publishableKey = settingpg.enterValueToStripePublishedKey();
		settingpg.clickOnSubmitButton();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(companyName, settingpg.getCompanyName());
		soft.assertEquals(companyPhone, settingpg.getCompanyPhone());
		soft.assertEquals(currencyCode, settingpg.getCurrencyCode());
		soft.assertEquals(defaultDiscount, settingpg.getDefaultDiscount());
		soft.assertEquals(defaultTax, settingpg.getDefaultTax());
		soft.assertAll();
	}
}
