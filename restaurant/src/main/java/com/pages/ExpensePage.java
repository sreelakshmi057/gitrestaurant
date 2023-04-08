package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.GenericUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;

public class ExpensePage {
	
	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	GenericUtilities genericUtil = new GenericUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	public ExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(text(),'Add Expence')]")
	public WebElement addExpenseButton;
	@FindBy(xpath = "//input[@id='Date']")
	public WebElement expenseDate;
	@FindBy(xpath = "//input[@id='Reference']")
	public WebElement expenseReference;
	@FindBy(xpath = "//select[@id='Category']")
	public WebElement expenseCategory;
	@FindBy(xpath = "//select[@id='store_id']")
	public WebElement expenseStore;
	@FindBy(xpath = "//input[@id='Amount']")
	public WebElement expenseAmount;
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	public WebElement expenseDescription;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement expenseSubmitButton;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement expenseSearch;
	@FindBy(xpath = "(//table[@id='table']//tr//td)[1]")
	public WebElement expenseDate_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement expenseReference_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement expenseAmount_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement expenseCategory_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	public WebElement expenseStore_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement expensedelete_SearchResult;

	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement expenseEditButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement expenseDeleteButton;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement expenseEditSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement expenseConfirmDeleteMsg;
	@FindBy(xpath = "//button[@class='confirm']")
	public WebElement expenseConfirmDeleteOkButton;
	
	
	
	public void clickOnAddExpenseButton() {
		actionUtil.clickElement(driver, addExpenseButton);
	}
	
	public void clickOnExpenseDate() {
		actionUtil.clickElement(driver,expenseDate );
	}
	
	/**
	 * This method is to check whether the elements are displayed
	 * @return
	 */
	public Boolean isExpenseDateDisplayed() {
		return actionUtil.isElementDisplayed(driver, expenseDate);
	}

	public Boolean isExpenseReferenceDisplayed() {
		return actionUtil.isElementDisplayed(driver, expenseReference);
	}

	public Boolean isExpenseCategoryDisplayed() {
		return actionUtil.isElementDisplayed(driver, expenseCategory);
	}

	public Boolean isExpenseStoreDisplayed() {
		return actionUtil.isElementDisplayed(driver, expenseStore);
	}

	public Boolean isExpenseAmountDisplayed() {
		return actionUtil.isElementDisplayed(driver, expenseAmount);
	}

	public Boolean isExpenseDescriptionDisplayed() {
		return actionUtil.isElementDisplayed(driver, expenseDescription);
	}
	
	/**
	 * This method is to search for added expense values
	 * 
	 * @param value
	 */
	public void enterValueToExpenseDate(String value) {
		actionUtil.clearText(driver, expenseDate);
		actionUtil.enterValue(driver, expenseDate, value);
	}

	public void enterValueToExpenseReference(String value) {
		actionUtil.clearText(driver, expenseReference);
		actionUtil.enterValue(driver, expenseReference, value);
	}

	public void enterValueToExpenseAmount(String value) {
		actionUtil.clearText(driver, expenseAmount);
		actionUtil.enterValue(driver, expenseAmount, value);
	}
	
	public void enterValueToExpenseDescription(String value) {
		actionUtil.clearText(driver, expenseDescription);
		actionUtil.enterValue(driver, expenseDescription, value);
	}
	
	public void clickOnExpenseSubmitButton() {
		actionUtil.clickElement(driver, expenseSubmitButton);
	}
	
	/**
	 * This method is to select the dropdown value
	 * 
	 * @param value
	 */
	public void selectExpenseStoreByVisibleText(String value) {
		actionUtil.clearText(driver, expenseStore);
		genericUtil.SelectByVisibleText(driver, expenseStore, value);
	}

	public void selectExpenseCategoryByVisibleText(String value) {
		actionUtil.clearText(driver, expenseCategory);
		genericUtil.SelectByVisibleText(driver, expenseCategory, value);
	}
	
	/**
	 * This method is to search for added expense values
	 * 
	 * @param value
	 */
	public void searchForExpenseValue(String value) {
		actionUtil.clearText(driver, expenseSearch);
		actionUtil.clickElement(driver, expenseSearch);
		actionUtil.enterValue(driver, expenseSearch, value);
		
	}
	
	/**
	 * This method is to get text of search result
	 */
	public String getExpenseDateFromSearchResult() {
		return actionUtil.getElementText(driver, expenseDate_SearchResult);
	}

	public String getExpenseReferenceFromSearchResult() {
		return actionUtil.getElementText(driver, expenseReference_SearchResult);
	}

	public String getExpenseAmountFromSearchResult() {
		return actionUtil.getElementText(driver, expenseAmount_SearchResult);
	}

	public String getExpenseStoreFromSearchResult() {
		return actionUtil.getElementText(driver, expenseStore_SearchResult);
	}
	
	public String getExpenseCategoryFromSearchResult() {
		return actionUtil.getElementText(driver, expenseCategory_SearchResult);
	}

	/**
	 * Method for editing the expense values
	 */

	public void clickOnExpenseEditIcon() {
		actionUtil.clickElement(driver, expenseEditButton);
	}

	public void clickOnExpenseEditSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, expenseEditSubmitButton, 10);
		actionUtil.clickElement(driver, expenseEditSubmitButton);
	}

	/**
	 * Method for deleting expense values
	 */
	public void clickOnExpenseDeleteIcon() {
		actionUtil.clickElement(driver, expenseDeleteButton);
	}

	public void clickOnExpenseDeleteConfirmMessage() {
		actionUtil.clickElement(driver, expenseConfirmDeleteMsg);
		actionUtil.clickElement(driver, expenseConfirmDeleteOkButton);
	}
	
	public void clickOnExpenseDeleteOkConfirmMessage() {
		actionUtil.clickElement(driver, expenseConfirmDeleteOkButton);
	}

	public String getTheSearchResultOfDeletedEntry() {
		return actionUtil.getElementText(driver, expensedelete_SearchResult);
	}
	
	
	
	
	

}
