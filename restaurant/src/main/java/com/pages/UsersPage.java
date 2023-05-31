package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;

public class UsersPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	WebbrowserUtilities brwsrUtil= new WebbrowserUtilities();

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@data-toggle='tab'])[2]")
	private WebElement usersButton;
	@FindBy(xpath = "//button[contains(text(),'Add User')]")
	private WebElement addUser;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@value='admin']")
	private WebElement radioButtonAdmin;
	@FindBy(xpath = "(//input[@id='email'])[1]")
	private WebElement email;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//input[@id='confirm_password']")
	private WebElement repeatPassword;
	@FindBy(xpath = "(//button[@class='btn btn-add'])[1]")
	private WebElement submit;
	@FindBy(xpath = "((//table[@class='table']//tr//td)[2]")
	private WebElement firstName_searchResult;
	@FindBy(xpath = "(//table[@class='table']//tr//td)[4]")
	private WebElement userName_searchResult;
	@FindBy(xpath = "(//table[@class='table']//tr//td)[5]")
	private WebElement role_searchResult;

	public void clickOnAddUsers() {
		actionUtil.clickElement(driver, usersButton);
		waitUtil.waitForElementTobeClickable(driver, addUser, 20);
		actionUtil.clickElement(driver, addUser);
		waitUtil.waitForElementTobeClickable(driver, userName, 20);
	}

	public void enterValueToUserName(String value) {
		actionUtil.clearText(driver, userName);
		actionUtil.enterValue(driver, userName, value);
	}

	public void enterValueToFirstName(String value) {
		actionUtil.clearText(driver, firstName);
		actionUtil.enterValue(driver, firstName, value);
	}

	public void clickOnRadioButton() {
		actionUtil.clickElement(driver, radioButtonAdmin);
	}

	public void enterValueToEmail(String value) {
		actionUtil.clearText(driver, email);
		actionUtil.enterValue(driver, email, value);
	}

	public void enterValueToPassword(String value) {
		actionUtil.clearText(driver, password);
		actionUtil.enterValue(driver, password, value);
	}

	public void enterValueToConfirmPassword(String value) {
		actionUtil.clearText(driver, repeatPassword);
		actionUtil.enterValue(driver, repeatPassword, value);
	}

	public void clickOnSubmit() {
		actionUtil.clickElement(driver, submit);
		waitUtil.waitForVisibilityOfElement(driver, userName, 10);
	}

	public void implementImplicitWait() {
		waitUtil.implicitWait(driver, 5);
	}

	/**
	 * This method is to check whether elements are displayed
	 * 
	 * @return
	 */

	public boolean isUserNameDisplayed() {
		return actionUtil.isElementDisplayed(driver, userName);
	}

	public boolean isFirstNameDisplayed() {
		return actionUtil.isElementDisplayed(driver, firstName);
	}

	public boolean isEmailDisplayed() {
		return actionUtil.isElementDisplayed(driver, email);
	}

	public boolean isPasswordDisplayed() {
		return actionUtil.isElementDisplayed(driver, password);
	}

	public boolean isConfirmPasswordDisplayed() {
		return actionUtil.isElementDisplayed(driver, repeatPassword);
	}

	/**
	 * This method is to get text of search result
	 * 
	 */
	public String getUserNameFromSearchResult() {
		return actionUtil.getElementText(driver, userName_searchResult);
	}

	public String getFirstNameFromSearchResult() {
		return actionUtil.getElementText(driver, firstName_searchResult);
	}

	public String getRoleFromSearchResult() {
		return actionUtil.getElementText(driver, role_searchResult);
	}
	
	public boolean getSearchResultOfTheAddedUsersValues() {
		List<WebElement> username = driver.findElements(By.xpath("//table[@class='table']//tr//td"));
		boolean status = false;
		for (WebElement element : username) {
			String value = element.getText();
			if (value.contains("ABC")) {
				status = true;
				break;
			}
	}
		return status;
	}
	
	public void closeTheWindow() {
		brwsrUtil.browserQuitPage(driver);
	}

}
