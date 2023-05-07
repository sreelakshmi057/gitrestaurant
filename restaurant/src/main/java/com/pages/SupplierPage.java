package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;

public class SupplierPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	GenericUtilities genericUtil = new GenericUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	public SupplierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Add Supplier')]")
	private WebElement addSupplierButton;
	@FindBy(xpath = "//input[@id='SupplierName']")
	private WebElement supplierName;
	@FindBy(xpath = "//input[@id='SupplierPhone']")
	private WebElement supplierPhone;
	@FindBy(xpath = "//input[@id='SupplierEmail']")
	private WebElement supplierEmail;
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	private WebElement supplierDescription;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement supplierSubmitButton;

	@FindBy(xpath = "//input[@class='form-control input-sm' and @type='search']")
	private WebElement supplierSearchtab;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement supplierName_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	private WebElement supplierPhone_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	private WebElement supplierEmail_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	private WebElement supplierStore_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement supplierdelete_SearchResult;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	private WebElement supplierEditButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	private WebElement supplierDeleteButton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement supplierEditSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	private WebElement supplierConfirmDeleteMsg;

	public void clickOnAddSupplierButton() {
		actionUtil.clickElement(driver, addSupplierButton);
		waitUtil.waitForElementTobeClickable(driver, supplierName, 15);
	}

	/**
	 * This method is to check whether the elements are displayed
	 * 
	 * @return
	 */
	public Boolean isSupplierNameDisplayed() {
		return actionUtil.isElementDisplayed(driver, supplierName);
	}

	public Boolean isSupplierEmailDisplayed() {
		return actionUtil.isElementDisplayed(driver, supplierEmail);
	}

	public Boolean isSupplierPhoneDisplayed() {
		return actionUtil.isElementDisplayed(driver, supplierPhone);
	}

	public Boolean isSupplierDescriptionDisplayed() {
		return actionUtil.isElementDisplayed(driver, supplierDescription);
	}

	/**
	 * This method is to search for added supplier values
	 * 
	 * @param value
	 */
	public void enterValueToSupplierName(String value) {
		actionUtil.clearText(driver, supplierName);
		actionUtil.enterValue(driver, supplierName, value);
	}

	public void enterValueToSupplierPhone(String value) {
		actionUtil.clearText(driver, supplierPhone);
		actionUtil.enterValue(driver, supplierPhone, value);
	}

	public void enterValueToSupplierEmail(String value) {
		actionUtil.clearText(driver, supplierEmail);
		actionUtil.enterValue(driver, supplierEmail, value);
	}

	public void enterValueToSupplierDescription(String value) {
		actionUtil.clearText(driver, supplierDescription);
		actionUtil.enterValue(driver, supplierDescription, value);
	}

	public void clickOnSupplierSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, supplierSubmitButton, 5);
		actionUtil.clickElement(driver, supplierSubmitButton);
	}

	/**
	 * This method is to search for added supplier values
	 * 
	 * @param value
	 */
	public void searchForStoreValue(String value) {
		waitUtil.waitForElementTobeClickable(driver, supplierSearchtab, 5);
		actionUtil.clickElement(driver, supplierSearchtab);
		actionUtil.enterValue(driver, supplierSearchtab, value);
	}

	/**
	 * This method is to get text of search result
	 * 
	 */
	public String getSupplierNameFromSearchResult() {
		return actionUtil.getElementText(driver, supplierName_SearchResult);
	}

	public String getSupplierPhoneFromSearchResult() {
		return actionUtil.getElementText(driver, supplierPhone_SearchResult);
	}

	public String getSupplierEmailFromSearchResult() {
		return actionUtil.getElementText(driver, supplierEmail_SearchResult);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, supplierdelete_SearchResult);
	}

	/**
	 * Method for editing the customer values
	 * 
	 */
	public void clickOnSupplierEditIcon() {
		actionUtil.clickElement(driver, supplierEditButton);
	}

	public void clickOnSupplierEditSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, supplierEditSubmitButton, 10);
		actionUtil.clickElement(driver, supplierEditSubmitButton);
	}

	/**
	 * Method for deleting waitervalues
	 * 
	 */
	public void clickOnSupplierDeleteIcon() {
		actionUtil.clickElement(driver, supplierDeleteButton);
	}

	public void clickOnSupplierDeleteConfirmMessage() {
		actionUtil.clickElement(driver, supplierConfirmDeleteMsg);
	}

}
