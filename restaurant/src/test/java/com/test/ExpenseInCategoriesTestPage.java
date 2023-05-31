package com.test;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.ExpenseInCategoriesPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ExcelUtilities;
import com.utilities.GenericUtilities;
import com.utilities.PropertyUtilities;

public class ExpenseInCategoriesTestPage extends AutomationBase {
	LoginPage loginpg;
	ExpenseInCategoriesPage cat_expensepg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;
	ExcelUtilities excelUtil;
	GenericUtilities genericUtil = new GenericUtilities();

	@Test(priority = 30, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddExpensePageInCategoriesLinkHasElementsDisplayed_WhenAddCustomerButtonIsClicked() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		cat_expensepg = homepg.navigateToExpenseInCategoriesPage();
		excelUtil = new ExcelUtilities();
		cat_expensepg.clickOnAddExpenseCategoryButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(cat_expensepg.isCategoryNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 31, enabled = true)
	public void validateTheEnteredCategoryValues_AfterClickingAddCustomerButtonInExpensePageInCategoryLink() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		cat_expensepg = homepg.navigateToExpenseInCategoriesPage();
		excelUtil = new ExcelUtilities();
		cat_expensepg.clickOnAddExpenseCategoryButton();
		String cat_name = genericUtil.generateAlphabeticData(8);
		cat_expensepg.enterValueToCategoryName(cat_name);
		cat_expensepg.clickOnCategorySubmitButton();
		cat_expensepg.searchForCategoryProductValue(cat_name);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cat_expensepg.getExpenseCategoryNameFromSearchResult(), cat_name,
				"Failure Message: No matching records found");
		soft.assertAll();
	}

	@Test(priority = 32, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEditedCategoryValues_AfterClickingEditButtonInExpensePageInCategoryLink() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		cat_expensepg = homepg.navigateToExpenseInCategoriesPage();
		excelUtil = new ExcelUtilities();
		String cat_search = excelUtil.readStringData("category", 5, 2);
		cat_expensepg.searchForCategoryProductValue(cat_search);
		cat_expensepg.clickOnProductEditIcon();
		String cat_editname = excelUtil.readStringData("category", 6, 2);
		cat_expensepg.enterValueToCategoryName(cat_editname);
		cat_expensepg.clickOnProductEditSubmitButton();
		cat_expensepg.searchForCategoryProductValue(cat_editname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(cat_expensepg.getExpenseCategoryNameFromSearchResult(), cat_editname,
				AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 33, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheDeleteIcon_AfterClickingDeleteButtonInExpensePageInCategoryLink() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		cat_expensepg = homepg.navigateToExpenseInCategoriesPage();
		excelUtil = new ExcelUtilities();
		String cat_deletesearch = excelUtil.readStringData("category", 9, 2);
		cat_expensepg.searchForCategoryProductValue(cat_deletesearch);
		cat_expensepg.clickOnProductDeleteIcon();
		cat_expensepg.clickOnProductDeleteConfirmMessage();
		cat_expensepg.searchForCategoryProductValue(cat_deletesearch);
		Assert.assertEquals(cat_expensepg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}

	@AfterMethod
	public void postRun() {
		cat_expensepg.closeTheWindow();
	}

}
