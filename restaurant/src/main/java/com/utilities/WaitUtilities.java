package com.utilities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {

	WebDriver driver;
	public WebDriverWait wait;

	/**
	 * this method is to implement implicit wait
	 * 
	 * @param driver
	 * @param i
	 */

	public void implicitWait(WebDriver driver, int i) {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(i));
		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is to implement explicit wait for visibility of element
	 * 
	 * @param driver
	 * @param elementlocator
	 * @param i
	 */
	public void waitForVisibilityOfElement(WebDriver driver, By element, long i) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is to implement explicit wait for presence of element
	 * 
	 * @param driver
	 * @param element
	 * @param i
	 */
	public void waitForPresenceOfElement(WebDriver driver, By element, int i) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is to implement explicit wait for element to be clickable
	 * 
	 * @param driver
	 * @param element
	 * @param i
	 */
	public void waitForElementTobeClickable(WebDriver driver, WebElement element, int i) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {

			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

}
