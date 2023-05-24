package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;

public class StorePage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();

	public StorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-toggle='modal'and@data-target='#AddStore']")
	private WebElement addStoreButton;
	@FindBy(xpath = "//input[@id='StoreName']")
	private WebElement storeName;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement storeEmail;
	@FindBy(xpath = "//input[@id='StorePhone']")
	private WebElement storePhone;
	@FindBy(xpath = "//input[@id='Country']")
	private WebElement storeCountry;
	@FindBy(xpath = "//input[@id='City']")
	private WebElement storeCity;
	@FindBy(xpath = "//input[@id='Adresse']")
	private WebElement storeAddress;
	@FindBy(xpath = "//input[@id='CustomeFooter']")
	private WebElement storeCustomerFooter;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement storeSubmitButton;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	private WebElement storeSearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement storeName_searchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	private WebElement storeEmail_searchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	private WebElement storePhone_searchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	private WebElement storeCountry_searchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	private WebElement storeCity_searchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement storedelete_searchResult;
	@FindBy(xpath = "//a[@class='btn btn-default']")
	private WebElement storeDeleteButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	private WebElement storeEditButton;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement storeEditSubmitButton;

	public void clickOnAddStoreButton() {
		actionUtil.clickElement(driver, addStoreButton);
		waitUtil.waitForElementTobeClickable(driver, storeName, 20);
		actionUtil.clickElement(driver, storeName);
	}

	public void enterValueToStoreName(String value) {
		actionUtil.clearText(driver, storeName);
		actionUtil.enterValue(driver, storeName, value);
	}

	public void enterValueToStoreMail(String value) {
		actionUtil.clearText(driver, storeEmail);
		actionUtil.enterValue(driver, storeEmail, value);
		waitUtil.waitForElementTobeClickable(driver, storeEditSubmitButton, 20);
	}

	public void enterValueToStoreNumber(String value) {
		actionUtil.clearText(driver, storePhone);
		actionUtil.enterValue(driver, storePhone, value);
	}

	public void enterValueToStoreCountryName(String value) {
		actionUtil.clearText(driver, storeCountry);
		actionUtil.enterValue(driver, storeCountry, value);
	}

	public void enterValueToStoreCityName(String value) {
		actionUtil.clearText(driver, storeCity);
		actionUtil.enterValue(driver, storeCity, value);
	}

	public void enterValueToStoreAddress(String value) {
		actionUtil.enterValue(driver, storeAddress, value);
	}

	public void enterValueToStoreCustomerFooter(String value) {
		actionUtil.enterValue(driver, storeCustomerFooter, value);
	}

	public void submit() {
		actionUtil.clickElement(driver, storeSubmitButton);
	}

	public void implementImplicitWait() {
		waitUtil.implicitWait(driver, 5);
	}

	/**
	 * This method is to check whether elements are displayed
	 * 
	 * @return
	 */
	public boolean isStoreNameDisplayed() {
		return actionUtil.isElementDisplayed(driver, storeName);
	}

	public boolean isStoreMailDisplayed() {
		return actionUtil.isElementDisplayed(driver, storeEmail);
	}

	public boolean isStorePhoneDisplayed() {
		return actionUtil.isElementDisplayed(driver, storePhone);
	}

	public boolean isStoreCountryDisplayed() {
		return actionUtil.isElementDisplayed(driver, storeCountry);
	}

	public boolean isStoreCityDisplayed() {
		return actionUtil.isElementDisplayed(driver, storeCity);
	}

	/**
	 * This method is to search for the added storevalues
	 * 
	 * @param value
	 */
	public void searchForStoreValue(String value) {
		waitUtil.waitForElementTobeClickable(driver, storeSearch, 10);
		actionUtil.clickElement(driver, storeSearch);
		actionUtil.enterValue(driver, storeSearch, value);
		waitUtil.waitForVisibilityOfElement(driver, storeName_searchResult, 20);
	}

	/**
	 * This method is to get text of search result
	 * 
	 * @return
	 */
	public String getStoreNameFromSearch() {
		return actionUtil.getElementText(driver, storeName_searchResult);
	}

	public String getStoreMailFromSearch() {
		return actionUtil.getElementText(driver, storeEmail_searchResult);
	}

	public String getStorePhoneFromSearch() {
		return actionUtil.getElementText(driver, storePhone_searchResult);
	}

	public String getStoreCountryFromSearch() {
		return actionUtil.getElementText(driver, storeCountry_searchResult);
	}

	public String getStoreCityFromSearch() {
		return actionUtil.getElementText(driver, storeCity_searchResult);
	}

	public void clearWeblementValue(WebElement element) {
		element.clear();
	}

	/**
	 * Method for editing the storevalues
	 * 
	 */

	public void clickOnEditIcon() {
		actionUtil.clickElement(driver, storeEditButton);
	}

	public void clickOnEditSubmitButton() {
		actionUtil.clickElement(driver, storeEditSubmitButton);
	}

	/**
	 * Method for deleting storevalues
	 * 
	 */
	public void clickOnDeleteIcon() {
		actionUtil.clickElement(driver, storeDeleteButton);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, storedelete_searchResult);
	}

	public void closeTheWindow() {
		brwsrUtil.browserQuitPage(driver);
	}
}
