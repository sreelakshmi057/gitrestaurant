package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.ExpensePage;
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

public class ExpensePageTest extends AutomationBase{
	
	WebDriver driver;
	LoginPage loginpg;
	ExpensePage expensepg;
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
		expensepg = homepg.navigateToExpensePage();	
		
	}

	@Test(priority = 23, enabled = true)
	public void validateAddExpensePageHasElementsDisplayed() throws Exception {
		expensepg.clickOnAddExpenseButton();
		waitUtil.waitForElementTobeClickable(driver,expensepg.expenseDate, 20);

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(expensepg.isExpenseDateDisplayed(), "Failure Message: ExpenseDate not displayed");
		soft.assertTrue(expensepg.isExpenseReferenceDisplayed(), "Failure Message: ExpenseReferencenot displayed");
		soft.assertTrue(expensepg.isExpenseCategoryDisplayed(), "Failure Message: ExpenseCategorynot displayed");
		soft.assertTrue(expensepg.isExpenseStoreDisplayed(), "Failure Message: ExpenseStore not displayed");
		soft.assertTrue(expensepg.isExpenseAmountDisplayed(), "Failure Message: ExpenseAmount not displayed");
		soft.assertTrue(expensepg.isExpenseDescriptionDisplayed(), "Failure Message: ExpenseDescription not displayed");
		soft.assertAll();

	}

	@Test(priority = 24, enabled = true)
	public void validateEnteredExpenseValues() throws Exception {
		expensepg.clickOnAddExpenseButton();
		waitUtil.waitForElementTobeClickable(driver,expensepg.expenseDate ,20);
		expensepg.clickOnExpenseDate();
		expensepg.enterValueToExpenseDate("05/01/2023");
		expensepg.enterValueToExpenseReference("referenceA");
		expensepg.selectExpenseCategoryByVisibleText("Miscellaneous");
		expensepg.selectExpenseStoreByVisibleText("MNC");
		expensepg.enterValueToExpenseAmount("2000");
		expensepg.enterValueToExpenseDescription("EXPENSE DESCRIPTION");
		expensepg.clickOnExpenseSubmitButton();
		expensepg.searchForExpenseValue("reference10");
		waitUtil.waitForPresenceOfElement(driver, expensepg.expenseDate_SearchResult, 15);
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensepg.getExpenseDateFromSearchResult(), "2023-05-01", "Failure Message: No matching records found");
		soft.assertEquals(expensepg.getExpenseReferenceFromSearchResult(), "referenceA",
				"Failure Message: No matching records found");
		soft.assertEquals(expensepg.getExpenseCategoryFromSearchResult(), "Miscellaneous",
				"Failure Message: No matching records found");
		soft.assertEquals(expensepg.getExpenseStoreFromSearchResult(), "MNC", "Failure Message: No matching records found");
		soft.assertEquals(expensepg.getExpenseAmountFromSearchResult(), "2000", "Failure Message: No matching records found");
		soft.assertAll();

	}
	
	@Test(priority = 25, enabled = true)
	public void validateTheEditedStoreValues() throws Exception {
		expensepg.searchForExpenseValue("referenceA");
		expensepg.clickOnExpenseEditIcon();
		expensepg.enterValueToExpenseReference("referenceB");
		expensepg.enterValueToExpenseAmount("1250");
		expensepg.clickOnExpenseEditSubmitButton();
		expensepg.searchForExpenseValue("referenceB");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensepg.getExpenseDateFromSearchResult(), "2023-04-01", "Failure Message: No matching records found");
		soft.assertEquals(expensepg.getExpenseReferenceFromSearchResult(), "referenceB",
				"Failure Message: No matching records found");
		soft.assertEquals(expensepg.getExpenseCategoryFromSearchResult(), "Miscellaneous",
				"Failure Message: No matching records found");
		soft.assertEquals(expensepg.getExpenseStoreFromSearchResult(), "MNC", "Failure Message: No matching records found");
		soft.assertEquals(expensepg.getExpenseAmountFromSearchResult(), "1250", "Failure Message: No matching records found");
		soft.assertAll();

	}
	
	@Test(priority = 26, enabled = true)
	public void validateTheDeleteIcon() throws Exception {
		expensepg.searchForExpenseValue("referenceB");
		expensepg.clickOnExpenseDeleteIcon();
		expensepg.clickOnExpenseDeleteConfirmMessage();
		expensepg.clickOnExpenseDeleteOkConfirmMessage();
		expensepg.searchForExpenseValue("referenceB");

		Assert.assertEquals(expensepg.getTheSearchResultOfDeletedEntry(), "No matching records found","Failure message:: failed to delete the store" );

	}

}
