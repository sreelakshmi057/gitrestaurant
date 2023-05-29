package com.test;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.datasupplier.DataSupplier;
import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;

public class CustomerPageTest extends AutomationBase {
	LoginPage loginpg;
	CustomerPage customerpg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;

	@Test(priority = 15, enabled = true, groups = { "smoke" }, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddCustomersPageInPeopleLinkHasElementsDisplayed_WhenAddCustomerButtonIsClicked() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		customerpg = homepg.navigateToCustomersInPeopleLink();
		customerpg.clickOnAddCustomerButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(customerpg.isCustomerNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(customerpg.isCustomerPhoneDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(customerpg.isCustomerEmailDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(customerpg.isCustomerDiscountDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 16, enabled = true, dataProvider = "customer", dataProviderClass = DataSupplier.class, groups = {
			"smoke" }, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEnteredValues_AfterClickingAddCustomerButtonInCustomersPageInPeopleLink(String name,
			String phone, String mail, String discount) {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		customerpg = homepg.navigateToCustomersInPeopleLink();
		customerpg.clickOnAddCustomerButton();
		customerpg.enterValueToCustomerName(name);
		customerpg.enterValueToCustomerPhone(phone);
		customerpg.enterValueToCustomerEmail(mail);
		customerpg.enterValueToCustomerDiscount(discount);
		customerpg.clickOnCustomerSubmitButton();
		customerpg.searchForCustomerValue(name);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customerpg.getCustomerNameFromSearchResult(), name, AutomationConstants.errorMessage);
		soft.assertEquals(customerpg.getCustomerPhoneFromSearchResult(), phone, AutomationConstants.errorMessage);
		soft.assertEquals(customerpg.getCustomerEmailFromSearchResult(), mail, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 17, enabled = true, dataProvider = "customeredit", dataProviderClass = DataSupplier.class, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEditedCustomerValues_AfterClickingAddEditButtonInCustomersPageInPeopleLink(String name,
			String phone, String mail, String discount) {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		customerpg = homepg.navigateToCustomersInPeopleLink();
		customerpg.searchForCustomerValue(name);
		customerpg.clickOnCustomerEditIcon();
		customerpg.enterValueToCustomerPhone(phone);
		customerpg.enterValueToCustomerEmail(mail);
		customerpg.enterValueToCustomerDiscount(discount);
		customerpg.clickOnCustomerEditSubmitButton();
		customerpg.searchForCustomerValue(phone);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customerpg.getCustomerNameFromSearchResult(), name, AutomationConstants.errorMessage);
		soft.assertEquals(customerpg.getCustomerPhoneFromSearchResult(), phone, AutomationConstants.errorMessage);
		soft.assertEquals(customerpg.getCustomerEmailFromSearchResult(), mail, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 18, enabled = true, dataProvider = "customerdelete", dataProviderClass = DataSupplier.class, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheDeleteIcon_AfterClickingDeleteButtonInCustomersPageInPeopleLink(String phone) {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		customerpg = homepg.navigateToCustomersInPeopleLink();
		customerpg.searchForCustomerValue(phone);
		customerpg.clickOnCustomerDeleteIcon();
		customerpg.clickOnCustomerDeleteConfirmMessage();
		customerpg.searchForCustomerValue(phone);
		Assert.assertEquals(customerpg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}

	@AfterMethod
	public void postRun() {
		customerpg.closeTheWindow();
	}

}
