package org.providencesms.systemtestscripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.providenceSMS.genericUtility.BaseClass;

public class AddExamTimetableTest extends BaseClass {

	@Test
	public void addExamTimetableTest() {

		String teacherUN = property.getDataFromPropertyFile("Teacher_UN1");
		String teacherPWD = property.getDataFromPropertyFile("Teacher_PWD1");
		
		commonPage.loginAction(teacherUN, teacherPWD);
		
		teacherhomePage.clickExamTab(webdriver,driver);
		teacherhomePage.clickExamTimetableSubTab(webdriver,driver);
		
		addExam.addExamTimetable(webdriver, excel);
		addExam.clickNextButton();
		examTimetable.clickAddButton();
		
		Map<String,String> map = addSubjectRoutingPage.addSubjectRouting(webdriver,excel);

		javaUtility.robotClass();
		
//		commonPage.signOutAction();
//				
//		String parentUN = property.getDataFromPropertyFile("Parent_UN2");
//		String parentPWD = property.getDataFromPropertyFile("Parent_PWD2");
//		
//		commonPage.loginAction(parentUN, parentPWD);
//		
//		parenthomePage.clickExamTab(webdriver,driver);
//		parenthomePage.clickMySonsExamTimetableTab(webdriver,driver);
//		
//		mySonsExamTimetable.selectFromExamDropdown(webdriver, map);
//		mySonsExamTimetable.clickSubmitButton();

		List<WebElement> headerList = examTimetable.getExamTimetableHeaderList();
		List<WebElement> timetablelist = new ArrayList<WebElement>();
 		for(WebElement headerName : headerList) {
			String dayName = headerName.getText();
			if(dayName.equals(map.get("Day")))
			{
				timetablelist = examTimetable.getExamTimetableList();
				break;
			
			}
			
		}
 		
 		int count=0;
 		for(WebElement examName : timetablelist) {
			String name = examName.getText();
			if(name.contains(map.get("Subject")))
			{
				excel.writeToExcel("TestData", "Add new Exam Timetable", "Pass");
				System.out.println("TC Pass");
				count++;
				break;
				
			}
			
		}
 		if(count==0) {
 			excel.writeToExcel("TestData","Add new Exam Timetable", "Fail");
 			//Assert.fail("Test Case Fail");
 						
 		}
 		
 		commonPage.signOutAction();

		
	}

}
