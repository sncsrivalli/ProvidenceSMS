package org.sdet40.practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class MavenCMDPractice {
	
	@Test
	public void test1() {
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");

	//Open brower

		//facebook browser


		WebDriverUtility webdriver = new WebDriverUtility();
		WebDriver driver = webdriver.launchBrowser(browser);
		webdriver.maximizeBrowser();
		webdriver.navigateToApplication(url);
		webdriver.WaitTillLoad(10l);
		
	
	}

}
