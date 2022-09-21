package org.tyss.providenceSMS.objectRepository.pavani;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.tyss.SMS_Sandford_Park_School.WebDriverUtility;


public class Commonpage {
	private WebDriver driver;
	//declaration
	
	private String dynamicxpath="//a[.='%s']";
	private String dynamicxpath1="//span[.='%s']";
	//initialization all element variable
	public Commonpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	//Business Library
	
	
	public void clickRequiredTab(Tabnamesforhomepage tabName,WebDriverUtility WebDriverUtility)
	{
	String tab = tabName.toString();
	
	{if(tab.equals("DASHBOARDTAB")||tab.equals("MYPROFILETAB")||tab.equals("CLASSROOMTAB")||tab.equals("GRADETAB")||tab.equals("SUBJECTTAB")||
		tab.equals("TEACHERTAB")||tab.equals("SUBJECTROUTINGTAB")||tab.equals("TIMETABLETAB")||tab.equals("STUDENTTAB")||tab.equals("STUDENTPAYMENTTAB")||
		tab.equals("ATTENDANCETAB")||tab.equals("EXAMTAB")||tab.equals("PETTYCASHTAB")||tab.equals("FRIENDSTAB")||tab.equals("EVENTTAB")||tab.equals("ADMINPIC"))
			{
		WebElement w = WebDriverUtility.convertDynamicxpathIntoWebElement(dynamicxpath1,tabName.getTabName(),driver);
		w.click();
			}
	else
	{
		WebElement w = WebDriverUtility.convertDynamicxpathIntoWebElement(dynamicxpath,tabName.getTabName(),driver);
		w.click();
			}
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
