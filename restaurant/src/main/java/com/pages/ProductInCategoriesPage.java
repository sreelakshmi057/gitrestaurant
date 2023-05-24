package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;

public class ProductInCategoriesPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	GenericUtilities genericUtil = new GenericUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	WebbrowserUtilities brwsrUtil= new WebbrowserUtilities();

	public ProductInCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Add Category')]")
	private WebElement addCategoryButton;
	@FindBy(id = "CategoryName")
	private WebElement categoryName;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private WebElement categorySubmitButton;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement categorySearch;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement categoryName_SearchResult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	private WebElement delete_SearchResult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	private WebElement categoryEditButton;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	private WebElement categoryDeleteButton;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement categoryEditSubmitButton;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	private WebElement categoryConfirmDeleteMsg;

	public void clickOnAddCategoryButton() {
		actionUtil.clickElement(driver, addCategoryButton);
		waitUtil.waitForElementTobeClickable(driver, categoryName, 15);
		actionUtil.clickElement(driver, categoryName);
	}

	/**
	 * This method is to check whether elements are displayed
	 * 
	 * @return
	 */
	public boolean isCategoryNameDisplayed() {
		boolean flag = actionUtil.isElementDisplayed(driver, categoryName);
		return flag;
	}

	/**
	 * This methods are to fill up the add category field
	 * 
	 * @param value
	 */

	public void enterValueToCategoryName(String value) {
		actionUtil.clearText(driver, categoryName);
		actionUtil.enterValue(driver, categoryName, value);
		waitUtil.waitForElementTobeClickable(driver, categorySubmitButton, 20);
	}

	public void clickOnCategorySubmitButton() {
		actionUtil.clickElement(driver, categorySubmitButton);
		// waitUtil.waitForElementTobeClickable(driver, categorySubmitButton, 5);
		actionUtil.clickElement(driver, categorySubmitButton);
	}

	/**
	 * This method is to search for the added categoryvalues
	 * 
	 * @param value
	 */

	public void searchForCategoryProductValue(String value) {
		waitUtil.waitForElementTobeClickable(driver, categorySearch, 5);
		actionUtil.clearText(driver, categorySearch);
		actionUtil.clickElement(driver, categorySearch);
		actionUtil.enterValue(driver, categorySearch, value);
	}

	/**
	 * This method is to get text of search result
	 * 
	 */
	public String getCategoryProductNameFromSearchResult() {
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
		actionUtil.clickElement(driver, categoryEditButton);
	}

	public void clickOnProductEditSubmitButton() {
		waitUtil.waitForElementTobeClickable(driver, categoryEditSubmitButton, 10);
		actionUtil.clickElement(driver, categoryEditSubmitButton);
	}

	/**
	 * Method for deleting categoryproductvalues
	 * 
	 */
	public void clickOnProductDeleteIcon() {
		actionUtil.clickElement(driver, categoryDeleteButton);
	}

	public void clickOnProductDeleteConfirmMessage() {
		actionUtil.clickElement(driver, categoryConfirmDeleteMsg);
	}
	
	public void closeTheWindow() {
		brwsrUtil.browserQuitPage(driver);
	}

}
