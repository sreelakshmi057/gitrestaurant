package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.StorePage;
import com.utilities.ExcelUtilities;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ProductPageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	ProductPage productpg;
	Properties prop;
	HomePage homepg;
	ExcelUtilities excelUtil;

	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();
	PropertyUtilities propUtil = new PropertyUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		waitUtil.implicitWait(driver, 5);
		loginpg = new LoginPage(driver);
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		productpg = homepg.navigateToProductPage();
		excelUtil= new ExcelUtilities("restaurantdata.xlsx");
	}

	@Test(priority = 3, enabled = true)
	public void validateAddProductPageHasElementsDisplayed() throws Exception {
		productpg.clickOnAddProductButton();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(productpg.isProductTypeDisplayed(), "Failure Message: ProductType not displayed");
		soft.assertTrue(productpg.isproductCodeDisplayed(), "Failure Message: ProductCode not displayed");
		soft.assertTrue(productpg.isProductNameDisplayed(), "Failure Message: ProductName not displayed");
		soft.assertTrue(productpg.isProductCategoryDisplayed(), "Failure Message: ProductCategory not displayed");
		soft.assertTrue(productpg.isProductSupplierDisplayed(), "Failure Message: ProductSuppliers not displayed");
		soft.assertTrue(productpg.isProductPurchasePriceDisplayed(),
				"Failure Message: ProductPurchasePrice not displayed");
		soft.assertTrue(productpg.isProductTaxDisplayed(), "Failure Message: ProductTax not displayed");
		soft.assertTrue(productpg.isProductTaxMethodDisplayed(), "Failure Message: Product Tax Method not displayed");
		soft.assertTrue(productpg.isProductPriceDisplayed(), "Failure Message: ProductPrice not displayed");
		soft.assertTrue(productpg.isProductUnitDisplayed(), "Failure Message: ProductUnit not displayed");
		soft.assertTrue(productpg.isProductAlertQuantityDisplayed(), "Failure Message: ProductAlert not displayed");
		soft.assertTrue(productpg.isProductOptionsDisplayed(), "Failure Message: ProductOptions not displayed");
		soft.assertTrue(productpg.isProductDescriptionDisplayed(), "Failure Message: ProductDescription not displayed");
		soft.assertAll();

	}

	@Test(priority = 4, enabled = true)
	public void validateEnteredProductValues() throws Exception {
		productpg.clickOnAddProductButton();
		waitUtil.waitForElementTobeClickable(driver, productpg.productType, 15);
		productpg.clickOnProductType();
		productpg.selectProductType(0);
		String Prdtcode= excelUtil.readStringData("product", 2, 2);
		productpg.enterValueToProductCode(Prdtcode);
		String Prdtname= excelUtil.readStringData("product", 3, 2);
		productpg.enterValueToProductName(Prdtname);
		productpg.selectProductCategory(11);
		productpg.selectProductSupplier(1);
		String Purchaseprice= excelUtil.readStringData("product", 4, 2);
		productpg.enterValueToProductPurchasePrice(Purchaseprice);
		String Prdttax= excelUtil.readStringData("product", 5, 2);
		productpg.enterValueToProductTax(Prdttax);
		productpg.selectProductTaxMethod(0);
		String Prdtprice= excelUtil.readStringData("product", 6, 2);
		productpg.enterValueToProductPrice(Prdtprice);
		String Prdtunit= excelUtil.readStringData("product", 7, 2);
		productpg.enterValueToProductUnit(Prdtunit);
		String Prdtalert= excelUtil.readStringData("product", 8, 2);
		productpg.enterValueToProductAlertQuantity(Prdtalert);
		String Prdtoption= excelUtil.readStringData("product", 9, 2);
		productpg.enterValueToProductOptions(Prdtoption);
		String Prdtdescription= excelUtil.readStringData("product", 10, 2);
		productpg.enterValueToProductDescription(Prdtdescription);
		productpg.clickOnProductSubmitButton();
		productpg.searchForProductValue("APPLE");
		waitUtil.waitForVisibilityOfElement(driver, productpg.productCode_SearchResult, 20);

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(productpg.getProductCodeFromSearchResult(), "0",
				"Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductNameFromSearchResult(), "APPLE",
				"Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductCategoryFromSearchResult(), "fruits",
				"Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductDescriptionFromSearchResult(), "FRESH",
				"Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductTaxFromSearchResult(), "18",
				"Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductPriceFromSearchResult(), "10.000 abc",
				"Failure Message: No matching records found");
		soft.assertAll();

	}

	@Test(priority = 5, enabled = false)
	public void validateTheEditedStoreValues() throws Exception {
		productpg.searchForProductValue("0");
		productpg.clickOnProductEditIcon();
		String Prdtname= excelUtil.readStringData("product", 13, 2);
		productpg.enterValueToProductName(Prdtname);
		productpg.clickOnProductEditSubmitButton();
		productpg.searchForProductValue("APPLE1");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(productpg.getProductCodeFromSearchResult(), "0",
				"Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductNameFromSearchResult(), "APPLE1",
				"Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductCategoryFromSearchResult(), "fruits",
				"Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductDescriptionFromSearchResult(), "FRESH",
				"Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductTaxFromSearchResult(), "18",
				"Failure Message: No matching records found");
		soft.assertAll();

	}

	@Test(priority = 6, enabled = false)
	public void validateTheDeletedItems() throws Exception {
		productpg.searchForProductValue("APPLE1");
		productpg.clickOnProductDeleteIcon();
		productpg.clickOnProductDeleteConfirmMessage();
		productpg.searchForProductValue("APPLE1");

		Assert.assertEquals(productpg.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"Failure message:: failed to delete the store");

	}
}
