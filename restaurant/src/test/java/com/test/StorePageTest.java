package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StorePage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class StorePageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	StorePage storepg;
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
		storepg = homepg.navigateToStorePage();
	}

	@Test(priority = 7, enabled = true)
	public void validateAddStorePageHasElementsDisplayed() {
		storepg.clickOnAddStoreButton();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(storepg.isStoreNameDisplayed(), "Failure Message: Storename not displayed");
		soft.assertTrue(storepg.isStoreMailDisplayed(), "Failure Message: Storemail not displayed");
		soft.assertTrue(storepg.isStorePhoneDisplayed(), "Failure Message: Storephone not displayed");
		soft.assertTrue(storepg.isStoreCountryDisplayed(), "Failure Message: Storecountry not displayed");
		soft.assertTrue(storepg.isStoreCityDisplayed(), "Failure Message: Storecity not displayed");
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
		soft.assertEquals(storepg.getStoreNameFromSearch(), "AAA", "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreMailFromSearch(), "aaa@gmail.com",
				"Failure Message: No matching records found");
		soft.assertEquals(storepg.getStorePhoneFromSearch(), "9498571245",
				"Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreCountryFromSearch(), "INDIA", "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreCityFromSearch(), "ADOOR", "Failure Message: No matching records found");
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
		soft.assertEquals(storepg.getStoreNameFromSearch(), "AAA", "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreMailFromSearch(), "abcd@gmail.com",
				"Failure Message: No matching records found");
		soft.assertEquals(storepg.getStorePhoneFromSearch(), "9498571245",
				"Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreCountryFromSearch(), "INDIA", "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreCityFromSearch(), "ADOOR", "Failure Message: No matching records found");
		soft.assertAll();

	}

	@Test(priority = 10, enabled = true)
	public void validateTheDeleteIcon() throws Exception {
		storepg.searchForStoreValue("AAA");
		storepg.clickOnDeleteIcon();
		storepg.searchForStoreValue("AAA");

		Assert.assertEquals(storepg.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"Failure message:: failed to delete the store");

	}

}
