package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.GenericUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;

public class ProductPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	GenericUtilities genericUtil = new GenericUtilities();

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Add Product')]")
	public WebElement addProductButton;
	@FindBy(id = "Type")
	public WebElement productType;
	@FindBy(id = "ProductCode")
	public WebElement productCode;
	@FindBy(id = "ProductName")
	public WebElement productName;
	@FindBy(id = "Category")
	public WebElement productCategory;
	@FindBy(id = "Supplier")
	public WebElement productSupplier;
	@FindBy(id = "PurchasePrice")
	public WebElement productPurchasePrice;
	@FindBy(id = "Tax")
	public WebElement productTax;
	@FindBy(id = "taxType")
	public WebElement productTaxMethod;
	@FindBy(id = "Price")
	public WebElement productPrice;
	@FindBy(id = "Unit")
	public WebElement productUnit;
	@FindBy(id = "AlertQt")
	public WebElement productAlertQuantity;
	@FindBy(id = "ProductOptions")
	public WebElement productOptions;
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	public WebElement productDescription;
	@FindBy(xpath = "//button[@class='btn btn-add']")
	public WebElement productSubmitButton;
	@FindBy(xpath = "//body/div[@id='stock']/div[@id='stockModal']/div[1]/div[3]/button[2]")
	public WebElement productStockSubmitButton;

	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement productCode_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement productName_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement productCategory_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement productDescription_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	public WebElement productTax_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[6]")
	public WebElement productPrice_SearchResult;
	@FindBy(xpath = "//input[@type='search']")
	public WebElement productSearchButton;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement delete_SearchResult;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[3]")
	public WebElement productEditButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement productDeleteButton;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement productEditSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement productConfirmDeleteMsg;

	public void clickOnAddProductButton() {
		actionUtil.clickElement(driver, addProductButton);
	}

	public void clickOnProductType() {
		actionUtil.clickElement(driver, productType);
	}

	/**
	 * This method is to check whether elements are displayed
	 * 
	 * @return
	 */
	public Boolean isProductTypeDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productType, 20);
		return actionUtil.isElementDisplayed(driver, productType);
	}

	public Boolean isproductCodeDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productCode, 20);
		return actionUtil.isElementDisplayed(driver, productCode);
	}

	public Boolean isProductNameDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productName, 20);
		return actionUtil.isElementDisplayed(driver, productName);
	}

	public Boolean isProductCategoryDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productCategory, 20);
		return actionUtil.isElementDisplayed(driver, productCategory);
	}

	public Boolean isProductSupplierDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productSupplier, 20);
		return actionUtil.isElementDisplayed(driver, productSupplier);
	}

	public Boolean isProductPurchasePriceDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productPurchasePrice, 20);
		return actionUtil.isElementDisplayed(driver, productPurchasePrice);
	}

	public Boolean isProductTaxDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productTax, 20);
		return actionUtil.isElementDisplayed(driver, productTax);
	}

	public Boolean isProductTaxMethodDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productTaxMethod, 20);
		return actionUtil.isElementDisplayed(driver, productTaxMethod);
	}

	public Boolean isProductPriceDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productPrice, 20);
		return actionUtil.isElementDisplayed(driver, productPrice);
	}

	public Boolean isProductUnitDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productUnit, 20);
		return actionUtil.isElementDisplayed(driver, productUnit);
	}

	public Boolean isProductAlertQuantityDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productAlertQuantity, 20);
		return actionUtil.isElementDisplayed(driver, productAlertQuantity);
	}

	public Boolean isProductOptionsDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productOptions, 20);
		return actionUtil.isElementDisplayed(driver, productOptions);
	}

	public Boolean isProductDescriptionDisplayed() {
		waitUtil.waitForElementTobeClickable(driver, productDescription, 20);
		return actionUtil.isElementDisplayed(driver, productDescription);
	}

	/**
	 * This methods are to fill up the add product field
	 * 
	 * @param value
	 * @param index
	 */

	public void selectProductType(int index) {
		actionUtil.clearText(driver, productType);
		genericUtil.SelectElementByIndex(driver, productType, index);
	}

	public void enterValueToProductCode(String value) {
		actionUtil.clearText(driver, productCode);
		actionUtil.enterValue(driver, productCode, value);
	}

	public void enterValueToProductName(String value) {
		actionUtil.clearText(driver, productName);
		actionUtil.enterValue(driver, productName, value);
	}

	public void selectProductCategory(int index) {
		actionUtil.clearText(driver, productCategory);
		genericUtil.SelectElementByIndex(driver, productCategory, index);
	}

	public void selectProductSupplier(int index) {
		actionUtil.clearText(driver, productSupplier);
		genericUtil.SelectElementByIndex(driver, productSupplier, index);
	}

	public void enterValueToProductPurchasePrice(String value) {
		actionUtil.clearText(driver, productPurchasePrice);
		actionUtil.enterValue(driver, productPurchasePrice, value);
	}

	public void enterValueToProductTax(String value) {
		actionUtil.clearText(driver, productTax);
		actionUtil.enterValue(driver, productTax, value);
	}

	public void selectProductTaxMethod(int index) {
		actionUtil.clearText(driver, productTaxMethod);
		genericUtil.SelectElementByIndex(driver, productTaxMethod, index);
	}

	public void enterValueToProductPrice(String value) {
		actionUtil.clearText(driver, productPrice);
		actionUtil.enterValue(driver, productPrice, value);
	}

	public void enterValueToProductUnit(String value) {
		actionUtil.clearText(driver, productUnit);
		actionUtil.enterValue(driver, productUnit, value);
	}

	public void enterValueToProductAlertQuantity(String value) {
		actionUtil.clearText(driver, productAlertQuantity);
		actionUtil.enterValue(driver, productAlertQuantity, value);
	}

	public void enterValueToProductOptions(String value) {
		actionUtil.clearText(driver, productOptions);
		actionUtil.enterValue(driver, productOptions, value);
	}

	public void enterValueToProductDescription(String value) {
		actionUtil.clearText(driver, productDescription);
		actionUtil.enterValue(driver, productDescription, value);
	}

	public void clickOnProductSubmitButton() {
		actionUtil.clickElement(driver, productSubmitButton);
		waitUtil.waitForElementTobeClickable(driver, productStockSubmitButton, 5);
		actionUtil.clickElement(driver, productStockSubmitButton);
	}

	/**
	 * This method is to search for the added productvalues
	 * 
	 * @param value
	 */

	public void searchForProductValue(String value) {
		actionUtil.clickElement(driver, productSearchButton);
		waitUtil.waitForElementTobeClickable(driver, productSearchButton, 5);
		actionUtil.enterValue(driver, productSearchButton, value);
	}

	/**
	 * This method is to get text of search result
	 */
	public String getProductCodeFromSearchResult() {
		return actionUtil.getElementText(driver, productCode_SearchResult);
	}

	public String getProductNameFromSearchResult() {
		return actionUtil.getElementText(driver, productName_SearchResult);
	}

	public String getProductCategoryFromSearchResult() {
		return actionUtil.getElementText(driver, productCategory_SearchResult);
	}

	public String getProductDescriptionFromSearchResult() {
		return actionUtil.getElementText(driver, productDescription_SearchResult);
	}

	public String getProductTaxFromSearchResult() {
		return actionUtil.getElementText(driver, productTax_SearchResult);
	}

	public String getProductPriceFromSearchResult() {
		return actionUtil.getElementText(driver, productPrice_SearchResult);
	}

	/**
	 * Method for editing the productvalues
	 */

	public void clickOnProductEditIcon() {
		actionUtil.clickElement(driver, productEditButton);
	}

	public void clickOnProductEditSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, productEditSubmitButton, 10);
		actionUtil.clickElement(driver, productEditSubmitButton);
	}

	/**
	 * Method for deleting productvalues
	 */
	public void clickOnProductDeleteIcon() {
		actionUtil.clickElement(driver, productDeleteButton);
	}

	public void clickOnProductDeleteConfirmMessage() {
		actionUtil.clickElement(driver, productConfirmDeleteMsg);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, delete_SearchResult);
	}

}
