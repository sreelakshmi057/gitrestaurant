package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebActionUtilities;

public class LoginPage {
	WebDriver driver;
	WebActionUtilities actionUtil = new WebActionUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username' and @placeholder='Username']")
	public WebElement username;
	@FindBy(xpath = "//input[@placeholder='Password' and @name='password']")
	public WebElement password;
	@FindBy(xpath = "//input[@value='Login'and@name='submit']")
	public WebElement loginButton;

	public void enterValueToUsername(String value) {
		actionUtil.enterValue(driver, username, value);
	}

	public void enterValueToPassword(String value) {
		actionUtil.enterValue(driver, password, value);
	}

	public void clickLoginButton() {
		actionUtil.clickElement(driver, loginButton);
	}

	public HomePage login(String username, String password) {
		enterValueToUsername(username);
		enterValueToPassword(password);
		clickLoginButton();
		return new HomePage(driver);
	}
}
