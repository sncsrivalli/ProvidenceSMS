package org.providenceSMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.SubTabNames;
import org.tyss.providenceSMS.genericUtility.TabNames;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class TeacherHomePage {
	
	CommonPage commonPage ;
	//Initialization of WebElements in Home Page
	public TeacherHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Business Libraries
	public void clickExamTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.EXAMTAB);
	}
	
	public void clickExamTimetableSubTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredSubTab(webDriverUtility, SubTabNames.ExamTimetableTab);
	}
	
	public void clickMyPettyCashTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.MYPETTYCASHTAB);
	}
	
	public void clickEventsTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.EVENTTAB);
	}
	
	public void clickMyEventsSubTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredSubTab(webDriverUtility, SubTabNames.MyEventsTab);
	}
	
}
