package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;

public class CustomerPage {
	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	WebbrowserUtilities brwsrUtil= new WebbrowserUtilities();

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	private WebElement addCustomerButton;
	@FindBy(xpath = "//input[@id='CustomerName']")
	private WebElement customerName;
	@FindBy(xpath = "//input[@id='CustomerPhone']")
	private WebElement customerPhone;
	@FindBy(xpath = "//input[@id='CustomerEmail']")
	private WebElement customerEmail;
	@FindBy(xpath = "//input[@id='CustomerDiscount']")
	private WebElement customerDiscount;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement customerSubmitButton;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement customerSearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement customerName_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	private WebElement customerPhone_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	private WebElement customerEmail_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	private WebElement customerStore_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement customerdelete_SearchResult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	private WebElement customerEditButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	private WebElement customerDeleteButton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement customerEditSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	private WebElement customerConfirmDeleteMsg;

	public void clickOnAddCustomerButton() {
		actionUtil.clickElement(driver, addCustomerButton);
		waitUtil.waitForElementTobeClickable(driver, customerName, 15);
		actionUtil.clickElement(driver, customerName);
	}

	/**
	 * These methods are to check whether the elements are displayed
	 * 
	 * @return
	 */
	public Boolean isCustomerNameDisplayed() {
		return actionUtil.isElementDisplayed(driver, customerName);
	}

	public Boolean isCustomerEmailDisplayed() {
		return actionUtil.isElementDisplayed(driver, customerEmail);
	}

	public Boolean isCustomerPhoneDisplayed() {
		return actionUtil.isElementDisplayed(driver, customerPhone);
	}

	public Boolean isCustomerDiscountDisplayed() {
		return actionUtil.isElementDisplayed(driver, customerDiscount);
	}

	/**
	 * This method is to search for added customer values
	 * 
	 * @param value
	 */
	public void enterValueToCustomerName(String value) {
		actionUtil.clearText(driver, customerName);
		actionUtil.enterValue(driver, customerName, value);
	}

	public void enterValueToCustomerPhone(String value) {
		actionUtil.clearText(driver, customerPhone);
		actionUtil.enterValue(driver, customerPhone, value);
	}

	public void enterValueToCustomerEmail(String value) {
		actionUtil.clearText(driver, customerEmail);
		actionUtil.enterValue(driver, customerEmail, value);
	}

	public void enterValueToCustomerDiscount(String value) {
		actionUtil.clearText(driver, customerDiscount);
		actionUtil.enterValue(driver, customerDiscount, value);
	}

	public void clickOnCustomerSubmitButton() {
		actionUtil.clickElement(driver, customerSubmitButton);
		waitUtil.waitForElementTobeClickable(driver, customerPhone_SearchResult, 20);
	}

	/**
	 * This method is to search for added customer values
	 * 
	 * @param value
	 */
	public void searchForCustomerValue(String value) {
		waitUtil.waitForElementTobeClickable(driver, customerSearch, 15);
		actionUtil.clickElement(driver, customerSearch);
		actionUtil.enterValue(driver, customerSearch, value);
		waitUtil.waitForVisibilityOfElement(driver, customerdelete_SearchResult, 15);
	}

	/**
	 * This method is to get text of search result
	 * 
	 */
	public String getCustomerNameFromSearchResult() {
		waitUtil.waitForVisibilityOfElement(driver, customerName_SearchResult, 10);
		return actionUtil.getElementText(driver, customerName_SearchResult);
	}

	public String getCustomerPhoneFromSearchResult() {
		waitUtil.waitForVisibilityOfElement(driver, customerPhone_SearchResult, 10);
		return actionUtil.getElementText(driver, customerPhone_SearchResult);
	}

	public String getCustomerEmailFromSearchResult() {
		return actionUtil.getElementText(driver, customerEmail_SearchResult);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, customerdelete_SearchResult);
	}

	/**
	 * Method for editing the customer values
	 * 
	 */

	public void clickOnCustomerEditIcon() {
		actionUtil.clickElement(driver, customerEditButton);
	}

	public void clickOnCustomerEditSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, customerEditSubmitButton, 10);
		actionUtil.clickElement(driver, customerEditSubmitButton);
	}

	/**
	 * Method for deleting waitervalues
	 * 
	 */
	public void clickOnCustomerDeleteIcon() {
		actionUtil.clickElement(driver, customerDeleteButton);
	}

	public void clickOnCustomerDeleteConfirmMessage() {
		actionUtil.clickElement(driver, customerConfirmDeleteMsg);
	}
	
	public void closeTheWindow() {
		brwsrUtil.browserQuitPage(driver);
	}

}
