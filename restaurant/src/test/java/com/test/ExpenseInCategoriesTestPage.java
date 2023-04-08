package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.ExpenseInCategoriesPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ExpenseInCategoriesTestPage extends AutomationBase {
	
	WebDriver driver;
	LoginPage loginpg;
	ExpenseInCategoriesPage cat_expensepg;
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
		cat_expensepg = homepg.navigateToExpenseInCategoriesPage();
	}

	@Test(priority = 31, enabled = true)
	public void validateAddCategoryPageHasElementsDisplayed() throws Exception {
		cat_expensepg.clickOnAddExpenseCategoryButton();
		waitUtil.waitForElementTobeClickable(driver, cat_expensepg.expenseCategoryName, 15);
        
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(cat_expensepg.isCategoryNameDisplayed(), "Failure Message: CategoryName not displayed");
		soft.assertAll();
	}

	@Test(priority = 32, enabled = true)
	public void validateEnteredProductValues() throws Exception {
		cat_expensepg.clickOnAddExpenseCategoryButton();
		cat_expensepg.clickOnCategoryName();
		cat_expensepg.enterValueToCategoryName("APPLE_EXPENSE");
		cat_expensepg.clickOnCategorySubmitButton();
		cat_expensepg.searchForCategoryProductValue("APPLE_EXPENSE");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cat_expensepg.getExpenseCategoryNameFromSearchResult(), "APPLE_EXPENSE",
				"Failure Message: No matching records found");
		soft.assertAll();
	}
	
	@Test(priority =33, enabled = true)
	public void validateTheEditedStoreValues() throws Exception {
		cat_expensepg.searchForCategoryProductValue("APPLE_EXPENSE");
		cat_expensepg.clickOnProductEditIcon();
		cat_expensepg.enterValueToCategoryName("APPLE1_EXPENSE");
		cat_expensepg.clickOnProductEditSubmitButton();
		cat_expensepg.searchForCategoryProductValue("APPLE1_EXPENSE");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cat_expensepg.getExpenseCategoryNameFromSearchResult(), "APPLE1_EXPENSE",
				"Failure Message: No matching records found");
		soft.assertAll();

	}
	
	@Test(priority = 34, enabled = true)
	public void validateTheDeleteIcon() throws Exception {
		cat_expensepg.searchForCategoryProductValue("APPLE1_EXPENSE");
		cat_expensepg.clickOnProductDeleteIcon();
		cat_expensepg.clickOnProductDeleteConfirmMessage();
		cat_expensepg.searchForCategoryProductValue("APPLE1_EXPENSE");

		Assert.assertEquals(cat_expensepg.getTheSearchResultOfDeletedEntry(), "No matching records found","Failure message:: failed to delete the store" );


	}

}
