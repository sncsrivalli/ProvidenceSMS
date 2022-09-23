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

public class AddStudentTest extends BaseClass{
	@Test

	public void addStudentTest()  {
		
		String adminLogin = property.getDataFromPropertyFile("Admin_UN");
		String adminPassword = property.getDataFromPropertyFile("Admin_PWD");
		commonPage.loginAction(adminLogin, adminPassword);
		commonPage.clickRequiredTab(webdriver, TabNames.STUDENTTAB);
		commonPage.clickRequiredSubTab(webdriver, SubTabNames.AddStudentTab);
		Map<String,String> map = addStudent.addNewStudent(webdriver, excel);

		addStudent.selectGradeFromDropdown(webdriver, excel);
		
		List<WebElement> headerlist = subjectTable.getSubjectTableHeaderList();
		List<WebElement> subjectlist = new ArrayList<WebElement>();
		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Subject")) {
				subjectlist = subjectTable.getSubjectList();
				for (WebElement subject : subjectlist) {
					String subjectName = subject.getText();
					
					 if(subjectName.equals(map.get("Subject"))) {
						 subjectTable.clickSubjectCheckbox(map.get("Subject"), driver);
					 break;
					 }
				}
			}
		}
		
		subjectTable.clickSubmitButton();
				
		invoicePopup.clickCloseButton(webdriver);
		javaUtility.robotClass();
		commonPage.signOutAction();
		
		try {
			String password = property.getDataFromPropertyFile("Parent_PWD1");
			commonPage.loginAction(map.get("Parent Email"),password);
			
		String name = parenthomePage.getNameFromHomePage();
		if(name.equalsIgnoreCase(map.get("Parent Full Name"))) {
			System.out.println("TC Pass");
			excel.writeToExcel("TestData", "Add new Student account", "Pass");
		}
		commonPage.signOutAction();
		}
		catch(Exception e) {
			Assert.fail("Login Failed");
			//webdriver.getScreenshot();
			excel.writeToExcel("TestData","Add new Student account", "Fail");
		}
		
		
	}

}
