package com.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActionUtilities {
	
	/**
	 * this method is used to submit the form
	 * 
	 * @param driver
	 * @param element
	 */
	public void submit(WebDriver driver, WebElement element) {
		try {
			element.submit();
		} catch (Exception e) {
			throw new RuntimeException("Exception while submitting");
		}
	}
	
	/**
	 * this method is used to verify that the element is selected
	 * 
	 * @param driver
	 * @param element
	 */
	public boolean isElementSelected(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			flag = element.isSelected();
		} catch (Exception e) {
			throw new RuntimeException("Exception while checking the element is selected");
		}
		return flag;
	}
	
	/**
	 * this method is used to verify that the element is displayed
	 * 
	 * @param driver
	 * @param element
	 */
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		Boolean flag = false;
		try {
			flag = element.isDisplayed();
		} catch (Exception e) {
			throw new RuntimeException("Exception while checking the element is displayed");
		}
		return flag;
	}
	
	/**
	 * this method is used to verify that the element is enabled
	 * 
	 * @param driver
	 * @param element
	 */
	public boolean isElementEnabled(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			flag = element.isEnabled();
		} catch (Exception e) {
			throw new RuntimeException("Exception while checking the element is enabled");
		}
		return flag;
	}
	
	/**
	 * this method returns the text
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */
	public String getElementText(WebDriver driver, WebElement element) {
		String text = null;
		try {
			text = element.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return text;
	}

	/**
	 * this method is used to send inputs
	 * 
	 * @param driver
	 * @param element
	 * @param name
	 */
	public void enterValue(WebDriver driver, WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	
	/**
	 * this method is used to return the width and height of the element
	 * 
	 * @param driver
	 * @param element
	 */
	public Dimension getElementSize(WebDriver driver, WebElement element) {
		Dimension size = null;
		try {
			size = element.getSize();
		} catch (Exception e) {
			throw new RuntimeException("Exception while getting element size");
		}
		return size;
	}

	/**
	 * this method is used to clear the text
	 * 
	 * @param driver
	 * @param element
	 */
	public void clearText(WebDriver driver, WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	
	/**
	 * this method is used to return the tag name
	 * 
	 * @param driver
	 * @param element
	 */
	public String getElementTagName(WebDriver driver, WebElement element) {
		String text = null;
		try {
			text = element.getTagName();
		} catch (Exception e) {
			throw new RuntimeException("Exception while getting the tagname");
		}
		return text;
	}

	/**
	 * this method is used to click checkboxes and radio buttons
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickElement(WebDriver driver, WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this element is used to return the value of attribute
	 * 
	 * @param driver
	 * @param element
	 */
	public String getElementAttribute(WebDriver driver, WebElement element, String attribute) {
		String text = null;
		try {
			element.getAttribute(attribute);
		} catch (Exception e) {
			throw new RuntimeException("Exception while getting attribute");
		}
		return text;
	}

	/**
	 * this method is used to return the value of color, font style
	 * 
	 * @param driver
	 * @param element
	 */
	public String getElementCssValue(WebDriver driver, WebElement element) {
		String text = null;
		try {
			text = element.getCssValue(null);
		} catch (Exception e) {
			throw new RuntimeException("Exception while getting css value");
		}
		return text;
	}

	/**
	 * this method is used to get the location of a web element. The position is
	 * calculated by (x,y) coordinates
	 * 
	 * @param driver
	 * @param element
	 */
	public Point getElementLocation(WebDriver driver, WebElement element) {
		Point location = null;
		try {
			location = element.getLocation();
		} catch (Exception e) {
			throw new RuntimeException("Exception while getting element location");
		}
		return location;
	}

}
