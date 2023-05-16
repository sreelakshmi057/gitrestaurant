package com.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ExcelUtilities;
import com.utilities.PropertyUtilities;

public class ExpensePageTest extends AutomationBase {
	WebDriver driver;
	LoginPage loginpg;
	ExpensePage expensepg;
	Properties prop;
	HomePage homepg;
	PropertyUtilities propUtil;
	ExcelUtilities excelUtil;

	@BeforeMethod
	public void prerun() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		propUtil = new PropertyUtilities();
		prop = PropertyUtilities.getProperty("config.properties");
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		expensepg = homepg.navigateToExpensePage();
		excelUtil = new ExcelUtilities();
	}

	@Test(priority = 23, enabled = true, groups = {"smoke"}, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
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

	@Test(priority = 24, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEnteredExpenseValues() {
		expensepg.clickOnAddExpenseButton();
		String exp_date = excelUtil.readStringData("expense", 2, 2);
		expensepg.enterValueToExpenseDate(exp_date);
		String exp_ref = excelUtil.readStringData("expense", 3, 2);
		expensepg.enterValueToExpenseReference(exp_ref);
		String exp_category = excelUtil.readStringData("expense", 4, 2);
		expensepg.selectExpenseCategoryByVisibleText(exp_category);
		String exp_store = excelUtil.readStringData("expense", 5, 2);
		expensepg.selectExpenseStoreByVisibleText(exp_store);
		String exp_amt = excelUtil.readStringData("expense", 6, 2);
		expensepg.enterValueToExpenseAmount(exp_amt);
		String exp_description = excelUtil.readStringData("expense", 7, 2);
		expensepg.enterValueToExpenseDescription(exp_description);
		expensepg.clickOnExpenseSubmitButton();
		expensepg.searchForExpenseValue(exp_ref);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensepg.getExpenseDateFromSearchResult(), "2023-05-01", AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseReferenceFromSearchResult(), "referenceA",
				AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseCategoryFromSearchResult(), "Miscellaneous",
				AutomationConstants.errorMessage);
		soft.assertAll();
	}

	@Test(priority = 25, enabled = true, groups = {"smoke"}, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateTheEditedStoreValues() {
		String exp_searchref = excelUtil.readStringData("expense", 10, 2);
		expensepg.searchForExpenseValue(exp_searchref);
		expensepg.clickOnExpenseEditIcon();
		String exp_editref = excelUtil.readStringData("expense", 11, 2);
		expensepg.enterValueToExpenseReference(exp_editref);
		String exp_editamt = excelUtil.readStringData("expense", 12, 2);
		expensepg.enterValueToExpenseAmount(exp_editamt);
		expensepg.clickOnExpenseEditSubmitButton();
		expensepg.searchForExpenseValue(exp_editref);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(expensepg.getExpenseDateFromSearchResult(), "2023-05-01", AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseReferenceFromSearchResult(), "referenceB",
				AutomationConstants.errorMessage);
		soft.assertEquals(expensepg.getExpenseCategoryFromSearchResult(), "Miscellaneous",
				AutomationConstants.errorMessage);
		soft.assertAll();
	}
}
