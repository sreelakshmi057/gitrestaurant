package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;

public class WaiterPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	GenericUtilities genericUtil = new GenericUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	WebbrowserUtilities brwsrUtil= new WebbrowserUtilities();

	public WaiterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-toggle='modal']")
	private WebElement addWaiterButton;
	@FindBy(xpath = "//input[@id='WaiterName']")
	private WebElement waiterName;
	@FindBy(xpath = "//input[@id='WaiterPhone']")
	private WebElement waiterPhone;
	@FindBy(xpath = "//input[@id='WaiterEmail']")
	private WebElement waiterEmail;
	@FindBy(id = "WaiterStore")
	private WebElement waiterStore;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement waiterSubmitButton;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement waiterSearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement waiterName_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	private WebElement waiterPhone_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	private WebElement waiterEmail_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	private WebElement waiterStore_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement waiterdelete_SearchResult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	private WebElement waiterEditButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	private WebElement waiterDeleteButton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement waiterEditSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	private WebElement waiterConfirmDeleteMsg;

	public void clickOnAddWaiterButton() {
		actionUtil.clickElement(driver, addWaiterButton);
		waitUtil.waitForElementTobeClickable(driver, waiterName, 25);
	}

	/**
	 * This method is to check whether the elements are displayed
	 * 
	 * @return
	 */
	public Boolean isWaiterNameDisplayed() {
		return actionUtil.isElementDisplayed(driver, waiterName);
	}

	public Boolean isWaiterEmailDisplayed() {
		return actionUtil.isElementDisplayed(driver, waiterEmail);
	}

	public Boolean isWaiterPhoneDisplayed() {
		return actionUtil.isElementDisplayed(driver, waiterPhone);
	}

	public Boolean isWaiterStoreDisplayed() {
		return actionUtil.isElementDisplayed(driver, waiterPhone);
	}

	/**
	 * This method is to search for added waiter values
	 * 
	 * @param value
	 */
	public void enterValueToWaiterName(String value) {
		actionUtil.clearText(driver, waiterName);
		actionUtil.enterValue(driver, waiterName, value);
	}

	public void enterValueToWaiterPhone(String value) {
		actionUtil.clearText(driver, waiterPhone);
		actionUtil.enterValue(driver, waiterPhone, value);
	}

	public void enterValueToWaiterEmail(String value) {
		actionUtil.clearText(driver, waiterEmail);
		actionUtil.enterValue(driver, waiterEmail, value);
	}

	/**
	 * This method is to select the dropdown value
	 * 
	 * @param value
	 */
	public void selectWaiterStoreByVisibleText(String value) {
		actionUtil.clearText(driver, waiterStore);
		genericUtil.SelectElementByVisibleText(driver, waiterStore, value);
	}

	public void clickOnwaiterSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, waiterSubmitButton, 15);
		actionUtil.clickElement(driver, waiterSubmitButton);
		waitUtil.waitForVisibilityOfElement(driver, waiterPhone_SearchResult, 15);
	}

	/**
	 * This method is to search for added waiter values
	 * 
	 * @param value
	 */
	public void searchForStoreValue(String value) {
		waitUtil.waitForElementTobeClickable(driver, waiterSearch, 10);
		actionUtil.clickElement(driver, waiterSearch);
		actionUtil.enterValue(driver, waiterSearch, value);
	}

	/**
	 * This method is to get text of search result
	 * 
	 */
	public String getWaiterNameFromSearchResult() {
		return actionUtil.getElementText(driver, waiterName_SearchResult);
	}

	public String getWaiterPhoneFromSearchResult() {
		return actionUtil.getElementText(driver, waiterPhone_SearchResult);
	}

	public String getWaiterEmailFromSearchResult() {
		return actionUtil.getElementText(driver, waiterEmail_SearchResult);
	}

	public String getWaiterStoreFromSearchResult() {
		return actionUtil.getElementText(driver, waiterStore_SearchResult);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, waiterdelete_SearchResult);
	}

	/**
	 * Method for editing the waitervalues
	 * 
	 */

	public void clickOnWaiterEditIcon() {
		actionUtil.clickElement(driver, waiterEditButton);
	}

	public void clickOnWaiterEditSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, waiterEditSubmitButton, 10);
		actionUtil.clickElement(driver, waiterEditSubmitButton);
	}

	/**
	 * Method for deleting waitervalues
	 * 
	 */
	public void clickOnWaiterDeleteIcon() {
		actionUtil.clickElement(driver, waiterDeleteButton);
	}

	public void clickOnWaiterDeleteConfirmMessage() {
		actionUtil.clickElement(driver, waiterConfirmDeleteMsg);
	}
	
	public void closeTheWindow() {
		brwsrUtil.browserQuitPage(driver);
	}

}
