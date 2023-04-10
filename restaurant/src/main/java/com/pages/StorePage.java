package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;

public class StorePage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	public StorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@data-toggle='modal'and@data-target='#AddStore']")
	public WebElement addStoreButton;
	@FindBy(xpath = "//input[@id='StoreName']")
	public WebElement storeName;
	@FindBy(xpath = "//input[@id='email']")
	public WebElement storeEmail;
	@FindBy(xpath = "//input[@id='StorePhone']")
	public WebElement storePhone;
	@FindBy(xpath = "//input[@id='Country']")
	public WebElement storeCountry;
	@FindBy(xpath = "//input[@id='City']")
	public WebElement storeCity;
	@FindBy(xpath = "//input[@id='Adresse']")
	public WebElement storeAddress;
	@FindBy(xpath = "//input[@id='CustomeFooter']")
	public WebElement storeCustomerFooter;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement storeSubmitButton;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement storeSearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement storeName_searchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement storeEmail_searchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement storePhone_searchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement storeCountry_searchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	public WebElement storeCity_searchResult;

	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement storedelete_searchResult;
	@FindBy(xpath = "//a[@class='btn btn-default']")
	public WebElement storeDeleteButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement storeEditButton;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement storeEditSubmitButton;

	public void clickOnAddStoreButton() {
		actionUtil.clickElement(driver, addStoreButton);
	}

	public void clickOnStoreName() {
		actionUtil.clickElement(driver, storeName);
	}

	public void enterValueToStoreName(String value) {
		actionUtil.clearText(driver, storeName);
		actionUtil.enterValue(driver, storeName, value);
	}

	public void enterValueToStoreMail(String value) {
		actionUtil.clearText(driver, storeEmail);
		actionUtil.enterValue(driver, storeEmail, value);
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
	}

	/**
	 * This method is to get text of search result
	 * 
	 * @param value
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
	 */

	public void clickOnEditIcon() {
		actionUtil.clickElement(driver, storeEditButton);
	}

	public void clickOnEditSubmitButton() {
		actionUtil.clickElement(driver, storeEditSubmitButton);
	}

	/**
	 * Method for deleting storevalues
	 */
	public void clickOnDeleteIcon() {
		actionUtil.clickElement(driver, storeDeleteButton);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, storedelete_searchResult);
	}

}
