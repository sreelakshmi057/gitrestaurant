package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;

public class HomePage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	WebbrowserUtilities brwsrUtil= new WebbrowserUtilities();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'POS')]")
	private WebElement posLink;
	@FindBy(xpath = "(//span[text()='Product'])[1]")
	private WebElement productLink;
	@FindBy(xpath = "//span[text()='Stores'and @class='menu-text']")
	private WebElement storeLink;
	@FindBy(xpath = "//span[text()='People'and@class='menu-text']")
	private WebElement peopleLink;
	@FindBy(xpath = "//span[text()='Sales'and@class='menu-text']")
	private WebElement salesLink;
	@FindBy(xpath = "(//span[text()='Expense'])[1]")
	private WebElement expenseLink;
	@FindBy(xpath = "//span[text()='Categories ']")
	private WebElement categoriesLink;
	@FindBy(xpath = "(//span[text()='Product'])[2]")
	private WebElement productCategoriesLink;
	@FindBy(xpath = "(//span[text()='Expense'])[2]")
	private WebElement expenseCategoriesLink;
	@FindBy(xpath = "//span[text()='Setting']")
	private WebElement settingsLink;
	@FindBy(xpath = "//span[text()='Reports']")
	private WebElement reportLink;
	@FindBy(xpath = "//li[@class='dropdown language']")
	private WebElement languageLink;
	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	private WebElement logout;
	@FindBy(xpath = "//span[text()='Waiters']")
	private WebElement waiterPeopleLink;
	@FindBy(xpath = "//span[text()='Customers']")
	private WebElement customersPeopleLink;
	@FindBy(xpath = "//span[text()='Suppliers']")
	private WebElement suppliersPeopleLink;
	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement logOut;
	@FindBy(xpath = "(//a[@data-toggle='tab'])[2]")
	private WebElement usersButton;

	/**
	 * This method is to check whether elements are displayed
	 * 
	 * @return
	 */
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

	public void implementImplicitWait() {
		waitUtil.implicitWait(driver, 5);
	}

	/**
	 * This methods are used to navigate to corresponding pages
	 * 
	 * @return
	 */

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
		actionUtil.clickElement(driver, waiterPeopleLink);
		return new WaiterPage(driver);
	}

	public CustomerPage navigateToCustomersInPeopleLink() {
		actionUtil.clickElement(driver, peopleLink);
		actionUtil.clickElement(driver, customersPeopleLink);
		return new CustomerPage(driver);
	}

	public SupplierPage navigateToSuppliersInPeopleLink() {
		actionUtil.clickElement(driver, peopleLink);
		actionUtil.clickElement(driver, suppliersPeopleLink);
		return new SupplierPage(driver);
	}

	public ExpensePage navigateToExpensePage() {
		actionUtil.clickElement(driver, expenseLink);
		return new ExpensePage(driver);
	}

	public ProductInCategoriesPage navigateToProductInCategoriesPage() {
		actionUtil.clickElement(driver, categoriesLink);
		actionUtil.clickElement(driver, productCategoriesLink);
		return new ProductInCategoriesPage(driver);
	}

	public ExpenseInCategoriesPage navigateToExpenseInCategoriesPage() {
		actionUtil.clickElement(driver, categoriesLink);
		actionUtil.clickElement(driver, expenseCategoriesLink);
		return new ExpenseInCategoriesPage(driver);
	}

	public SettingsPage navigateToSettingsPage() {
		actionUtil.clickElement(driver, settingsLink);
		return new SettingsPage(driver);
	}

	public LogoutPage navigateToLogoutPage() {
		actionUtil.clickElement(driver, logOut);
		return new LogoutPage(driver);
	}

	public UsersPage navigateToUsersPage() {
		actionUtil.clickElement(driver, settingsLink);
		actionUtil.clickElement(driver, usersButton);
		return new UsersPage(driver);
	}
	
	public void closeTheWindow() {
		brwsrUtil.browserQuitPage(driver);
	}
}
