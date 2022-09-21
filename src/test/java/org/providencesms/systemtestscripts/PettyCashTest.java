package org.providencesms.systemtestscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.tyss.providenceSMS.genericUtility.BaseClass;

public class PettyCashTest extends BaseClass{
	
	@Test
	public void  pettyCashTest(){

		String teacherUN = property.getDataFromPropertyFile("Teacher_UN2");
		String teacherPWD = property.getDataFromPropertyFile("Teacher_PWD2");

		commonPage.loginAction(teacherUN, teacherPWD);		
		teacherhomePage.clickMyPettyCashTab(webdriver, driver);
		
		myPettyCash.clickAddButton();
		
		Map<String,String> map = myPettyCash.addPettyCash(webdriver, excel);		
		javaUtility.robotClass();
		commonPage.signOutAction();

		String adminLogin = property.getDataFromPropertyFile("Admin_UN");
		String adminPassword = property.getDataFromPropertyFile("Admin_PWD");

		commonPage.loginAction(adminLogin, adminPassword);
		adminhomePage.clickPettyCashTab(webdriver, driver);
		
		pettyCash.writeToSearchTextField(map);
		pettyCash.approveAndValidatePettyCash(driver, map, excel);

		commonPage.signOutAction();
		
		
	}

}
