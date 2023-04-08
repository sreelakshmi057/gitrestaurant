package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;

public class CustomerPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	public WebElement addCustomerButton;
	@FindBy(xpath = "//input[@id='CustomerName']")
	public WebElement customerName;
	@FindBy(xpath = "//input[@id='CustomerPhone']")
	public WebElement customerPhone;
	@FindBy(xpath = "//input[@id='CustomerEmail']")
	public WebElement customerEmail;
	@FindBy(xpath = "//input[@id='CustomerDiscount']")
	public WebElement customerDiscount;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement customerSubmitButton;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement customerSearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement customerName_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement customerPhone_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement customerEmail_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement customerStore_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement customerdelete_SearchResult;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement customerEditButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement customerDeleteButton;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement customerEditSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement customerConfirmDeleteMsg;

	public void clickOnAddCustomerButton() {
		actionUtil.clickElement(driver, addCustomerButton);
	}
	
	public void clickOnAddCustomerName() {
		actionUtil.clickElement(driver, customerName);
	}

	/**
	 * This method is to check whether the elements are displayed
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
	}

	/**
	 * This method is to search for added customer values
	 * 
	 * @param value
	 */
	public void searchForCustomerValue(String value) {
		waitUtil.waitForElementTobeClickable(driver, customerSearch, 5);
		actionUtil.clickElement(driver, customerSearch);
		actionUtil.enterValue(driver, customerSearch, value);
	}

	/**
	 * This method is to get text of search result
	 */
	public String getCustomerNameFromSearchResult() {
		return actionUtil.getElementText(driver, customerName_SearchResult);
	}

	public String getCustomerPhoneFromSearchResult() {
		return actionUtil.getElementText(driver, customerPhone_SearchResult);
	}

	public String getCustomerEmailFromSearchResult() {
		return actionUtil.getElementText(driver, customerEmail_SearchResult);
	}

	/**
	 * Method for editing the customer values
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
	 */
	public void clickOnCustomerDeleteIcon() {
		actionUtil.clickElement(driver, customerDeleteButton);
	}

	public void clickOnCustomerDeleteConfirmMessage() {
		actionUtil.clickElement(driver, customerConfirmDeleteMsg);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, customerdelete_SearchResult);
	}

}
