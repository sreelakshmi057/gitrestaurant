package com.test;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StorePage;
import com.utilities.ExcelUtilities;
import com.utilities.PropertyUtilities;

public class StorePageTest extends AutomationBase {
	LoginPage loginpg;
	StorePage storepg;
	Properties prop;
	HomePage homepg;
	ExcelUtilities excelUtil;
	PropertyUtilities propUtil;

	@Test(priority = 7, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddStorePageHasElementsDisplayed_WhenAddStoreButtonIsClicked() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		storepg = homepg.navigateToStorePage();
		excelUtil = new ExcelUtilities();
		storepg.clickOnAddStoreButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(storepg.isStoreNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(storepg.isStoreMailDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(storepg.isStorePhoneDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 8, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEnteredStoreValues_AfterClickingAddStoreButtonInStorePage() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		storepg = homepg.navigateToStorePage();
		excelUtil = new ExcelUtilities();
		storepg.clickOnAddStoreButton();
		String storeName = excelUtil.readStringData("store", 2, 2);
		storepg.enterValueToStoreName(storeName);
		String storeMail = excelUtil.readStringData("store", 3, 2);
		storepg.enterValueToStoreMail(storeMail);
		String storeNumber = excelUtil.readStringData("store", 4, 2);
		storepg.enterValueToStoreNumber(storeNumber);
		String storeCountry = excelUtil.readStringData("store", 5, 2);
		storepg.enterValueToStoreCountryName(storeCountry);
		String storeCity = excelUtil.readStringData("store", 6, 2);
		storepg.enterValueToStoreCityName(storeCity);
		String storeAddress = excelUtil.readStringData("store", 7, 2);
		storepg.enterValueToStoreAddress(storeAddress);
		String storeFooter = excelUtil.readStringData("store", 8, 2);
		storepg.enterValueToStoreCustomerFooter(storeFooter);
		storepg.submit();
		storepg.searchForStoreValue(storeName);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepg.getStoreNameFromSearch(), storeName, AutomationConstants.linkDisplayCheck);
		soft.assertEquals(storepg.getStoreMailFromSearch(), storeMail, AutomationConstants.linkDisplayCheck);
		soft.assertEquals(storepg.getStorePhoneFromSearch(), storeNumber, AutomationConstants.linkDisplayCheck);
		soft.assertEquals(storepg.getStoreCountryFromSearch(), storeCountry, AutomationConstants.linkDisplayCheck);
		soft.assertEquals(storepg.getStoreCityFromSearch(), storeCity, AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 9, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEditedStoreValues_AfterClickingEditButtonInStorePage() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		storepg = homepg.navigateToStorePage();
		excelUtil = new ExcelUtilities();
		String storeName = excelUtil.readStringData("store", 11, 2);
		storepg.searchForStoreValue(storeName);
		storepg.clickOnEditIcon();
		String editMail = excelUtil.readStringData("store", 12, 2);
		storepg.enterValueToStoreMail(editMail);
		storepg.clickOnEditSubmitButton();
		storepg.searchForStoreValue(storeName);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepg.getStoreNameFromSearch(), storeName, AutomationConstants.linkDisplayCheck);
		soft.assertEquals(storepg.getStoreMailFromSearch(), editMail, AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 10, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheDeleteIcon_AfterClickingDeleteButtonInStorePage() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		storepg = homepg.navigateToStorePage();
		excelUtil = new ExcelUtilities();
		String storeName = excelUtil.readStringData("store", 15, 2);
		storepg.searchForStoreValue(storeName);
		storepg.clickOnDeleteIcon();
		storepg.searchForStoreValue(storeName);
		Assert.assertEquals(storepg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}

	@AfterMethod
	public void postRun() {
		storepg.closeTheWindow();
	}
}