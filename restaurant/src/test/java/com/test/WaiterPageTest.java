package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
	WebDriver driver;
	LoginPage loginpg;
	WaiterPage waiterpg;
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
		waiterpg = homepg.navigateToWaiterInPeopleLink();
	}

	@Test(priority = 11, enabled = true, groups = { "smoke" })
	public void validateAddWaiterPageHasElementsDisplayed() {
		waiterpg.clickOnAddWaiterButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(waiterpg.isWaiterNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(waiterpg.isWaiterPhoneDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(waiterpg.isWaiterEmailDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(waiterpg.isWaiterStoreDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();

	}

	@Test(priority = 12, enabled = true, dataProvider = "dataSupplierWaiter", dataProviderClass = DataSupplier.class)
	public void validateTheEnteredValuesInWaiterPage(String name, String phone, String mail, String store) {
		waiterpg.clickOnAddWaiterButton();
		waiterpg.enterValueToWaiterName(name);
		waiterpg.enterValueToWaiterPhone(phone);
		waiterpg.enterValueToWaiterEmail(mail);
		waiterpg.selectWaiterStoreByVisibleText(store);
		waiterpg.clickOnwaiterSubmitButton();
		waiterpg.searchForStoreValue(name);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiterpg.getWaiterNameFromSearchResult(), "AAN", AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterPhoneFromSearchResult(), "1234567890", AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterEmailFromSearchResult(), "aan@gmail.com", AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterStoreFromSearchResult(), "MNC", AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 13, enabled = true, dataProvider = "dataSupplierWaiterEdit", dataProviderClass = DataSupplier.class)
	public void validateTheEditedWaiterValues(String name, String phone, String mail, String store) {
		waiterpg.searchForStoreValue(name);
		waiterpg.clickOnWaiterEditIcon();
		waiterpg.enterValueToWaiterPhone(phone);
		waiterpg.enterValueToWaiterEmail(mail);
		waiterpg.selectWaiterStoreByVisibleText(store);
		waiterpg.clickOnWaiterEditSubmitButton();
		waiterpg.searchForStoreValue(phone);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiterpg.getWaiterNameFromSearchResult(), "AAN", AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterPhoneFromSearchResult(), "1452367895", AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterEmailFromSearchResult(), "aan@gmail.com", AutomationConstants.errorMessage);
		soft.assertEquals(waiterpg.getWaiterStoreFromSearchResult(), "MNC", AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 14, enabled = true, dataProvider = "dataSupplierWaiterDelete", dataProviderClass = DataSupplier.class)
	public void validateTheDeleteIcon(String phone) {
		waiterpg.searchForStoreValue(phone);
		waiterpg.clickOnWaiterDeleteIcon();
		waiterpg.clickOnWaiterDeleteConfirmMessage();
		waiterpg.searchForStoreValue(phone);
		Assert.assertEquals(waiterpg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}

}
