     package org.tyss.providenceSMS.genericUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class consists of all the reusable codes using JavascriptExecutor 
 * @author sncsr
 *
 */
public class JavaScriptUtility {
	JavascriptExecutor jse;
	
	/**
	 * This method is used for initialization of JavascriptExecutor
	 * @param driver
	 */
	public void jsInitialization(WebDriver driver) {
		jse = (JavascriptExecutor)driver;
	}
	
	/**
	 * This method is used to open the application using JavascriptExecutor
	 * @param url
	 */
	public void openApplicationUsingJSE(String url) {
		 jse.executeScript("window.location=arguments[0]",url);
	}
	
	/**
	 * This method is used to provide inputs to the web elements using JavascriptExecutor
	 * @param element
	 * @param data
	 */
	public void sendKeysUsingJSE(WebElement element, String data) {
		jse.executeScript("arguments[0].value=arguments[1]", element,data);
	}
	
	/**
	 * This method is used to click the given web element using JavascriptExecutor
	 * @param element
	 */
	public void clickUsingJSE(WebElement element) {
		jse.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * This method is used to scroll till the given web element using JavascriptExecutor
	 * @param element
	 */
	public void scrollTillElementUsingJSE(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

}
