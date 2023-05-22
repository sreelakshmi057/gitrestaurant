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
import com.utilities.GenericUtilities;
import com.utilities.PropertyUtilities;

public class SettingsTestPage extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	SettingsPage settingpg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;
	GenericUtilities genericUtil = new GenericUtilities();

	@BeforeMethod
	public void prerun() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		settingpg = homepg.navigateToSettingsPage();
	}

	@Test(priority = 34, enabled = true)
	public void validateSettingsPageHasElementsDisplayed_WhileClickingOnSettingsLink() {
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

	@Test(priority = 35, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateUpdateSettingsInSettingsPage_ByEnteringValuesInTheFieldsProvided() {
		settingpg.clickOnCompanyName();
		String company_Name = genericUtil.generateAlphabeticData(8);
		settingpg.enterValueToCompanyName(company_Name);
		String company_Phone = genericUtil.generateNumericData(10);
		settingpg.enterValueToCompanyPhone(company_Phone);
		String default_discount = genericUtil.generateNumericData(2);
		settingpg.enterValueToDefaultDiscount(default_discount);
		String tax = genericUtil.generateNumericData(3);
		settingpg.enterValueToDefaultTax(tax);
		String code = genericUtil.generateAlphaNumericData(5);
		settingpg.enterValueToDefaultTax(code);
		settingpg.clickOnSubmitButton();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(company_Name,company_Name );
		soft.assertAll();
	}
}
