package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;

public class HomePage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WebbrowserUtilities brwsrUtil= new WebbrowserUtilities();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'POS')]")
	public WebElement posLink;
	@FindBy(xpath = "(//span[text()='Product'])[1]")
	public WebElement productLink;
	@FindBy(xpath = "//span[text()='Stores'and @class='menu-text']")
	public WebElement storeLink;
	@FindBy(xpath = "//span[text()='People'and@class='menu-text']")
	public WebElement peopleLink;
	@FindBy(xpath = "//span[text()='Sales'and@class='menu-text']")
	public WebElement salesLink;
	@FindBy(xpath = "(//span[text()='Expense'])[1]")
	public WebElement expenseLink;
	@FindBy(xpath = "//span[text()='Categories ']")
	public WebElement categoriesLink;
	@FindBy(xpath = "//span[text()='Setting']")
	public WebElement settingsLink;
	@FindBy(xpath = "//span[text()='Reports']")
	public WebElement reportLink;
	@FindBy(xpath = "//li[@class='dropdown language']")
	public WebElement languageLink;
	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	public WebElement logout;
	@FindBy(xpath = "//span[text()='Waiters']")
	public WebElement waiterPeople;
	@FindBy(xpath = "//span[text()='Customers']")
	public WebElement customersPeople;
	@FindBy(xpath = "//span[text()='Suppliers']")
	public WebElement suppliersPeople;

	public boolean isPosLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, posLink);
		return flag;
	}

	public boolean isProductLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, productLink);
		return flag;
	}

	public boolean isStoreLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, storeLink);
		return flag;
	}

	public boolean isPeopleLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, peopleLink);
		return flag;
	}

	public boolean isSalesLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, salesLink);
		return flag;
	}

	public boolean isExpenseLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, expenseLink);
		return flag;
	}

	public boolean isCategoriesLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, categoriesLink);
		return flag;
	}

	public boolean isSettingsLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, settingsLink);
		return flag;
	}

	public boolean isReportLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, reportLink);
		return flag;
	}

	public boolean isLanguageLinkDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, languageLink);
		return flag;
	}

	public boolean isLogoutDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, logout);
		return flag;
	}
	
	public ProductPage navigateToProductPage() {
		actionUtil.clickElement(driver, productLink);
		return new ProductPage(driver);
	}
	
	public StorePage navigateToStorePage() {
		actionUtil.clickElement(driver, storeLink);
		return new StorePage(driver);
	}
	
	public WaiterPage navigateToWaiterInPeopleLink() {
		actionUtil.clickElement(driver, peopleLink);
		actionUtil.clickElement(driver, waiterPeople);
		return new WaiterPage(driver);
	}
	
	public CustomerPage navigateToCustomersInPeopleLink() {
		actionUtil.clickElement(driver, peopleLink);
		actionUtil.clickElement(driver, customersPeople);
		return new CustomerPage(driver);
	}
	
	public SuppliersPage navigateToSuppliersInPeopleLink() {
		actionUtil.clickElement(driver, peopleLink);
		actionUtil.clickElement(driver, suppliersPeople);
		return new SuppliersPage(driver);
	}
}
