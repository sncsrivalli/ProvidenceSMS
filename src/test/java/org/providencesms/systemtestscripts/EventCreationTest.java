package org.providencesms.systemtestscripts;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.providenceSMS.genericUtility.BaseClass;
import org.tyss.providenceSMS.genericUtility.SubTabNames;
import org.tyss.providenceSMS.genericUtility.TabNames;

public class EventCreationTest extends BaseClass{
	@Test

	public void eventCreationTest(){
		
		String teacherUN = property.getDataFromPropertyFile("Teacher_UN1");
		String teacherPWD = property.getDataFromPropertyFile("Teacher_PWD1");
		
		commonPage.loginAction(teacherUN, teacherPWD);
		commonPage.clickRequiredTab(webdriver, TabNames.EVENTTAB);
		commonPage.clickRequiredSubTab(webdriver, SubTabNames.MyEventsTab);
		
		try {
			
			createEvent.clickCreateEventButton();
			createEvent.createEvent(webdriver, excel);

		}
		catch(ElementNotInteractableException e)
		{
			excel.writeToExcel("TestData", "Add new Event", "Fail");
			commonPage.signOutAction();
			Assert.fail("Create Event button not clickable");
		}
		
	}

}
