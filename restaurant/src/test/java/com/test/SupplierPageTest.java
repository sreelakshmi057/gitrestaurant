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
import com.pages.SupplierPage;
import com.utilities.PropertyUtilities;

public class SupplierPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	SupplierPage supplierpg;
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
		supplierpg = homepg.navigateToSuppliersInPeopleLink();
	}

	@Test(priority = 19, enabled = true)
	public void validateAddSupplierPageHasElementsDisplayed() {
		supplierpg.clickOnAddSupplierButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(supplierpg.isSupplierNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(supplierpg.isSupplierPhoneDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(supplierpg.isSupplierEmailDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(supplierpg.isSupplierDescriptionDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 20, enabled = true, dataProvider = "supplier", dataProviderClass = DataSupplier.class)
	public void validateTheEnteredValuesInSuppliersPage(String name, String phone, String mail, String description) {
		supplierpg.clickOnAddSupplierButton();
		supplierpg.enterValueToSupplierName(name);
		supplierpg.enterValueToSupplierPhone(phone);
		supplierpg.enterValueToSupplierEmail(mail);
		supplierpg.enterValueToSupplierDescription(description);
		supplierpg.clickOnSupplierSubmitButton();
		supplierpg.searchForStoreValue(name);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(supplierpg.getSupplierNameFromSearchResult(), "AANNA", AutomationConstants.errorMessage);
		soft.assertEquals(supplierpg.getSupplierPhoneFromSearchResult(), "1478529631",
				AutomationConstants.errorMessage);
		soft.assertEquals(supplierpg.getSupplierEmailFromSearchResult(), "anna@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertAll();

	}

	@Test(priority = 21, enabled = true, dataProvider = "supplieredit", dataProviderClass = DataSupplier.class)
	public void validateTheEditedSupplierValues(String name, String phone, String mail, String description) {
		supplierpg.searchForStoreValue(name);
		supplierpg.clickOnSupplierEditIcon();
		supplierpg.enterValueToSupplierPhone(phone);
		supplierpg.enterValueToSupplierEmail(mail);
		supplierpg.enterValueToSupplierDescription(description);
		supplierpg.clickOnSupplierEditSubmitButton();
		supplierpg.searchForStoreValue(mail);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(supplierpg.getSupplierNameFromSearchResult(), "AANNA", AutomationConstants.errorMessage);
		soft.assertEquals(supplierpg.getSupplierPhoneFromSearchResult(), "8597461238",
				AutomationConstants.errorMessage);
		soft.assertEquals(supplierpg.getSupplierEmailFromSearchResult(), "anna@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 22, enabled = true, dataProvider = "supplierdelete", dataProviderClass = DataSupplier.class)
	public void validateTheDeleteIcon(String phone) {
		supplierpg.searchForStoreValue(phone);
		supplierpg.clickOnSupplierDeleteIcon();
		supplierpg.clickOnSupplierDeleteConfirmMessage();
		supplierpg.searchForStoreValue(phone);
		Assert.assertEquals(supplierpg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}

}
