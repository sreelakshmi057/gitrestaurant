package com.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StorePage;
import com.utilities.PropertyUtilities;
import com.utilities.WaitUtilities;
import com.utilities.WebActionUtilities;
import com.utilities.WebbrowserUtilities;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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
	WaitUtilities waitUtil= new WaitUtilities();
	
	@BeforeMethod
	public void preRun() throws IOException {
		driver = getDriver();
		prop = PropertyUtilities.getProperty("config.properties");
		brwsrUtil.launchUrl(driver, prop.getProperty("url"));
		loginpg = new LoginPage(driver);
		homepg = loginpg.login(prop.getProperty("username"), prop.getProperty("password"));
		storepg = homepg.navigateToStorePage();
	}
	
	@Test(priority = 3, enabled = false)
	public void validateAddStorePageHasElementsDisplayed() throws Exception{
		storepg.clickOnAddStoreButton();
		waitUtil.waitForVisibilityOfElement(driver, By.xpath("//input[@id='StoreName']"), 10);
	
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(storepg.isStoreNameDisplayed(), "Failure Message: Storename not displayed");
		soft.assertTrue(storepg.isStoreMailDisplayed(), "Failure Message: Storemail not displayed");
		soft.assertTrue(storepg.isStorePhoneDisplayed(), "Failure Message: Storephone not displayed");
		soft.assertTrue(storepg.isStoreCountryDisplayed(), "Failure Message: Storecountry not displayed");
		soft.assertTrue(storepg.isStoreCityDisplayed(), "Failure Message: Storecity not displayed");
		soft.assertAll();
		
	}
	
	@Test(priority = 4, enabled = false)
	public void validateEnteredStoreValues() throws Exception{
		storepg.clickOnAddStoreButton();
		waitUtil.waitForVisibilityOfElement(driver, By.xpath("//input[@id='StoreName']"), 10);
		storepg.clickOnStoreName();
		storepg.enterValueToStoreName("AAA");
		storepg.enterValueToStoreMail("aa@gmail.com");
		storepg.enterValueToStoreNumber("9498571245");
		storepg.enterValueToStoreCountryName("INDIA");
		storepg.enterValueToStoreCityName("ADOOR");
		storepg.enterValueToStoreAddress("Heaven ALAPPUZHA");
		storepg.enterValueToStoreCustomerFooter("done by AKHIL");
		storepg.submit();
		storepg.searchForStoreValue("AAA");
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepg.getStoreNameFromSearch(),"AAA" , "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreMailFromSearch(),"aa@gmail.com" , "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStorePhoneFromSearch(), "9498571245" , "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreCountryFromSearch(),"INDIA" , "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreCityFromSearch(),"ADOOR" , "Failure Message: No matching records found");
		soft.assertAll();
	
	}
	
	@Test(priority = 5, enabled = false)
	public void validateTheEditedStoreValues() throws Exception{
		storepg.searchForStoreValue("ABC");
		storepg.clickOnEditIcon();
		storepg.enterValueToStoreMail("abcd@gmail.com");
		storepg.clickOnEditSubmitButton();
		storepg.searchForStoreValue("ABC");
	
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(storepg.getStoreNameFromSearch(),"ABC" , "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreMailFromSearch(),"abcd@gmail.com" , "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStorePhoneFromSearch(), "1234567890" , "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreCountryFromSearch(),"INDIA" , "Failure Message: No matching records found");
		soft.assertEquals(storepg.getStoreCityFromSearch(),"CHENGANNUR" , "Failure Message: No matching records found");
		soft.assertAll();
		
	}
	
	@Test(priority = 6, enabled = true)
	public void validateTheDeleteIcon() throws Exception{
		storepg.searchForStoreValue("ABCD");
		storepg.clickOnDeleteIcon();
		storepg.searchForStoreValue("ABCD");
		
		//Assert.	assertEquals(storepg.getStoreNameFromSearch(), "ABCD","Message::Item deleted");
		Assert.fail("Message::Item deleted");
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test(priority = 3, enabled = true, dataProvider="Storevalues" )
//	public void validateAddingStoreValues(String nme,String mal,String phn,String cntryname,String citynme) {
//		
//		storepg.clickOnAddStoreButton();
//		storepg.testData();
//		storepg.addingStoreName(nme);
//		storepg.addingMailidToStore(mal);
//		storepg.addingStoreNumber(phn);
//		storepg.addingCountryName(cntryname);
//		storepg.addingCityName(citynme);
//		storepg.submit();
//		
//	}

}
