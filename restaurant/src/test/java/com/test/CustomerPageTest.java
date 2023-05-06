package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.datasupplier.DataSupplier;
import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;

public class CustomerPageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	CustomerPage customerpg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;

	@BeforeMethod
	public void prerun() throws IOException {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		customerpg = homepg.navigateToCustomersInPeopleLink();
	}

	@Test(priority = 15, enabled = true)
	public void validateAddCustomerPageHasElementsDisplayed() {
		customerpg.clickOnAddCustomerButton();
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(customerpg.isCustomerNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(customerpg.isCustomerPhoneDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(customerpg.isCustomerEmailDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(customerpg.isCustomerDiscountDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();
	}

	@Test(priority = 16, enabled = true, dataProvider = "dataSupplierCustomer", dataProviderClass = DataSupplier.class)
	public void validateTheEnteredValuesInCustomersPage(String name, String phone, String mail, String discount) {
		customerpg.clickOnAddCustomerButton();
		customerpg.enterValueToCustomerName(name);
		customerpg.enterValueToCustomerPhone(phone);
		customerpg.enterValueToCustomerEmail(mail);
		customerpg.enterValueToCustomerDiscount(discount);
		customerpg.clickOnCustomerSubmitButton();
		customerpg.searchForCustomerValue(name);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customerpg.getCustomerNameFromSearchResult(), "AAC", AutomationConstants.errorMessage);
		soft.assertEquals(customerpg.getCustomerPhoneFromSearchResult(), "1234567567",
				AutomationConstants.errorMessage);
		soft.assertEquals(customerpg.getCustomerEmailFromSearchResult(), "aac@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertAll();

	}

	@Test(priority = 17, enabled = true, dataProvider = "dataSupplierCustomerEdit", dataProviderClass = DataSupplier.class)
	public void validateTheEditedCustomerValues(String name, String phone, String mail, String discount) {
		customerpg.searchForCustomerValue(name);
		customerpg.clickOnCustomerEditIcon();
		customerpg.enterValueToCustomerPhone(phone);
		customerpg.enterValueToCustomerEmail(mail);
		customerpg.enterValueToCustomerDiscount(discount);
		customerpg.clickOnCustomerEditSubmitButton();
		customerpg.searchForCustomerValue(phone);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(customerpg.getCustomerNameFromSearchResult(), "AAC", AutomationConstants.errorMessage);
		soft.assertEquals(customerpg.getCustomerPhoneFromSearchResult(), "7888888888",
				AutomationConstants.errorMessage);
		soft.assertEquals(customerpg.getCustomerEmailFromSearchResult(), "aac@gmail.com",
				AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 18, enabled = true, dataProvider = "dataSupplierCustomerDelete", dataProviderClass = DataSupplier.class)
	public void validateTheDeleteIcon(String phone) {
		customerpg.searchForCustomerValue(phone);
		customerpg.clickOnCustomerDeleteIcon();
		customerpg.clickOnCustomerDeleteConfirmMessage();
		customerpg.searchForCustomerValue(phone);
		Assert.assertEquals(customerpg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);

	}

}
