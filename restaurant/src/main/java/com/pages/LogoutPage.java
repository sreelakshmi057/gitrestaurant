package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;

public class LogoutPage {

	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Logout']")
	public WebElement logOut;
	@FindBy(xpath = "//input[@class='login loginmodal-submit']")
	public WebElement loginButton;

	public void clickOnLogout() {
		actionUtil.clickElement(driver, logOut);
	}

	public Boolean isLoginButtonDisplayed() {
		return actionUtil.isElementDisplayed(driver, loginButton);
	}
}
