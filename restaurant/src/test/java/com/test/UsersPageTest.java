package com.test;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UsersPage;
import com.utilities.ExcelUtilities;
import com.utilities.PropertyUtilities;

public class UsersPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	UsersPage userpg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;
	ExcelUtilities excelUtil;

	@BeforeMethod
	public void prerun() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		userpg = homepg.navigateToUsersPage();
		excelUtil = new ExcelUtilities();
	}

	@Test(priority = 36, enabled = true)
	public void validateAddUsersPageInSettingsPageHasElementsDisplayed() {
		userpg.clickOnAddUsers();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(userpg.isUserNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(userpg.isFirstNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(userpg.isEmailDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(userpg.isPasswordDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(userpg.isConfirmPasswordDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 37, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEnteredUserValuesInUsersPage_InTheCorrespondingFields() {
		userpg.clickOnAddUsers();
		String user_name = excelUtil.readStringData("users", 2, 2);
		userpg.enterValueToUserName(user_name);
		String user_FirstName = excelUtil.readStringData("users", 3, 2);
		userpg.enterValueToFirstName(user_FirstName);
		userpg.clickOnRadioButton();
		String user_email = excelUtil.readStringData("users", 4, 2);
		userpg.enterValueToEmail(user_email);
		String user_password = excelUtil.readStringData("users", 5, 2);
		userpg.enterValueToPassword(user_password);
		userpg.enterValueToConfirmPassword(user_password);
		userpg.clickOnSubmit();
		Assert.assertTrue(userpg.getSearchResultOfTheAddedUserValues(), AutomationConstants.errorMessage);
	}

}
