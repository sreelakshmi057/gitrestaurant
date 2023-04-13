package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SupplierPage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class SupplierPageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	SupplierPage supplierpg;
	Properties prop;
	HomePage homepg;

	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();
	PropertyUtilities propUtil = new PropertyUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	@BeforeMethod
	public void prerun() {
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
		supplierpg = homepg.navigateToSuppliersInPeopleLink();
	}

	@Test(priority = 19, enabled = true)
	public void validateAddSupplierPageHasElementsDisplayed() {
		supplierpg.clickOnAddSupplierButton();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(supplierpg.isSupplierNameDisplayed(), "Failure Message: SupplierName not displayed");
		soft.assertTrue(supplierpg.isSupplierPhoneDisplayed(), "Failure Message: SupplierPhone not displayed");
		soft.assertTrue(supplierpg.isSupplierEmailDisplayed(), "Failure Message: SupplierEmail not displayed");
		soft.assertTrue(supplierpg.isSupplierDescriptionDisplayed(), "Failure Message: SupplierDiscount not displayed");
		soft.assertAll();
	}

	@Test(priority = 20, enabled = true)
	public void validateTheEnteredValuesInSuppliersPage() {
		supplierpg.clickOnAddSupplierButton();
		supplierpg.enterValueToSupplierName("AANNA");
		supplierpg.enterValueToSupplierPhone("1478529631");
		supplierpg.enterValueToSupplierEmail("anna@gmail.com");
		supplierpg.enterValueToSupplierDescription("FIRST SUPPLIER");
		supplierpg.clickOnSupplierSubmitButton();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(supplierpg.getSupplierNameFromSearchResult(), "AANNA",
				"Failure Message: SupplierName not displayed");
		soft.assertEquals(supplierpg.getSupplierPhoneFromSearchResult(), "1478529631",
				"Failure Message:CustomerPhone not displayed");
		soft.assertEquals(supplierpg.getSupplierEmailFromSearchResult(), "anna@gmail.com",
				"Failure Message: CustomerEmail not displayed");
		soft.assertAll();

	}

	@Test(priority = 21, enabled = true)
	public void validateTheEditedSupplierValues() {
		supplierpg.searchForStoreValue("AANNA");
		supplierpg.clickOnSupplierEditIcon();
		supplierpg.enterValueToSupplierEmail("yy@gmail.com");
		supplierpg.enterValueToSupplierPhone("8597461238");
		supplierpg.clickOnSupplierEditSubmitButton();
		supplierpg.searchForStoreValue("yy@gmail.com");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(supplierpg.getSupplierNameFromSearchResult(), "AANNA",
				"Failure Message: No matching records found");
		soft.assertEquals(supplierpg.getSupplierPhoneFromSearchResult(), "8597461238",
				"Failure Message: No matching records found");
		soft.assertEquals(supplierpg.getSupplierEmailFromSearchResult(), "yy@gmail.com",
				"Failure Message: No matching records found");
		soft.assertAll();
	}

	@Test(priority = 22, enabled = true)
	public void validateTheDeleteIcon() {
		supplierpg.searchForStoreValue("AANNA");
		supplierpg.clickOnSupplierDeleteIcon();
		supplierpg.clickOnSupplierDeleteConfirmMessage();
		supplierpg.searchForStoreValue("AANNA");

		Assert.assertEquals(supplierpg.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"Failure message:: failed to delete the store");

	}

}
