package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;

public class ExpenseInCategoriesPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	GenericUtilities genericUtil = new GenericUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	public ExpenseInCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	private WebElement addExpenseCategoryButton;
	@FindBy(id = "CategoryName")
	private WebElement expenseCategoryName;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement expenseSubmitButton;

	@FindBy(xpath = "//input[@type='search']")
	private WebElement expenseSearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement categoryName_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement delete_SearchResult;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	private WebElement expenseEditButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	private WebElement expenseDeleteButton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement expenseEditSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	private WebElement expenseConfirmDeleteMsg;

	public void clickOnAddExpenseCategoryButton() {
		actionUtil.clickElement(driver, addExpenseCategoryButton);
		waitUtil.waitForElementTobeClickable(driver, expenseCategoryName, 15);
		actionUtil.clickElement(driver, expenseCategoryName);
	}

	/**
	 * This method is to check whether elements are displayed
	 * 
	 * @return
	 */
	public boolean isCategoryNameDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, expenseCategoryName);
		return flag;
	}

	/**
	 * This methods are to fill up the add category field
	 * 
	 * @param value
	 */

	public void enterValueToCategoryName(String value) {
		actionUtil.clearText(driver, expenseCategoryName);
		actionUtil.enterValue(driver, expenseCategoryName, value);
	}

	public void clickOnCategorySubmitButton() {
		actionUtil.clickElement(driver, expenseSubmitButton);
		actionUtil.clickElement(driver, expenseSubmitButton);
	}

	/**
	 * This method is to search for the added categoryvalues
	 * 
	 * @param value
	 */

	public void searchForCategoryProductValue(String value) {
		waitUtil.waitForElementTobeClickable(driver, expenseSearch, 5);
		actionUtil.clearText(driver, expenseSearch);
		actionUtil.clickElement(driver, expenseSearch);
		actionUtil.enterValue(driver, expenseSearch, value);
		waitUtil.waitForVisibilityOfElement(driver, categoryName_SearchResult, 20);
	}

	/**
	 * This method is to get text of search result
	 * 
	 */
	public String getExpenseCategoryNameFromSearchResult() {
		return actionUtil.getElementText(driver, categoryName_SearchResult);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, delete_SearchResult);
	}

	/**
	 * Method for editing the categoryproductvalues
	 * 
	 */

	public void clickOnProductEditIcon() {
		actionUtil.clickElement(driver, expenseEditButton);
	}

	public void clickOnProductEditSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, expenseEditSubmitButton, 10);
		actionUtil.clickElement(driver, expenseEditSubmitButton);
	}

	/**
	 * Method for deleting categoryproductvalues
	 * 
	 */
	public void clickOnProductDeleteIcon() {
		actionUtil.clickElement(driver, expenseDeleteButton);
	}

	public void clickOnProductDeleteConfirmMessage() {
		actionUtil.clickElement(driver, expenseConfirmDeleteMsg);
	}

}
