package com.utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
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
			throw new RuntimeException("Exception while implementing implicit wait");
		}
	}
	
	public void implicitWait(WebDriver driver,long j) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(j));
		} catch (Exception e) {
			throw new RuntimeException("Exception while implementing implicit wait");
		}
	}

	/**
	 * this method is to implement explicit wait for visibility of element
	 * 
	 * @param driver
	 * @param elementlocator
	 * @param i
	 */
	public void waitForVisibilityOfElement(WebDriver driver, WebElement element, long i) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
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
	public void waitForPresenceOfElement(WebDriver driver, WebElement element, int i) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
			wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
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

	/**
	 * this method ic to implement fluent wait
	 * 
	 * @param driver
	 * @param element
	 */

	public void fluentWait(WebDriver driver, WebElement element) {
		Wait<WebDriver> fwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(5000))
				.pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class);
		fwait.until(ExpectedConditions.visibilityOf(element));
	}

}
