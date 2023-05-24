package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;

public class LogoutPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();
	WebbrowserUtilities brwsrUtil= new WebbrowserUtilities();

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Logout']")
	private WebElement logOut;
	@FindBy(xpath = "//input[@class='login loginmodal-submit']")
	private WebElement loginButton;

	public void clickOnLogout() {
		actionUtil.clickElement(driver, logOut);
		waitUtil.waitForElementTobeClickable(driver, loginButton, 15);
	}

	public Boolean isLoginButtonDisplayed() {
		return actionUtil.isElementDisplayed(driver, loginButton);
	}
}
