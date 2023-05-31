package com.test;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.datasupplier.DataSupplier;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.WaiterPage;
import com.utilities.PropertyUtilities;

public class WaiterPageTest extends AutomationBase {
	LoginPage loginpg;
	WaiterPage waiterpg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;

	@Test(priority = 11, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddWaiterPageHasElementsDisplayed_WhenAddWaitererButtonIsClicked() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		waiterpg = homepg.navigateToWaiterInPeopleLink();
		waiterpg.clickOnAddWaiterButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(waiterpg.isWaiterNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(waiterpg.isWaiterPhoneDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(waiterpg.isWaiterEmailDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(waiterpg.isWaiterStoreDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 12, enabled = true, dataProvider = "waiter", dataProviderClass = DataSupplier.class, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEnteredValuesInWaiterPage_AfterClickingAddWaitererButtonInWaiterPage(String name,
			String phone, String mail, String store) {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		waiterpg = homepg.navigateToWaiterInPeopleLink();
		waiterpg.clickOnAddWaiterButton();
		waiterpg.enterValueToWaiterName(name);
		waiterpg.enterValueToWaiterPhone(phone);
		waiterpg.enterValueToWaiterEmail(mail);
		waiterpg.selectWaiterStoreByVisibleText(store);
		waiterpg.clickOnwaiterSubmitButton();
		waiterpg.searchForStoreValue(name);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiterpg.getWaiterNameFromSearchResult(), name, AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterPhoneFromSearchResult(), phone, AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterEmailFromSearchResult(), mail, AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterStoreFromSearchResult(), store, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 13, enabled = true, dataProvider = "waiteredit", dataProviderClass = DataSupplier.class, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEditedWaiterValues_AfterClickingEditButtonInWaiterPage(String name, String phone,
			String mail, String store) {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		waiterpg = homepg.navigateToWaiterInPeopleLink();
		waiterpg.searchForStoreValue(name);
		waiterpg.clickOnWaiterEditIcon();
		waiterpg.enterValueToWaiterPhone(phone);
		waiterpg.enterValueToWaiterEmail(mail);
		waiterpg.selectWaiterStoreByVisibleText(store);
		waiterpg.clickOnWaiterEditSubmitButton();
		waiterpg.searchForStoreValue(phone);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiterpg.getWaiterPhoneFromSearchResult(), phone, AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterEmailFromSearchResult(), mail, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 14, enabled = true, dataProvider = "waiterdelete", dataProviderClass = DataSupplier.class, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheDeleteIcon_AfterClickingDeleteButtonInWaiterPage(String phone) {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		waiterpg = homepg.navigateToWaiterInPeopleLink();
		waiterpg.searchForStoreValue(phone);
		waiterpg.clickOnWaiterDeleteIcon();
		waiterpg.clickOnWaiterDeleteConfirmMessage();
		waiterpg.searchForStoreValue(phone);
		Assert.assertEquals(waiterpg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}

	@AfterMethod
	public void postRun() {
		waiterpg.closeTheWindow();
	}

}
