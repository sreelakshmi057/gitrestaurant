package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;

public class SettingsPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	GenericUtilities genericUtil = new GenericUtilities();

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='companyName']")
	private WebElement CompanyName;
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

	public void enterValueToCompanyName(String value) {
		actionUtil.clearText(driver, CompanyName);
		actionUtil.enterValue(driver, CompanyName, value);
	}

	public void enterValueToCompanyPhone(String value) {
		actionUtil.clearText(driver, companyPhone);
		actionUtil.enterValue(driver, companyPhone, value);
	}

	public void enterValueToDefaultDiscount(String value) {
		actionUtil.clearText(driver, defaultDiscount);
		actionUtil.enterValue(driver, defaultDiscount, value);
	}

	public void enterValueToReceiptHeader(String value) {
		actionUtil.clearText(driver, descriptionHeader);
		actionUtil.enterValue(driver, descriptionHeader, value);
	}

	public void enterValueToReceiptFooter(String value) {
		actionUtil.clearText(driver, descriptionFooter);
		actionUtil.enterValue(driver, descriptionFooter, value);
	}

	public void enterValueToStripeKey(String value) {
		actionUtil.clearText(driver, stripeKey);
		actionUtil.enterValue(driver, stripeKey, value);
	}

	public void enterValueToStripePublishedKey(String value) {
		actionUtil.clearText(driver, stripePublishableKey);
		actionUtil.enterValue(driver, stripePublishableKey, value);
	}

	public void clickOnSubmitButton() {
		actionUtil.clickElement(driver, submitButton);
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

}
