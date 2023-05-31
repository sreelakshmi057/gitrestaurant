package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutorUtilities {
	JavascriptExecutor js;

	/**
	 * this method is to perform click using javaexecutor
	 * 
	 * @param element
	 */
	public void elementClickUsingJavaScriptExecutor(WebElement element, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", element);
	}

	/**
	 * this method is to scrolltoelement using javaexecutor
	 * 
	 * @param element
	 */
	public void scrollToElementUsingJavaScriptExecutor(WebElement element,WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * this method is to scrollfrom top to bottom using javaexecutor
	 * 
	 * @param a
	 * @param b
	 */
	public void scrollFromTopToBottomUsingJavaScriptExecutor(int a, int b,WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(a,b)");
	}

	/**
	 * this method is to scrollfrom bottom to top using javaexecutor
	 * 
	 * @param a
	 * @param b
	 */
	public void scrollFromBottomToTopUsingJavaScriptExecutor(int a, int b,WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(a,b)");
	}
}
