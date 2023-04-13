package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.datasupplier.DataSupplier;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.WaiterPage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class WaiterPageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	WaiterPage waiterpg;
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
		waiterpg = homepg.navigateToWaiterInPeopleLink();
	}

	@Test(priority = 11, enabled = false)
	public void validateAddWaiterPageHasElementsDisplayed() {
		waiterpg.clickOnAddWaiterButton();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(waiterpg.isWaiterNameDisplayed(), "Failure Message: WaiterName not displayed");
		soft.assertTrue(waiterpg.isWaiterPhoneDisplayed(), "Failure Message: WaiterPhone not displayed");
		soft.assertTrue(waiterpg.isWaiterEmailDisplayed(), "Failure Message: WaiterEmail not displayed");
		soft.assertTrue(waiterpg.isWaiterStoreDisplayed(), "Failure Message: WaiterStore not displayed");
		soft.assertAll();

	}

	@Test(priority = 12, enabled = true, dataProvider = "dataSupplierWaiter", dataProviderClass = DataSupplier.class)
	public void validateTheEnteredValuesInWaiterPage(String name, String phone, String mail, String store) {
		waiterpg.clickOnAddWaiterButton();
		waiterpg.enterValueToWaiterName(name);
		waiterpg.enterValueToWaiterPhone(phone);
		waiterpg.enterValueToWaiterEmail(mail);
		waiterpg.selectWaiterStoreByVisibleText(store);
		waiterpg.clickOnwaiterSubmitButton();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiterpg.getWaiterNameFromSearchResult(), "AAN", "Failure Message: WaiterName not displayed");
		soft.assertEquals(waiterpg.getWaiterPhoneFromSearchResult(), "1234567890",
				"Failure Message: WaiterPhone not displayed");
		soft.assertEquals(waiterpg.getWaiterEmailFromSearchResult(), "aan@gmail.com",
				"Failure Message: No matching records found");
		soft.assertEquals(waiterpg.getWaiterStoreFromSearchResult(), "MNC",
				"Failure Message: WaiterStore not displayed");
		soft.assertAll();

	}

	@Test(priority = 13, enabled = true, dataProvider = "dataSupplierWaiterEdit", dataProviderClass = DataSupplier.class)
	public void validateTheEditedWaiterValues(String name, String phone, String mail, String store) {
		waiterpg.searchForStoreValue(name);
		waiterpg.clickOnWaiterEditIcon();
		waiterpg.enterValueToWaiterPhone(phone);
		waiterpg.enterValueToWaiterEmail(mail);
		waiterpg.selectWaiterStoreByVisibleText(store);
		waiterpg.clickOnWaiterEditSubmitButton();
		waiterpg.searchForStoreValue(phone);

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(waiterpg.getWaiterNameFromSearchResult(), "AAN",
				"Failure Message: No matching records found");
		soft.assertEquals(waiterpg.getWaiterPhoneFromSearchResult(), "1452367895",
				"Failure Message: No matching records found");
		soft.assertEquals(waiterpg.getWaiterEmailFromSearchResult(), "aan@gmail.com",
				"Failure Message: No matching records found");
		soft.assertEquals(waiterpg.getWaiterStoreFromSearchResult(), "MNC",
				"Failure Message: WaiterStore not displayed");
		soft.assertAll();
	}

	@Test(priority = 14, enabled = true, dataProvider = "dataSupplierWaiterDelete", dataProviderClass = DataSupplier.class)
	public void validateTheDeleteIcon(String phone) {
		waiterpg.searchForStoreValue(phone);
		waiterpg.clickOnWaiterDeleteIcon();
		waiterpg.clickOnWaiterDeleteConfirmMessage();
		waiterpg.searchForStoreValue(phone);

		Assert.assertEquals(waiterpg.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"Failure message:: failed to delete the store");

	}

}
