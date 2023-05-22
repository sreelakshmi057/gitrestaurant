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
import com.utilities.PropertyUtilities;

public class HomePageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	Properties prop;
	PropertyUtilities propUtil;

	@BeforeMethod
	public void prerun() {
		driver = getDriver();
		propUtil = new PropertyUtilities();
		loginpg = new LoginPage(driver);
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 2, enabled = true)
	public void validateTheLinksDisplayedInHomePage_AfterLogin() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(homepg.isPosLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isProductLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isStoreLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isPeopleLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isSalesLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isExpenseLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isCategoriesLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isSettingsLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isReportLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isLanguageLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isLogoutDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

}
