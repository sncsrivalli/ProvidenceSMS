package org.tyss.providenceSMS.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of all the actions performed on Web driver
 * @author sncsr
 *
 */
public class WebDriverUtility {
	WebDriver driver;
	
	/**
	 * This method is used to launch respective browser 
	 * @param browser
	 * @return
	 */
	
	public WebDriver launchBrowser(String browser) {
		
		switch(browser) {
		
		case "chrome": WebDriverManager.chromedriver().setup();
						driver = new ChromeDriver();
						break;
		case "firefox": WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
						break;
		case "ie":WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
		default : System.out.println("Enter Valid Browser Name");
		 			break;
		
		}
		
		return driver;
	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method is used to wait till the browser page is loaded completely
	 * @param driver
	 * @param longTimeout
	 */
	
	public void WaitTillLoad( long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}
	/**
	 * This method is used to navigate to the application using given url
	 * @param driver
	 * @param url
	 */
	public void navigateToApplication( String url) {
		driver.get(url);
	}
	/**
	 * This method is used to open the browser and the application
	 * @param browser
	 * @param longTimeout
	 * @param url
	 * @return 
	 */
	
	public WebDriver openBrowserAndApplication(String browser,long longTimeout,String url) {
		launchBrowser(browser);
		maximizeBrowser();
		WaitTillLoad(longTimeout);
		navigateToApplication( url);		
		return driver;
	}
	/**
	 * This method is used to handle drop down by text
	 * @param element
	 * @param value
	 */
	public void dropdownByText(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByVisibleText(value);
	}
	/**
	 * This method is used to handle drop down by value
	 * @param element
	 * @param value
	 */
	public void dropdownByValue(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByValue(value);
	}
	/**
	 * This method is used to handle drop down by index
	 * @param element
	 * @param value
	 */
	public void dropdownByIndex(WebElement element, int value) {
		Select dd = new Select(element);
		dd.selectByIndex(value);
	}
	
	/**
	 * This method is used to wait till the element is available for clicking action
	 * @param element
	 * @param timeouts
	 */
	public void explicitWait(WebElement element, long timeouts) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeouts));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to perform mouse hovering to given element
	 * @param element
	 */
	public void moveToElementAction(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * This method is used to convert dynamic xpath into Web Element
	 * @param dynamicPath
	 * @param replaceData
	 * @param driver
	 * @return
	 */
	public WebElement convertDynamicXpathIntoWebElement(String dynamicPath, String replaceData) {
		String requiredPath = String.format(dynamicPath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredPath));
		return element;
	}
	
	/**
	 * This method is used to get the screenshot 
	 */
	
	public void getScreenshot(WebDriver driver, JavaUtility javaUtility,String className) {
		String currentTime = javaUtility.currentTime();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screeshot/"+className+"_"+currentTime+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return dest.getAbsolutePath();
	}
	
	public String getScreenshot(WebDriver driver) {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		return src;
	}
	
	 
	/**
	 * This method is used to close the browser
	 */
	public void closeDriver() {
		driver.quit();
	}
	
	
}
