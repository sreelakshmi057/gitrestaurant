package com.utilities;

import org.openqa.selenium.WebDriver;

public class WebbrowserUtilities {

	/**
	 * this method is to launch the given url
	 * 
	 * @param driver
	 * @param Url
	 */
	public void launchUrl(WebDriver driver, String Url) {
		try {
			driver.get(Url);
		} catch (Exception e) {
			throw new RuntimeException("Exception while launching url");
		}
	}

	/**
	 * this method is to get the page title
	 * 
	 * @param driver
	 * @return
	 */
	public String getWebPageTitle(WebDriver driver) {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			throw new RuntimeException("Exception while getting the page title");
		}
		return title;
	}

	/**
	 * this method is to get the current loaded url
	 * 
	 * @param driver
	 * @return
	 */
	public String getCurrentUrl(WebDriver driver) {
		String current = null;
		try {
			current = driver.getCurrentUrl();
		} catch (Exception e) {
			throw new RuntimeException("Exception while getting the current url");
		}
		return current;
	}

	/**
	 * this method is to get the pagesource
	 * 
	 * @param driver
	 * @return
	 */
	public String getPageSource(WebDriver driver) {
		String page = null;
		try {
			page = driver.getPageSource();
		} catch (Exception e) {
			throw new RuntimeException("Exception while getting the page source");
		}
		return page;
	}

	/**
	 * this method is to navigate to next page
	 * 
	 * @param driver
	 */
	public void navigateToNextPage(WebDriver driver) {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			throw new RuntimeException("Exception while navigating to the next page");
		}
	}

	/**
	 * this method is to navigate to previous page
	 * 
	 * @param driver
	 */
	public void navigateToPreviousPage(WebDriver driver) {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			throw new RuntimeException("Exception while navigating to the previous page");
		}
	}

	/**
	 * this method is to refresh the page
	 * 
	 * @param driver
	 */
	public void navigateToRefreshPage(WebDriver driver) {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			throw new RuntimeException("Exception while refreshing the page");
		}
	}

	/**
	 * this method is to maximize the browsing webpage
	 * 
	 * @param driver
	 */
	public void browserMaximize(WebDriver driver) {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			throw new RuntimeException("Exception while maximizing the page");
		}
	}

	/**
	 * this method is for minimize the browsing webpage
	 * 
	 * @param driver
	 */
	public void browserMinimize(WebDriver driver) {
		try {
			driver.manage().window().minimize();
		} catch (Exception e) {
			throw new RuntimeException("Exception while minimizing the page");
		}
	}

	/**
	 * this method makes the browsing webpage in fullscreen
	 * 
	 * @param driver
	 */
	public void browserFullScreen(WebDriver driver) {
		try {
			driver.manage().window().fullscreen();
		} catch (Exception e) {
			throw new RuntimeException("Exception while getting fullscreen");
		}
	}

	/**
	 * this method is for close the browsing webpage
	 * 
	 * @param driver
	 */
	public void browserClosePage(WebDriver driver) {
		try {
			driver.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while closing the page");
		}
	}

	/**
	 * this method is for quit the browsing webpage
	 * 
	 * @param driver
	 */
	public void browserQuitPage(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			throw new RuntimeException("Exception while quiting the page");
		}
	}
}
