package org.providencesms.systemtestscripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.providenceSMS.genericUtility.BaseClass;
import org.tyss.providenceSMS.genericUtility.SubTabNames;
import org.tyss.providenceSMS.genericUtility.TabNames;

public class AddTeacherTest extends BaseClass{

	@Test
	public void addTeacherTest()  {
				
		String adminLogin = property.getDataFromPropertyFile("Admin_UN");
		String adminPassword = property.getDataFromPropertyFile("Admin_PWD");
		
		commonPage.loginAction(adminLogin, adminPassword);
		
		commonPage.clickRequiredTab(webdriver,TabNames.TEACHERTAB);
		commonPage.clickRequiredSubTab(webdriver,SubTabNames.AddTeacherTab);
			
		Map<String,String> map = addTeacherAction.addTeacher(webdriver,excel);

		javaUtility.robotClass();
		
		commonPage.signOutAction();
		
		String parentUN = property.getDataFromPropertyFile("Parent_UN1");
		String parentPWD = property.getDataFromPropertyFile("Parent_PWD1");
		commonPage.loginAction(parentUN, parentPWD);
		
		commonPage.clickRequiredTab(webdriver,TabNames.TEACHERTAB);
		commonPage.clickRequiredSubTab(webdriver,SubTabNames.AllTeacherTab);
		
		allTeacherPage.entryDropdown();
				

		List<WebElement> teacherNameList = new ArrayList<WebElement>();

		for (WebElement w :  allTeacherPage.getTeacherTableHeaderList()) {
			String headerName = w.getText();
			if (headerName.equals("Name")) {
				teacherNameList = allTeacherPage.getTeacherNameList();
				break;

			}
		}
		int count = 0;
		for (WebElement teacherName : teacherNameList) {
			String name = teacherName.getText();

			if (name.equals(map.get("Full Name"))) {
				excel.writeToExcel("TestData", "Add new Teacher account", "Pass");
				count++;
				break;
			}

		}
		
		if (count == 0) {
			Assert.fail("Test Case Fail, newly created teacher account not found");
			excel.writeToExcel("TestData", "Add new Teacher account", "Fail");
 		 }
		
		commonPage.signOutAction();
		

	}

}
