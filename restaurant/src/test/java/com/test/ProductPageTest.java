package com.test;

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
import com.pages.ProductPage;
import com.utilities.ExcelUtilities;
import com.utilities.PropertyUtilities;

public class ProductPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	ProductPage productpg;
	Properties prop;
	HomePage homepg;
	ExcelUtilities excelUtil;
	PropertyUtilities propUtil;

	@BeforeMethod
	public void prerun() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		productpg = homepg.navigateToProductPage();
		excelUtil = new ExcelUtilities();
	}

	@Test(priority = 3, enabled = true)
	public void validateAddProductPageHasElementsDisplayed() {
		productpg.clickOnAddProductButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(productpg.isProductTypeDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isproductCodeDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductCategoryDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductSupplierDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductPurchasePriceDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductTaxDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductTaxMethodDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductPriceDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductUnitDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductAlertQuantityDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductOptionsDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(productpg.isProductDescriptionDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void validateEnteredProductValues() {
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
		soft.assertEquals(productpg.getProductCodeFromSearchResult(), "0", AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductNameFromSearchResult(), "APPLE", AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductCategoryFromSearchResult(), "fruits", AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductDescriptionFromSearchResult(), "FRESH", AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductTaxFromSearchResult(), "18", AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 5, enabled = true)
	public void validateTheEditedProducteValues() {
		String prdtsearch = excelUtil.readStringData("product", 14, 2);
		productpg.searchForProductValue(prdtsearch);
		productpg.clickOnProductEditIcon();
		String prdtname = excelUtil.readStringData("product", 13, 2);
		productpg.enterValueToProductName(prdtname);
		productpg.clickOnProductEditSubmitButton();
		productpg.searchForProductValue(prdtname);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(productpg.getProductCodeFromSearchResult(), "0", AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductNameFromSearchResult(), "APPLE1", AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductCategoryFromSearchResult(), "fruits", AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductDescriptionFromSearchResult(), "FRESH", AutomationConstants.errorMessage);
		soft.assertEquals(productpg.getProductTaxFromSearchResult(), "18", AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 6, enabled = true)
	public void validateTheDeleteIcon() {
		String prdtdelete = excelUtil.readStringData("product", 17, 2);
		productpg.searchForProductValue(prdtdelete);
		productpg.clickOnProductDeleteIcon();
		productpg.clickOnProductDeleteConfirmMessage();
		productpg.searchForProductValue(prdtdelete);
		Assert.assertEquals(productpg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);
	}
}
