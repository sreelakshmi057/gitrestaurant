package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductInCategoriesPage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ProductInCategoriesTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	ProductInCategoriesPage categoriespg;
	Properties prop;
	HomePage homepg;

	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();
	PropertyUtilities propUtil = new PropertyUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		loginpg = new LoginPage(driver);
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		categoriespg = homepg.navigateToProductInCategoriesPage();

	}

	@Test(priority = 27, enabled = true)
	public void validateAddCategoryPageHasElementsDisplayed() throws Exception {
		categoriespg.clickOnAddCategoryButton();
		waitUtil.waitForElementTobeClickable(driver, categoriespg.categoryName, 15);

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(categoriespg.isCategoryNameDisplayed(), "Failure Message: CategoryName not displayed");
		soft.assertAll();
	}

	@Test(priority = 28, enabled = true)
	public void validateEnteredProductValues() throws Exception {
		categoriespg.clickOnAddCategoryButton();
		categoriespg.clickOnCategoryName();
		categoriespg.enterValueToCategoryName("APPLE_SREE");
		categoriespg.clickOnCategorySubmitButton();
		categoriespg.searchForCategoryProductValue("APPLE_SREE");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(categoriespg.getCategoryProductNameFromSearchResult(), "APPLE_SREE",
				"Failure Message: No matching records found");
		soft.assertAll();
	}

	@Test(priority = 29, enabled = true)
	public void validateTheEditedStoreValues() throws Exception {
		categoriespg.searchForCategoryProductValue("APPLE_SREE");
		categoriespg.clickOnProductEditIcon();
		categoriespg.enterValueToCategoryName("APPLE1_SREE");
		categoriespg.clickOnProductEditSubmitButton();
		categoriespg.searchForCategoryProductValue("APPLE1_SREE");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(categoriespg.getCategoryProductNameFromSearchResult(), "APPLE1_SREE",
				"Failure Message: No matching records found");
		soft.assertAll();

	}

	@Test(priority = 30, enabled = true)
	public void validateTheDeleteIcon() throws Exception {
		categoriespg.searchForCategoryProductValue("APPLE1_SREE");
		categoriespg.clickOnProductDeleteIcon();
		categoriespg.clickOnProductDeleteConfirmMessage();
		categoriespg.searchForCategoryProductValue("APPLE1_SREE");

		Assert.assertEquals(categoriespg.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"Failure message:: failed to delete the store");

	}
}