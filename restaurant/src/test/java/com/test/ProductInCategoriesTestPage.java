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

	@Test(priority = 27, enabled = false)
	public void validateAddCategoryPageHasElementsDisplayed() throws Exception {
		categoriespg.clickOnAddCategoryButton();
		waitUtil.waitForElementTobeClickable(driver, categoriespg.categoryName, 15);

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(categoriespg.isCategoryNameDisplayed(), "Failure Message: CategoryName not displayed");
		soft.assertAll();
	}

	@Test(priority = 28, enabled = true, dataProvider="dataSupplier", dataProviderClass= DataSupplier.class)
	public void validateEnteredProductValues(String name) throws Exception {
		categoriespg.clickOnAddCategoryButton();
		categoriespg.clickOnCategoryName();
		categoriespg.enterValueToCategoryName(name);
		waitUtil.waitForElementTobeClickable(driver, categoriespg.categorySubmitButton, 20);
		categoriespg.clickOnCategorySubmitButton();
		categoriespg.searchForCategoryProductValue(name);

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(categoriespg.getCategoryProductNameFromSearchResult(), "APPLE_SREE",
				"Failure Message: No matching records found");
		soft.assertAll();
	}

	@Test(priority = 29, enabled = true, dataProvider="dataSupplierEdit", dataProviderClass= DataSupplier.class)
	public void validateTheEditedStoreValues(String edit_name) throws Exception {
		categoriespg.searchForCategoryProductValue("APPLE_SREE");
		categoriespg.clickOnProductEditIcon();
		categoriespg.enterValueToCategoryName(edit_name);
		categoriespg.clickOnProductEditSubmitButton();
		categoriespg.searchForCategoryProductValue(edit_name);

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(categoriespg.getCategoryProductNameFromSearchResult(), "APPLE1_SREE",
				"Failure Message: No matching records found");
		soft.assertAll();

	}

	@Test(priority = 30, enabled = true, dataProvider="dataSupplierDelete", dataProviderClass= DataSupplier.class)
	public void validateTheDeleteIcon(String delete_name) throws Exception {
		categoriespg.searchForCategoryProductValue(delete_name);
		categoriespg.clickOnProductDeleteIcon();
		categoriespg.clickOnProductDeleteConfirmMessage();
		categoriespg.searchForCategoryProductValue(delete_name);

		Assert.assertEquals(categoriespg.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"Failure message:: failed to delete the store");

	}
}
