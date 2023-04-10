package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
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
	public void prerun() throws IOException {
		driver = getDriver();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		loginpg = new LoginPage(driver);
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		waiterpg = homepg.navigateToWaiterInPeopleLink();
	}

	@Test(priority = 11, enabled = true)
	public void validateAddWaiterPageHasElementsDisplayed() throws Exception {
		waiterpg.clickOnAddWaiterButton();
		waitUtil.waitForElementTobeClickable(driver, waiterpg.waiterName, 25);

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(waiterpg.isWaiterNameDisplayed(), "Failure Message: WaiterName not displayed");
		soft.assertTrue(waiterpg.isWaiterPhoneDisplayed(), "Failure Message: WaiterPhone not displayed");
		soft.assertTrue(waiterpg.isWaiterEmailDisplayed(), "Failure Message: WaiterEmail not displayed");
		soft.assertTrue(waiterpg.isWaiterStoreDisplayed(), "Failure Message: WaiterStore not displayed");
		soft.assertAll();

	}

	@Test(priority = 12, enabled = true)
	public void validateTheEnteredValuesInWaiterPage() throws Exception {
		waiterpg.clickOnAddWaiterButton();
		waitUtil.waitForVisibilityOfElement(driver, waiterpg.waiterName, 15);
		waiterpg.enterValueToWaiterName("AAN");
		waiterpg.enterValueToWaiterPhone("1234567890");
		waiterpg.enterValueToWaiterEmail("aan@gmail.com");
		waiterpg.selectWaiterStoreByVisibleText("MNC");
		waiterpg.clickOnwaiterSubmitButton();
		waitUtil.waitForVisibilityOfElement(driver, waiterpg.waiterPhone_SearchResult, 15);

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

	@Test(priority = 13, enabled = true)
	public void validateTheEditedStoreValues() throws Exception {
		waiterpg.searchForStoreValue("AAN");
		waiterpg.clickOnWaiterEditIcon();
		waiterpg.enterValueToWaiterPhone("1452367895");
		waiterpg.clickOnWaiterEditSubmitButton();
		waiterpg.searchForStoreValue("1452367895");

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

	@Test(priority = 14, enabled = true)
	public void validateTheDeleteIcon() throws Exception {
		waiterpg.searchForStoreValue("1452367895");
		waiterpg.clickOnWaiterDeleteIcon();
		waiterpg.clickOnWaiterDeleteConfirmMessage();
		waiterpg.searchForStoreValue("1452367895");

		Assert.assertEquals(waiterpg.getTheSearchResultOfDeletedEntry(), "No matching records found",
				"Failure message:: failed to delete the store");

	}

}
