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
import com.pages.ProductPage;
import com.utilities.ExcelUtilities;
import com.utilities.PropertyUtilities;

public class ProductPageTest extends AutomationBase {
	LoginPage loginpg;
	ProductPage productpg;
	Properties prop;
	HomePage homepg;
	ExcelUtilities excelUtil;
	PropertyUtilities propUtil;

	@Test(priority = 3, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddProductPageHasElementsDisplayed_WhenAddProductButtonIsClicked() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		productpg = homepg.navigateToProductPage();
		excelUtil = new ExcelUtilities();
		productpg.clickOnAddProductButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(productpg.isProductTypeDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isproductCodeDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductCategoryDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductSupplierDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEnteredProductValues_AfterClickingAddProductButtonInProductPage() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		productpg = homepg.navigateToProductPage();
		excelUtil = new ExcelUtilities();
		productpg.clickOnAddProductButton();
		productpg.selectProductType(0);
		String prdtcode = excelUtil.readStringData("product", 2, 2);
		productpg.enterValueToProductCode(prdtcode);
		String prdtname = excelUtil.readStringData("product", 3, 2);
		productpg.enterValueToProductName(prdtname);
		productpg.selectProductCategory(11);
		productpg.selectProductSupplier(1);
		String purchaseprice = excelUtil.readStringData("product", 4, 2);
		productpg.enterValueToProductPurchasePrice(purchaseprice);
		String prdttax = excelUtil.readStringData("product", 5, 2);
		productpg.enterValueToProductTax(prdttax);
		productpg.selectProductTaxMethod(0);
		String prdtprice = excelUtil.readStringData("product", 6, 2);
		productpg.enterValueToProductPrice(prdtprice);
		String prdtunit = excelUtil.readStringData("product", 7, 2);
		productpg.enterValueToProductUnit(prdtunit);
		String prdtalert = excelUtil.readStringData("product", 8, 2);
		productpg.enterValueToProductAlertQuantity(prdtalert);
		String prdtoption = excelUtil.readStringData("product", 9, 2);
		productpg.enterValueToProductOptions(prdtoption);
		String prdtdescription = excelUtil.readStringData("product", 10, 2);
		productpg.enterValueToProductDescription(prdtdescription);
		productpg.clickOnProductSubmitButton();
		productpg.searchForProductValue(prdtname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(productpg.getProductCodeFromSearchResult(), prdtcode, AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductNameFromSearchResult(), prdtname, AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductTaxFromSearchResult(), prdttax, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEditedProducteValues_AfterClickingEdittButtonInProductPage() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		productpg = homepg.navigateToProductPage();
		excelUtil = new ExcelUtilities();
		String prdtsearch = excelUtil.readStringData("product", 14, 2);
		productpg.searchForProductValue(prdtsearch);
		productpg.clickOnProductEditIcon();
		String prdtname = excelUtil.readStringData("product", 13, 2);
		productpg.enterValueToProductName(prdtname);
		productpg.clickOnProductEditSubmitButton();
		productpg.searchForProductValue(prdtname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(productpg.getProductNameFromSearchResult(), prdtname, AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 6, enabled = true)
	public void validateTheDeleteIcon_AfterClickingDeleteButtonInProductPage() {
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		productpg = homepg.navigateToProductPage();
		excelUtil = new ExcelUtilities();
		String prdtdelete = excelUtil.readStringData("product", 17, 2);
		productpg.searchForProductValue(prdtdelete);
		productpg.clickOnProductDeleteIcon();
		productpg.clickOnProductDeleteConfirmMessage();
		productpg.searchForProductValue(prdtdelete);
		Assert.assertEquals(productpg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}

	@AfterMethod
	public void postRun() {
		productpg.closeTheWindow();
	}
}
