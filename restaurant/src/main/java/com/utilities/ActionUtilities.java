package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtilities {
	Actions action;

	/**
	 * this method is to perform movetoelement and click using action class
	 * 
	 * @param element
	 */

	public void moveToElementAndClick(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		try {
			action.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			throw new RuntimeException("Exception while performing movetoelement and click");
		}
	}

	/**
	 * this method is to perform doubleclick using action class
	 * 
	 * @param element
	 */
	public void doubleClick(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		try {
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			throw new RuntimeException("Exception while performing doubleclick");
		}
	}

	/**
	 * this method is to perform clickandhold using action class
	 * 
	 * @param element
	 */

	public void clickAndHold(WebElement element, WebDriver driver) {
		action = new Actions(driver);
		try {
			action.clickAndHold(element).release().build().perform();
		} catch (Exception e) {
			throw new RuntimeException("Exception while performing click and hold");
		}
	}

	/**
	 * this method is to perform clickandsendkeys action using action class
	 * 
	 * @param element
	 * @param value
	 */
	public void clickAndSendKeys(WebElement element, String value,WebDriver driver) {
		action = new Actions(driver);
		try {
			action.click(element).sendKeys(value).build().perform();
		} catch (Exception e) {
			throw new RuntimeException("Exception while performing click and sendkeys");
		}
	}

	/**
	 * this method is to perform rightclick using action class
	 * 
	 * @param element
	 */
	public void contextClick(WebElement element,WebDriver driver) {
		action = new Actions(driver);
		try {
			action.contextClick(element).build().perform();
		} catch (Exception e) {
			throw new RuntimeException("Exception while performing contextclick");
		}
	}

	/**
	 * this method is to perform draganddrop using action class
	 * 
	 * @param source
	 * @param target
	 */
	public void dragAndDrop(WebElement source,WebDriver driver, WebElement target) {
		action = new Actions(driver);
		try {
			action.dragAndDrop(source, target).build().perform();
		} catch (Exception e) {
			throw new RuntimeException("Exception while performing ddraganddrop");
		}
	}

	/**
	 * this method is to perform movetoelementandrightclick using action class
	 * 
	 * @param element
	 */
	public void moveToElementAndContextClick(WebElement element,WebDriver driver) {
		action = new Actions(driver);
		try {
			action.moveToElement(element).contextClick().build().perform();
		} catch (Exception e) {
			throw new RuntimeException("Exception while performing movetoelement and contextclick");
		}
	}

}
