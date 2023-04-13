package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SettingsPage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class SettingsTestPage extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	SettingsPage settingpg;
	Properties prop;
	HomePage homepg;

	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();
	PropertyUtilities propUtil = new PropertyUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	@BeforeMethod
	public void prerun(){
		driver = getDriver();
		try {
			prop = PropertyUtilities.getProperty("config.properties");
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		loginpg = new LoginPage(driver);
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		settingpg = homepg.navigateToSettingsPage();
	}

	@Test(priority = 35, enabled = true)
	public void validateAddStorePageHasElementsDisplayed() {
		settingpg.clickOnCompanyName();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(settingpg.isCompanyNameDisplayed(), "Failure Message: Storename not displayed");
		soft.assertTrue(settingpg.isCompanyPhoneDisplayed(), "Failure Message: Storemail not displayed");
		soft.assertTrue(settingpg.isDefaultDiscountDisplayed(), "Failure Message: Storephone not displayed");
		soft.assertTrue(settingpg.isReceiptHeaderDisplayed(), "Failure Message: Storecountry not displayed");
		soft.assertTrue(settingpg.isReceiptFooterDisplayed(), "Failure Message: Storecity not displayed");
		soft.assertTrue(settingpg.isStripeSecretKeyDisplayed(), "Failure Message: Storecountry not displayed");
		soft.assertTrue(settingpg.isStripeSecretPublishedKeyDisplayed(), "Failure Message: Storecity not displayed");
		soft.assertAll();

	}
}
