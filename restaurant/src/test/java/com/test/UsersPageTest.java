package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UsersPage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class UsersPageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	UsersPage userpg;
	Properties prop;
	HomePage homepg;

	WebbrowserUtilities brwsrUtil = new WebbrowserUtilities();
	PropertyUtilities propUtil = new PropertyUtilities();
	WaitUtilities waitUtil = new WaitUtilities();

	@BeforeMethod
	public void prerun() {
		driver = getDriver();
		try {
			prop = PropertyUtilities.getProperty("config.properties");
		} catch (IOException e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		loginpg = new LoginPage(driver);
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		userpg = homepg.navigateToUsersPage();
	}

	@Test(priority = 36, enabled = true)
	public void validateAddUsersPageHasElementsDisplayed() {
		userpg.clickOnAddUsers();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(userpg.isUserNameDisplayed(), "Failure Message: UserName not displayed");
		soft.assertTrue(userpg.isFirstNameDisplayed(), "Failure Message: FirstName not displayed");
		soft.assertTrue(userpg.isEmailDisplayed(), "Failure Message: Email not displayed");
		soft.assertTrue(userpg.isPasswordDisplayed(), "Failure Message: Password not displayed");
		soft.assertTrue(userpg.isConfirmPasswordDisplayed(), "Failure Message: ConfirmPassword not displayed");
		soft.assertAll();

	}

	@Test(priority = 37, enabled = true)
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
		Assert.assertTrue(status, "Record not found");

	}

}
