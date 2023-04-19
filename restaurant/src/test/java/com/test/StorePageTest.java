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
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StorePage;
import com.utilities.PropertyUtilities;

public class StorePageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	StorePage storepg;
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
		storepg = homepg.navigateToStorePage();
	}

	@Test(priority = 7, enabled = true)
	public void validateAddStorePageHasElementsDisplayed() {
		storepg.clickOnAddStoreButton();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(storepg.isStoreNameDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(storepg.isStoreMailDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(storepg.isStorePhoneDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(storepg.isStoreCountryDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(storepg.isStoreCityDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();

	}

	@Test(priority = 8, enabled = true)
	public void validateTheEnteredStoreValues() throws Exception {
		storepg.clickOnAddStoreButton();
		storepg.enterValueToStoreName("AAA");
		storepg.enterValueToStoreMail("aaa@gmail.com");
		storepg.enterValueToStoreNumber("9498571245");
		storepg.enterValueToStoreCountryName("INDIA");
		storepg.enterValueToStoreCityName("ADOOR");
		storepg.enterValueToStoreAddress("Heaven ALAPPUZHA");
		storepg.enterValueToStoreCustomerFooter("done by AKHIL");
		storepg.submit();
		storepg.searchForStoreValue("AAA");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepg.getStoreNameFromSearch(), "AAA", AutomationConstants.errorMessage);
		soft.assertEquals(storepg.getStoreMailFromSearch(), "aaa@gmail.com", AutomationConstants.errorMessage);
		soft.assertEquals(storepg.getStorePhoneFromSearch(), "9498571245", AutomationConstants.errorMessage);
		soft.assertEquals(storepg.getStoreCountryFromSearch(), "INDIA", AutomationConstants.errorMessage);
		soft.assertEquals(storepg.getStoreCityFromSearch(), "ADOOR", AutomationConstants.errorMessage);
		soft.assertAll();

	}

	@Test(priority = 9, enabled = true)
	public void validateTheEditedStoreValues() throws Exception {
		storepg.searchForStoreValue("AAA");
		storepg.clickOnEditIcon();
		storepg.enterValueToStoreMail("abcd@gmail.com");
		storepg.clickOnEditSubmitButton();
		storepg.searchForStoreValue("AAA");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepg.getStoreNameFromSearch(), "AAA", AutomationConstants.errorMessage);
		soft.assertEquals(storepg.getStoreMailFromSearch(), "abcd@gmail.com", AutomationConstants.errorMessage);
		soft.assertEquals(storepg.getStorePhoneFromSearch(), "9498571245", AutomationConstants.errorMessage);
		soft.assertEquals(storepg.getStoreCountryFromSearch(), "INDIA", AutomationConstants.errorMessage);
		soft.assertEquals(storepg.getStoreCityFromSearch(), "ADOOR", AutomationConstants.errorMessage);
		soft.assertAll();

	}

	@Test(priority = 10, enabled = true)
	public void validateTheDeleteIcon() throws Exception {
		storepg.searchForStoreValue("AAA");
		storepg.clickOnDeleteIcon();
		storepg.searchForStoreValue("AAA");

		Assert.assertEquals(storepg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);

	}

}
