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
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtilities;

public class ExpensePageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	ExpensePage expensepg;
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
		expensepg = homepg.navigateToExpensePage();

	}

	@Test(priority = 23, enabled = true)
	public void validateAddExpensePageHasElementsDisplayed() {
		expensepg.clickOnAddExpenseButton();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(expensepg.isExpenseDateDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(expensepg.isExpenseReferenceDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(expensepg.isExpenseCategoryDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(expensepg.isExpenseStoreDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(expensepg.isExpenseAmountDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertTrue(expensepg.isExpenseDescriptionDisplayed(), AutomationConstants.linkDisplayCheck);
		soft.assertAll();

	}

	@Test(priority = 24, enabled = true)
	public void validateEnteredExpenseValues() {
		expensepg.clickOnAddExpenseButton();
		expensepg.enterValueToExpenseDate("05/01/2023");
		expensepg.enterValueToExpenseReference("referenceA");
		expensepg.selectExpenseCategoryByVisibleText("Miscellaneous");
		expensepg.selectExpenseStoreByVisibleText("MNC");
		expensepg.enterValueToExpenseAmount("2000");
		expensepg.enterValueToExpenseDescription("EXPENSE DESCRIPTION");
		expensepg.clickOnExpenseSubmitButton();
		expensepg.searchForExpenseValue("referenceA");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensepg.getExpenseDateFromSearchResult(), "2023-05-01", AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseReferenceFromSearchResult(), "referenceA",
				AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseCategoryFromSearchResult(), "Miscellaneous",
				AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseStoreFromSearchResult(), "MNC", AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseAmountFromSearchResult(), "2000", AutomationConstants.errorMessage);
		soft.assertAll();

	}

	@Test(priority = 25, enabled = true)
	public void validateTheEditedStoreValues() {
		expensepg.searchForExpenseValue("referenceA");
		expensepg.clickOnExpenseEditIcon();
		expensepg.enterValueToExpenseReference("referenceB");
		expensepg.enterValueToExpenseAmount("1250");
		expensepg.clickOnExpenseEditSubmitButton();
		expensepg.searchForExpenseValue("referenceB");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensepg.getExpenseDateFromSearchResult(), "2023-05-01", AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseReferenceFromSearchResult(), "referenceB",
				AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseCategoryFromSearchResult(), "Miscellaneous",
				AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseStoreFromSearchResult(), "MNC", AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseAmountFromSearchResult(), "1250", AutomationConstants.errorMessage);
		soft.assertAll();

	}

	@Test(priority = 26, enabled = true)
	public void validateTheDeleteIcon() {
		expensepg.searchForExpenseValue("referenceB");
		expensepg.clickOnExpenseDeleteIcon();
		expensepg.clickOnExpenseDeleteConfirmMessage();
		expensepg.clickOnExpenseDeleteOkConfirmMessage();
		expensepg.searchForExpenseValue("referenceB");

		Assert.assertEquals(expensepg.getTheSearchResultOfDeletedEntry(), AutomationConstants.errorMessage,
				AutomationConstants.deleteCheck);

	}

}
