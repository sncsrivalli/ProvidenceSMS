package org.providencesms.systemtestscripts;

import org.openqa.selenium.ElementNotInteractableException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.providenceSMS.genericUtility.BaseClass;

public class EventCreationTest extends BaseClass{
	@Test

	public void eventCreationTest(){
		
		String teacherUN = property.getDataFromPropertyFile("Teacher_UN1");
		String teacherPWD = property.getDataFromPropertyFile("Teacher_PWD1");
		
		commonPage.loginAction(teacherUN, teacherPWD);
		teacherhomePage.clickEventsTab(webdriver, driver);
		teacherhomePage.clickMyEventsSubTab(webdriver, driver);
		
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
