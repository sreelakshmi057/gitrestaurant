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
import com.pages.ProductInCategoriesPage;
import com.utilities.ExcelUtilities;
import com.utilities.PropertyUtilities;

public class ProductInCategoriesTestPage extends AutomationBase {
	LoginPage loginpg;
	ProductInCategoriesPage categoriespg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;
	ExcelUtilities excelUtil;

	@Test(priority = 26, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddCategoryPageInProductPageInCategoriesLinkHasElementsDisplayed_WhenAddCategoryButtonIsClicked() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		categoriespg = homepg.navigateToProductInCategoriesPage();
		excelUtil = new ExcelUtilities();
		categoriespg.clickOnAddCategoryButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(categoriespg.isCategoryNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 27, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEnteredCategoryValues_AfterClickingAddCategoryButtonInProductPageInCategoryLink() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		categoriespg = homepg.navigateToProductInCategoriesPage();
		excelUtil = new ExcelUtilities();
		categoriespg.clickOnAddCategoryButton();
		String exp_name = excelUtil.readStringData("prdt_category", 2, 2);
		categoriespg.enterValueToCategoryName(exp_name);
		categoriespg.clickOnCategorySubmitButton();
		categoriespg.searchForCategoryProductValue(exp_name);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(categoriespg.getCategoryProductNameFromSearchResult(), exp_name,
				"Failure Message: No matching records found");
		soft.assertAll();
	}

	@Test(priority = 28, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEditedCategoryValues_AfterClickingEditButtonInProductPageInCategoryLink() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		categoriespg = homepg.navigateToProductInCategoriesPage();
		excelUtil = new ExcelUtilities();
		String exp_searchname = excelUtil.readStringData("prdt_category", 5, 2);
		categoriespg.searchForCategoryProductValue(exp_searchname);
		categoriespg.clickOnProductEditIcon();
		String exp_editname = excelUtil.readStringData("prdt_category", 6, 2);
		categoriespg.enterValueToCategoryName(exp_editname);
		categoriespg.clickOnProductEditSubmitButton();
		categoriespg.searchForCategoryProductValue(exp_editname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(categoriespg.getCategoryProductNameFromSearchResult(), exp_editname,
				AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 29, enabled = true)
	public void validateTheDeleteCategoryValues_AfterClickingDeleteButtonInProductPageInCategoryLink() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		categoriespg = homepg.navigateToProductInCategoriesPage();
		excelUtil = new ExcelUtilities();
		String exp_searchname = excelUtil.readStringData("prdt_category", 9, 2);
		categoriespg.searchForCategoryProductValue(exp_searchname);
		categoriespg.clickOnProductDeleteIcon();
		categoriespg.clickOnProductDeleteConfirmMessage();
		categoriespg.searchForCategoryProductValue(exp_searchname);
		Assert.assertEquals(categoriespg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}

	@AfterMethod
	public void postRun() {
		categoriespg.closeTheWindow();
	}
}
