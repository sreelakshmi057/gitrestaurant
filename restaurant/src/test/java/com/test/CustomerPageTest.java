package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class CustomerPageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	CustomerPage customerpg;
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
		customerpg = homepg.navigateToCustomersInPeopleLink();
	}

	@Test(priority = 15, enabled = true)
	public void validateAddCustomerPageHasElementsDisplayed() {
		customerpg.clickOnAddCustomerButton();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(customerpg.isCustomerNameDisplayed(), "Failure Message: CustomerName not displayed");
		soft.assertTrue(customerpg.isCustomerPhoneDisplayed(), "Failure Message: CustomerPhone not displayed");
		soft.assertTrue(customerpg.isCustomerEmailDisplayed(), "Failure Message: CustomerEmail not displayed");
		soft.assertTrue(customerpg.isCustomerDiscountDisplayed(), "Failure Message: CustomerDiscount not displayed");
		soft.assertAll();
	}

	@Test(priority = 16, enabled = true)
	public void validateTheEnteredValuesInCustomersPage() {
		customerpg.clickOnAddCustomerButton();
		customerpg.enterValueToCustomerName("AAC");
		customerpg.enterValueToCustomerPhone("1234567567");
		customerpg.enterValueToCustomerEmail("aac@gmail.com");
		customerpg.enterValueToCustomerDiscount("10");
		customerpg.clickOnCustomerSubmitButton();
		customerpg.searchForCustomerValue("AAC");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customerpg.getCustomerNameFromSearchResult(), "AAC",
				"Failure Message: CustomerName not displayed");
		soft.assertEquals(customerpg.getCustomerPhoneFromSearchResult(), "1234567567",
				"Failure Message:CustomerPhone not displayed");
		soft.assertEquals(customerpg.getCustomerEmailFromSearchResult(), "aac@gmail.com",
				"Failure Message: CustomerEmail not displayed");
		soft.assertAll();

	}

	@Test(priority = 17, enabled = true)
	public void validateTheEditedCustomerValues() {
		customerpg.searchForCustomerValue("AAC");
		customerpg.clickOnCustomerEditIcon();
		customerpg.enterValueToCustomerEmail("abby@gmail.com");
		customerpg.enterValueToCustomerPhone("7894568888");
		customerpg.clickOnCustomerEditSubmitButton();
		customerpg.searchForCustomerValue("abby@gmail.com");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customerpg.getCustomerNameFromSearchResult(), "AAC",
				"Failure Message: No matching records found");
		soft.assertEquals(customerpg.getCustomerPhoneFromSearchResult(), "7894568888",
				"Failure Message: No matching records found");
		soft.assertEquals(customerpg.getCustomerEmailFromSearchResult(), "abby@gmail.com",
				"Failure Message: No matching records found");
		soft.assertAll();
	}

	@Test(priority = 18, enabled = true)
	public void validateTheDeleteIcon() {
		customerpg.searchForCustomerValue("AAC");
		customerpg.clickOnCustomerDeleteIcon();
		customerpg.clickOnCustomerDeleteConfirmMessage();
		customerpg.searchForCustomerValue("AAC");

		Assert.assertEquals(customerpg.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"Failure message:: failed to delete the store");

	}

}
