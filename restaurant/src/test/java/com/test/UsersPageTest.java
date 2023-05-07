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
import com.utilities.PropertyUtilities;

public class UsersPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	UsersPage userpg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;

	@BeforeMethod
	public void prerun() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		userpg = homepg.navigateToUsersPage();
	}

	@Test(priority = 35, enabled = true)
	public void validateAddUsersPageHasElementsDisplayed() {
		userpg.clickOnAddUsers();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(userpg.isUserNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(userpg.isFirstNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(userpg.isEmailDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(userpg.isPasswordDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(userpg.isConfirmPasswordDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 36, enabled = true)
	public void validateEnteredUserValues() {
		userpg.clickOnAddUsers();
		userpg.enterValueToUserName("ABC");
		userpg.enterValueToFirstName("ADMIN");
		userpg.clickOnRadioButton();
		userpg.enterValueToEmail("admin@gmail.com");
		userpg.enterValueToPassword("123456");
		userpg.enterValueToConfirmPassword("123456");
		userpg.clickOnSubmit();
		List<WebElement> username = driver.findElements(By.xpath("//table[@class='table']//tr//td"));
		boolean status = false;
		for (WebElement element : username) {
			String value = element.getText();
			if (value.contains("ABC")) {
				status = true;
				break;
			}
		}
		Assert.assertTrue(status, AutomationConstants.errorMessage);
	}

}
