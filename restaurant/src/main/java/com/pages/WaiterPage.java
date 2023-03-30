package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtilities;
import com.utilities.JavaScriptExecutorUtilities;
import com.utilities.WebActionUtilities;

public class WaiterPage {

	WebDriver driver;
	WebActionUtilities webaction = new WebActionUtilities();
	GenericUtilities genericUtil= new GenericUtilities();
	
	public WaiterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='People'and@class='menu-text']")
	public WebElement peoplelink;
	@FindBy(xpath = "//span[text()='Waiters']")
	public WebElement waiter;
	@FindBy(xpath = "//span[text()='Customers']")
	public WebElement customers;
	@FindBy(xpath = "//span[text()='Suppliers']")
	public WebElement suppliers;
	@FindBy(xpath = "//button[@data-toggle='modal']")
	public WebElement addwaiter;
	@FindBy(xpath = "//button[@data-toggle='modal']")
	public WebElement addwaiter_displayed;
	@FindBy(xpath = "//input[@id='WaiterName']")
	public WebElement waitername;
	@FindBy(xpath = "//input[@id='WaiterPhone']")
	public WebElement waiterphone;
	@FindBy(xpath = "//input[@id='WaiterEmail']']")
	public WebElement waiteremail;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement submitbutton;
	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	public WebElement addcustomer;
	@FindBy(xpath = "//input[@id='CustomerName']")
	public WebElement customername;
	@FindBy(xpath = "//input[@id='CustomerPhone']")
	public WebElement customerphone;
	@FindBy(xpath = "//input[@id='CustomerEmail']")
	public WebElement customeremail;
	@FindBy(xpath = "//input[@id='CustomerDiscount']")
	public WebElement customerdiscount;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement customersubmitbutton;
	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	public WebElement addsupplier;
	@FindBy(xpath = "//input[@id='CustomerName']")
	public WebElement suppliername;
	@FindBy(xpath = "//input[@id='CustomerPhone']")
	public WebElement supplierphone;
	@FindBy(xpath = "//input[@id='CustomerEmail']")
	public WebElement supplieremail;
	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	public WebElement suppliersubmitbutton;
	@FindBy(xpath = "//input[@class='form-control input-sm' and @type='search']")
	public WebElement searchtab;
	

	public void clickPeopleLink() {

		webaction.clickElement(driver, peoplelink);
	}

	public void clickOnWaiter() {

		webaction.clickElement(driver, waiter);
	}
	
	public void clickOnAddWaiter() {

		webaction.clickElement(driver, addwaiter);
	}

	public String getAddWaiterTextToVerify() {

		String message = webaction.getElementText(driver, addwaiter_displayed);
		return message;
	}

	public void addingWaiterName(String name) {
		
		webaction.enterValue(driver, waitername, name);
	}
	public void addingWaiterPhone(String value) {
		
		webaction.enterValue(driver, waiterphone,value);
	}
	public void addingWaiterMail(String mail) {
		
		webaction.enterValue(driver, waiteremail, mail);
	}
	public void clickOnWaitersubmit() {

		webaction.clickElement(driver, submitbutton);
	}
	public void searchForAddedWaiterName(String name) {

		 webaction.enterValue(driver, searchtab, name);
		 
	}
	public void searchForAddedWaiterNumber(String value) {
         webaction.clearText(driver, searchtab);
		 webaction.enterValue(driver, searchtab, value);
		
	}
	public void searchForAddedWaiterMail(String mail) {
		 webaction.clearText(driver, searchtab);
		 webaction.enterValue(driver, searchtab, mail);
	}
	public String getAddedWaiterName() {

		String message = webaction.getElementText(driver, waitername);
		return message;
	}
	public String getAddedWaiterNumber() {

		String message = webaction.getElementText(driver, waiterphone);
		return message;
	}
	public String getAddedWaiterMail() {

		String message = webaction.getElementText(driver, waiteremail);
		return message;
	}
}
