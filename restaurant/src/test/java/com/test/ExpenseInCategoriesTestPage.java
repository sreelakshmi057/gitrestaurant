package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.ExpenseInCategoriesPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ExcelUtilities;
import com.utilities.PropertyUtilities;

public class ExpenseInCategoriesTestPage extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	ExpenseInCategoriesPage cat_expensepg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;
	ExcelUtilities excelUtil;

	@BeforeMethod
	public void prerun() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		cat_expensepg = homepg.navigateToExpenseInCategoriesPage();
		excelUtil = new ExcelUtilities();
	}

	@Test(priority = 30, enabled = true)
	public void validateAddExpensePageHasElementsDisplayed() {
		cat_expensepg.clickOnAddExpenseCategoryButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(cat_expensepg.isCategoryNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 31, enabled = true)
	public void validateEnteredProductValues() {
		cat_expensepg.clickOnAddExpenseCategoryButton();
		String cat_name = excelUtil.readStringData("category", 2, 2);
		cat_expensepg.enterValueToCategoryName(cat_name);
		cat_expensepg.clickOnCategorySubmitButton();
		cat_expensepg.searchForCategoryProductValue(cat_name);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cat_expensepg.getExpenseCategoryNameFromSearchResult(), "APPLE_EXPENSE",
				"Failure Message: No matching records found");
		soft.assertAll();
	}

	@Test(priority = 32, enabled = true)
	public void validateTheEditedStoreValues() {
		String cat_search = excelUtil.readStringData("category", 5, 2);
		cat_expensepg.searchForCategoryProductValue(cat_search);
		cat_expensepg.clickOnProductEditIcon();
		String cat_editname = excelUtil.readStringData("category", 6, 2);
		cat_expensepg.enterValueToCategoryName(cat_editname);
		cat_expensepg.clickOnProductEditSubmitButton();
		cat_expensepg.searchForCategoryProductValue(cat_editname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cat_expensepg.getExpenseCategoryNameFromSearchResult(), "APPLE_SREE_EXPENSE",
				AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 33, enabled = true)
	public void validateTheDeleteIcon() {
		String cat_deletesearch = excelUtil.readStringData("category", 9, 2);
		cat_expensepg.searchForCategoryProductValue(cat_deletesearch);
		cat_expensepg.clickOnProductDeleteIcon();
		cat_expensepg.clickOnProductDeleteConfirmMessage();
		cat_expensepg.searchForCategoryProductValue(cat_deletesearch);
		Assert.assertEquals(cat_expensepg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}

}
