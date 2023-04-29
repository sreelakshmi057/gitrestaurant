package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtilities {
	WebDriver driver;
	JavascriptExecutor js;

	/**
	 * this method is to perform click using javaexecutor
	 * 
	 * @param element
	 */
	public void elementClick(WebElement element) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].click();", element);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is to scrolltoelement using javaexecutor
	 * 
	 * @param element
	 */
	public void scrolltoElement(WebElement element) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is to scrollfrom top to bottom using javaexecutor
	 * 
	 * @param a
	 * @param b
	 */
	public void scrollFromTopToBottom(int a, int b) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(a,b)");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is to scrollfrom bottom to top using javaexecutor
	 * 
	 * @param a
	 * @param b
	 */
	public void scrollFromBottomToTop(int a, int b) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(a,b)");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
}
