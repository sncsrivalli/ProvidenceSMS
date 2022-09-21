package abhiPOMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS.genericUtility.TabNames;
import org.tyss.ProvidenceSMS.genericUtility.WebDriverUtility;

public class AdminHomePage {
	CommonPage commonPage;
	
	//initialization of webElements in the Homepage
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business Library
	public void clickAdminTab(WebDriverUtility webDriverUtility, WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.GRADETAB);
	
		}
	public void clickAdminTab1(WebDriverUtility webDriverUtility, WebDriver driver) {
		commonPage = new CommonPage(driver);
		
		commonPage.clickRequiredTab(webDriverUtility, TabNames.CLASSROOMTAB);
	
		}
	public void clickAdminTab2(WebDriverUtility webDriverUtility, WebDriver driver) {
		commonPage = new CommonPage(driver);
	
		commonPage.clickRequiredTab(webDriverUtility, TabNames.SUBJECTTAB);
		
		}
	public void clickAdminTab3(WebDriverUtility webDriverUtility, WebDriver driver) {
		commonPage = new CommonPage(driver);
		
		commonPage.clickRequiredTab(webDriverUtility, TabNames.PETTYCASHTAB);
		}
		
	}


