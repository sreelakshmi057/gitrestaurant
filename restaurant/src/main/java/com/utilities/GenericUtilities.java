package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtilities {
	WebDriver driver;
	Select select;

	/**
	 * this method is to select the element by its value
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 * 
	 */
	public void SelectElementByValue(WebDriver driver, WebElement element, String value) {
		select = new Select(element);
		try {
			select.selectByValue(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is to select the element by index
	 * 
	 * @param driver
	 * @param element
	 * @param index
	 */
	public void SelectElementByIndex(WebDriver driver, WebElement element, int index) {
		select = new Select(element);
		try {
			select.selectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is to select the option by visible text
	 * 
	 * @param driver
	 * @param element
	 * @param text
	 *
	 */
	public void SelectByVisibleText(WebDriver driver, WebElement element, String text) {
		select = new Select(element);
		try {
			select.selectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is used to get all the element option
	 * 
	 * @param driver
	 * @param element
	 * 
	 */
	public List<WebElement> GetOptionsOfElement(WebDriver driver, WebElement element) {
		List<WebElement> option = null;
		select = new Select(element);
		try {
			option = select.getOptions();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return option;
	}

	/**
	 * this method is used to get all the selected options of a drop down
	 * 
	 * @param driver
	 * @param element
	 * @return
	 */
	public List<WebElement> GetAllSelectedOptionsOfElement(WebDriver driver, WebElement element) {
		List<WebElement> option = null;
		select = new Select(element);
		try {
			option = select.getAllSelectedOptions();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return option;
	}

	/**
	 * this method is used to get the first selected option in the drop down
	 * 
	 * @param driver
	 * @param element
	 * 
	 */
	public String GetFirstSelectedOptionOfElement(WebDriver driver, WebElement element) {
		String option = null;
		select = new Select(element);
		try {
			option = select.getFirstSelectedOption().getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		return option;
	}

	/**
	 * this method is used to deselect the drop down element by its value
	 * 
	 * @param driver
	 * @param element
	 * @param value
	 * 
	 */
	public void deSelectElementByValue(WebDriver driver, WebElement element, String value) {
		select = new Select(element);
		try {
			select.deselectByValue(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is used to deselect the drop down element by its index
	 * 
	 * @param driver
	 * @param element
	 * @param index
	 */
	public void DeSelectElementByIndex(WebDriver driver, WebElement element, int index) {
		select = new Select(element);
		try {
			select.deselectByIndex(index);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is used to deselect the option by visible text
	 * 
	 * @param driver
	 * @param element
	 * @param text
	 *
	 */
	public void deSelectElementByVisibleText(WebDriver driver, WebElement element, String text) {
		select = new Select(element);
		try {
			select.deselectByVisibleText(text);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is used to deselect all the options in the drop down
	 * 
	 * @param driver
	 * @param element
	 * 
	 */
	public void deSelectAllTheElement(WebDriver driver, WebElement element) {
		select = new Select(element);
		try {
			select.deselectAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * this method is used to capture screenshot
	 * 
	 * @param driver
	 * 
	 */

	public void captureScreenShot(WebDriver driver) {
		Date currentdate = new Date();
		try {
			String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
			File SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File DestFile = new File("C:\\Users\\HP\\eclipse-workspace\\restaurant\\src\\test\\resources\\screenshot\\"
					+ screenshotfilename + ".png");
			Files.copy(SrcFile, DestFile);
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * 
	 * @param driver
	 * @param value
	 * @param text
	 */
	public void handleAlert(WebDriver driver, String value, String option) {
		Alert obj = driver.switchTo().alert();
		try {
			obj.sendKeys(value);
			switch (option) {
			case "accept":
				obj.accept();
				break;
			case "cancel":
				obj.dismiss();
				break;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
}
