package org.providenceSMS.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.providenceSMS.genericUtility.SubTabNames;
import org.tyss.providenceSMS.genericUtility.TabNames;
import org.tyss.providenceSMS.genericUtility.WebDriverUtility;

public class ParentHomePage {
	CommonPage commonPage ;
	
	@FindBy(xpath = "//a[@href='my_sons_exam_timetable.php']") private WebElement mySonsExamTimetableTab;
	@FindBy(xpath = "//div[@class='navbar-custom-menu']/descendant::li[@class='dropdown user user-menu']/a/span")
	private WebElement parentNameIcon;
	
	public ParentHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
	public void clickTeacherTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.TEACHERTAB);
	}
	
	public void clickAllTeacherSubTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredSubTab(webDriverUtility, SubTabNames.AllTeacherTab);
	}
	
	public void clickExamTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		commonPage = new CommonPage(driver);
		commonPage.clickRequiredTab(webDriverUtility, TabNames.EXAMTAB);
	}
	
	public void clickMySonsExamTimetableTab(WebDriverUtility webDriverUtility,WebDriver driver) {
		mySonsExamTimetableTab.click();
	}
	
	public String getNameFromHomePage() {
		return parentNameIcon.getText();
	}

}
