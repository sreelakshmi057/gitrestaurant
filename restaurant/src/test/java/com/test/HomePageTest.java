package com.test;

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;

public class HomePageTest extends AutomationBase {
	LoginPage loginpg;
	HomePage homepg;
	Properties prop;
	PropertyUtilities propUtil;

	@Test(priority = 2, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheLinksDisplayedInHomePage_AfterLogin() {
		propUtil = new PropertyUtilities();
		loginpg = new LoginPage(driver);
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(homepg.isPosLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isProductLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isStoreLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isPeopleLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(homepg.isSalesLinkDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@AfterMethod
	public void postRun() {
		homepg.closeTheWindow();
	}

}
