package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.StorePage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class ProductPageTest extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	ProductPage productpg;
	Properties prop;
	HomePage homepg;

	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();
	PropertyUtilities propUtil = new PropertyUtilities();
	WaitUtilities waitUtil= new WaitUtilities();
	

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		loginpg = new LoginPage(driver);
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		productpg= homepg.navigateToProductPage();
	}

	@Test(priority = 7, enabled = true)
	public void validateAddProductPageHasElementsDisplayed() throws Exception{
		productpg.clickOnAddProductButton();
		waitUtil.waitForVisibilityOfElement(driver, By.id("Type"), 10);
	
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(productpg.isProductTypeDisplayed(), "Failure Message: ProductType not displayed");
		soft.assertTrue(productpg.isproductCodeDisplayed(), "Failure Message: ProductCode not displayed");
		soft.assertTrue(productpg.isProductNameDisplayed(), "Failure Message: ProductName not displayed");
		soft.assertTrue(productpg.isProductCategoryDisplayed(), "Failure Message: ProductCategory not displayed");
		soft.assertTrue(productpg.isProductSupplierDisplayed(), "Failure Message: ProductSuppliers not displayed");
		soft.assertTrue(productpg.isProductPurchasePriceDisplayed(), "Failure Message: ProductPurchasePrice not displayed");
		soft.assertTrue(productpg.isProductTaxDisplayed(), "Failure Message: ProductTax not displayed");
		soft.assertTrue(productpg.isProductTaxMethodDisplayed(), "Failure Message: Product Tax Method not displayed");
		soft.assertTrue(productpg.isProductPriceDisplayed(), "Failure Message: ProductPrice not displayed");
		soft.assertTrue(productpg.isProductUnitDisplayed(), "Failure Message: ProductUnit not displayed");
		soft.assertTrue(productpg.isProductAlertQuantityDisplayed(), "Failure Message: ProductAlert not displayed");
		soft.assertTrue(productpg.isProductOptionsDisplayed(), "Failure Message: ProductOptions not displayed");
		soft.assertTrue(productpg.isProductDescriptionDisplayed(), "Failure Message: ProductDescription not displayed");
		soft.assertAll();
		
	}
	
	@Test(priority = 8, enabled = false)
	public void validateEnteredProductValues() throws Exception{
		productpg.clickOnAddProductButton();
		waitUtil.waitForVisibilityOfElement(driver, By.id("Type"), 10);
		productpg.clickOnProductType();
		productpg.selectProductType(0);
		productpg.enterValueToProductCode("");
		productpg.enterValueToProductName("");
		productpg.selectProductCategory(0);
		productpg.selectProductSupplier(0);
		productpg.enterValueToProductPurchasePrice("");
		productpg.enterValueToProductTax("");
		productpg.selectProductTaxMethod(0);
		productpg.enterValueToProductPrice("");
		productpg.enterValueToProductUnit("");
		productpg.enterValueToProductAlertQuantity("");
		productpg.enterValueToProductOptions(null);
		productpg.enterValueToProductDescription("");
		productpg.clickOnProductSubmitButton();
		productpg.searchForProductValue("");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(productpg.getProductCodeFromSearchResult(),"AAA" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductNameFromSearchResult(),"aa@gmail.com" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductCategoryFromSearchResult(), "9498571245" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductDescriptionFromSearchResult(),"INDIA" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductTaxFromSearchResult(),"ADOOR" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductPriceFromSearchResult(),"ADOOR" , "Failure Message: No matching records found");
		soft.assertAll();
	
	}

	@Test(priority = 9, enabled = false)
	public void validateTheEditedStoreValues() throws Exception{
		productpg.searchForProductValue("");
		productpg.clickOnProductEditIcon();
		productpg.enterValueToProductCode("");
		productpg.clickOnProductEditSubmitButton();
		productpg.searchForProductValue("");
	
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(productpg.getProductCodeFromSearchResult(),"ABC" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductNameFromSearchResult(),"abcd@gmail.com" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductCategoryFromSearchResult(), "1234567890" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductDescriptionFromSearchResult(),"INDIA" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductTaxFromSearchResult(),"CHENGANNUR" , "Failure Message: No matching records found");
		soft.assertEquals(productpg.getProductPriceFromSearchResult(),"ADOOR" , "Failure Message: No matching records found");
		soft.assertAll();
		
	}
	
	@Test(priority = 10, enabled = true)
	public void validateTheDeleteIcon() throws Exception{
		productpg.searchForProductValue("");
		productpg.clickOnProductDeleteIcon();
		productpg.searchForProductValue("");
		
		//Assert.	assertEquals(storepg.getStoreNameFromSearch(), "ABCD","Message::Item deleted");
		Assert.fail("Message::Item deleted");
			
	}
}
