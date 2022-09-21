package org.providenceSMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.SubTabNames;
import org.tyss.providenceSMS.genericUtility.TabNames;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class AdminHomePage {
	
	CommonPage commonPage ;
	//Initialization of WebElements in Home Page
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Business Library
	public void clickTeacherTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.TEACHERTAB);
	}
	
	public void clickAddTeacherSubTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredSubTab(webDriverUtility, SubTabNames.AddTeacherTab);
	}
	
	public void clickPettyCashTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.PETTYCASHTAB);
	}
	
	public void clickStudentTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.STUDENTTAB);
	}
	
	public void clickAddStudentSubTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredSubTab(webDriverUtility, SubTabNames.AddStudentTab);
	}
	
	
	
	
}
