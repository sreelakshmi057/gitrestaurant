package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductInCategoriesPage;
import com.utilities.PropertyUtilities;

public class ProductInCategoriesTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	ProductInCategoriesPage categoriespg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		categoriespg = homepg.navigateToProductInCategoriesPage();

	}

	@Test(priority = 27, enabled = true)
	public void validateAddProductInCategoryPageHasElementsDisplayed() {
		categoriespg.clickOnAddCategoryButton();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(categoriespg.isCategoryNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 28, enabled = true)
	public void validateEnteredProductValues() {
		categoriespg.clickOnAddCategoryButton();
		categoriespg.enterValueToCategoryName("APPLE_SREE");
		categoriespg.clickOnCategorySubmitButton();
		categoriespg.searchForCategoryProductValue("APPLE_SREE");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(categoriespg.getCategoryProductNameFromSearchResult(), "APPLE_SREE",
				"Failure Message: No matching records found");
		soft.assertAll();
	}

	@Test(priority = 29, enabled = true)
	public void validateTheEditedProductValues() {
		categoriespg.searchForCategoryProductValue("APPLE_SREE");
		categoriespg.clickOnProductEditIcon();
		categoriespg.enterValueToCategoryName("APPLE1_SREE");
		categoriespg.clickOnProductEditSubmitButton();
		categoriespg.searchForCategoryProductValue("APPLE1_SREE");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(categoriespg.getCategoryProductNameFromSearchResult(), "APPLE1_SREE",
				AutomationConstants.errorMessage);
		soft.assertAll();

	}

	@Test(priority = 30, enabled = true)
	public void validateTheDeleteIcon() {
		categoriespg.searchForCategoryProductValue("APPLE1_SREE");
		categoriespg.clickOnProductDeleteIcon();
		categoriespg.clickOnProductDeleteConfirmMessage();
		categoriespg.searchForCategoryProductValue("APPLE1_SREE");

		Assert.assertEquals(categoriespg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);

	}
}
