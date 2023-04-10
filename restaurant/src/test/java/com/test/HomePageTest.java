package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class HomePageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	Properties prop;

	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();
	PropertyUtilities propUtil = new PropertyUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		waitUtil.implicitWait(driver, 5);
		loginpg = new LoginPage(driver);
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 2, enabled = true, groups = { "smoke" })
	public void validateTheLinkDisplayedOnTheHomePage() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(homepg.isPosLinkDisplayed(), "Failure Message: poslink not displayed");
		soft.assertTrue(homepg.isProductLinkDisplayed(), "Failure Message: productlink not displayed");
		soft.assertTrue(homepg.isStoreLinkDisplayed(), "Failure Message: storelink not displayed");
		soft.assertTrue(homepg.isPeopleLinkDisplayed(), "Failure Message: peoplelink not displayed");
		soft.assertTrue(homepg.isSalesLinkDisplayed(), "Failure Message: saleslink not displayed");
		soft.assertTrue(homepg.isExpenseLinkDisplayed(), "Failure Message: expenselink not displayed");
		soft.assertTrue(homepg.isCategoriesLinkDisplayed(), "Failure Message: categorieslink not displayed");
		soft.assertTrue(homepg.isSettingsLinkDisplayed(), "Failure Message: settingslink not displayed");
		soft.assertTrue(homepg.isReportLinkDisplayed(), "Failure Message: reportlink not displayed");
		soft.assertTrue(homepg.isLanguageLinkDisplayed(), "Failure Message: languagelink not displayed");
		soft.assertTrue(homepg.isLogoutDisplayed(), "Failure Message: logout not displayed");
		soft.assertAll();
	}

}
