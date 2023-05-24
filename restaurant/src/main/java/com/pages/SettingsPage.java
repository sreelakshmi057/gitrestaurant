package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;

public class SettingsPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	GenericUtilities genericUtil = new GenericUtilities();
	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='companyName']")
	private WebElement CompanyName;
	@FindBy(xpath = "//input[@value='TfNmCvUM']")
	private WebElement Company_getName;
	@FindBy(id = "phone")
	private WebElement companyPhone;
	@FindBy(id = "currency")
	private WebElement currencyCode;
	@FindBy(id = "DefaultDiscount")
	private WebElement defaultDiscount;
	@FindBy(id = "DefualtTax")
	private WebElement defaultTax;
	@FindBy(id = "numberDecimal")
	private WebElement rounding;
	@FindBy(xpath = "(//div[@class='note-editable panel-body'])[1]")
	private WebElement descriptionHeader;
	@FindBy(xpath = "(//div[@class='note-editable panel-body'])[2]")
	private WebElement descriptionFooter;
	@FindBy(id = "stripe_secret_key")
	private WebElement stripeKey;
	@FindBy(id = "stripe_publishable_key")
	private WebElement stripePublishableKey;
	@FindBy(xpath = "(//button[@class='btn btn-add btn-lg'])[1]")
	private WebElement submitButton;

	public void clickOnCompanyName() {
		waitUtil.waitForElementTobeClickable(driver, CompanyName, 15);
		actionUtil.clickElement(driver, CompanyName);
	}

	public void enterValueToCompanyName(String company_Name) {
		actionUtil.clearText(driver, CompanyName);
		actionUtil.enterValue(driver, CompanyName, company_Name);
	}

	public void enterValueToCompanyPhone(String company_Phone) {
		actionUtil.clearText(driver, companyPhone);
		actionUtil.enterValue(driver, companyPhone, company_Phone);
	}

	public void enterValueToDefaultDiscount(String discount) {
		actionUtil.clearText(driver, defaultDiscount);
		actionUtil.enterValue(driver, defaultDiscount, discount);
	}

	public void enterValueToDefaultTax(String tax) {
		actionUtil.clearText(driver, defaultTax);
		actionUtil.enterValue(driver, defaultTax, tax);
	}

	public void enterValueToCurrencyCode(String code) {
		actionUtil.clearText(driver, currencyCode);
		actionUtil.enterValue(driver, currencyCode, code);
	}

	public String enterValueToReceiptHeader() {
		actionUtil.clearText(driver, descriptionHeader);
		String header = genericUtil.generateAlphabeticData(7);
		actionUtil.enterValue(driver, descriptionHeader, header);
		return header;
	}

	public String enterValueToReceiptFooter() {
		actionUtil.clearText(driver, descriptionFooter);
		String footer = genericUtil.generateAlphabeticData(8);
		actionUtil.enterValue(driver, descriptionFooter, footer);
	    return footer;
	}

	public String enterValueToStripeKey() {
		actionUtil.clearText(driver, stripeKey);
		String key = genericUtil.generateAlphaNumericData(5);
		actionUtil.enterValue(driver, stripeKey, key);
		return key;
	}

	public String enterValueToStripePublishedKey() {
		actionUtil.clearText(driver, stripePublishableKey);
		String publishedKey = genericUtil.generateAlphaNumericData(5);
		actionUtil.enterValue(driver, stripePublishableKey, publishedKey);
		return publishedKey;
	}

	public void clickOnSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, submitButton, 15);
		actionUtil.clickElement(driver, submitButton);
	}

	/**
	 * This method is to get text of search result
	 * 
	 * @return
	 */
	public String getCompanyName() {
		brwsrUtil.navigateToRefreshPage(driver);
		waitUtil.waitForVisibilityOfElement(driver, Company_getName, 10);
		return actionUtil.getElementText(driver,Company_getName );
	}

	public String getCompanyPhone() {
		return actionUtil.getElementText(driver, companyPhone);
	}

	public String getCurrencyCode() {
		return actionUtil.getElementText(driver, currencyCode);
	}

	public String getDefaultDiscount() {
		return actionUtil.getElementText(driver, defaultDiscount);
	}

	public String getDefaultTax() {
		return actionUtil.getElementText(driver, defaultTax);
	}

	/**
	 * This method is to check whether elements are displayed
	 * 
	 * @return
	 */
	public boolean isCompanyNameDisplayed() {
		return actionUtil.isElementDisplayed(driver, CompanyName);
	}

	public boolean isCompanyPhoneDisplayed() {
		return actionUtil.isElementDisplayed(driver, companyPhone);
	}

	public boolean isDefaultDiscountDisplayed() {
		return actionUtil.isElementDisplayed(driver, defaultDiscount);
	}

	public boolean isReceiptHeaderDisplayed() {
		return actionUtil.isElementDisplayed(driver, descriptionHeader);
	}

	public boolean isReceiptFooterDisplayed() {
		return actionUtil.isElementDisplayed(driver, descriptionFooter);
	}

	public boolean isStripeSecretKeyDisplayed() {
		return actionUtil.isElementDisplayed(driver, descriptionFooter);
	}

	public boolean isStripeSecretPublishedKeyDisplayed() {
		return actionUtil.isElementDisplayed(driver, descriptionFooter);
	}

	/**
	 * This method is to select the dropdown value
	 * 
	 * @param value
	 */
	public void selectNumberOfDecimalsByIndex(int value) {
		actionUtil.clearText(driver, rounding);
		genericUtil.SelectElementByIndex(driver, rounding, value);
	}

	public void closeTheWindow() {
		brwsrUtil.browserQuitPage(driver);
	}
}
