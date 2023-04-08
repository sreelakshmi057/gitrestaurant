package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.GenericUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;

public class WaiterPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	GenericUtilities genericUtil = new GenericUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	public WaiterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-toggle='modal']")
	public WebElement addWaiterButton;
	@FindBy(xpath = "//input[@id='WaiterName']")
	public WebElement waiterName;
	@FindBy(xpath = "//input[@id='WaiterPhone']")
	public WebElement waiterPhone;
	@FindBy(xpath = "//input[@id='WaiterEmail']")
	public WebElement waiterEmail;
	@FindBy(id = "WaiterStore")
	public WebElement waiterStore;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement waiterSubmitButton;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement waiterSearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement waiterName_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement waiterPhone_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement waiterEmail_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement waiterStore_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement waiterdelete_SearchResult;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement waiterEditButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement waiterDeleteButton;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement waiterEditSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement waiterConfirmDeleteMsg;

	public void clickOnAddWaiterButton() {
		actionUtil.clickElement(driver, addWaiterButton);
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
		genericUtil.SelectByVisibleText(driver, waiterStore, value);
	}

	public void clickOnwaiterSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, waiterSubmitButton, 5);
		actionUtil.clickElement(driver, waiterSubmitButton);
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

	/**
	 * Method for editing the waitervalues
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
	 */
	public void clickOnWaiterDeleteIcon() {
		actionUtil.clickElement(driver, waiterDeleteButton);
	}

	public void clickOnWaiterDeleteConfirmMessage() {
		actionUtil.clickElement(driver, waiterConfirmDeleteMsg);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, waiterdelete_SearchResult);
	}

}
