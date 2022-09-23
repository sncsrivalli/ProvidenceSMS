package abhishekTestScripts;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.tyss.providenceSMS.genericUtility.BaseClass;
import org.tyss.providenceSMS.genericUtility.TabNames;

public class ClassroomTest extends BaseClass {
@Test
	public void classroomTest() {

		// Login with Property files
		String adminUN = property.getDataFromPropertyFile("userName");
		String adminPWD = property.getDataFromPropertyFile("password");

		// Scripts
		commonPage.loginAction(adminUN, adminPWD);

		// Login Validation through welcome message
		//String message = webdriver.loginValidation();
		// webdriver.verifyWebPage(message,"Welcome back!");
		//Assert.assertEquals(message, "Welcome back!");
//		if (message.equals("Welcome back!")) {
//			System.out.println("Login is sucessfull..");
//		} else {
//			System.out.println("Login is failure..");
//		}

		// Click on ClassroomTab
		commonPage.clickRequiredTab(webdriver, TabNames.CLASSROOMTAB);

		// get Data From excel with Key
		Map<String, String> map = classroomPage.addClassroom(webdriver, excel);

		WebElement scroll = classroomPage.scrollSubjectAction();
		Point loc = scroll.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");

		List<WebElement> gradeList = classroomPage.table1SubjectAction();
		gradeList.size();

		String gr = classroomPage.coloumnSubjectAction1().getText();

		String ad = classroomPage.coloumnSubjectAction2().getText();

		if (map.get("classroom name").equalsIgnoreCase(gr) && ad.equalsIgnoreCase(map.get("student count"))) {
			System.out.println("entered classroom  is updated and entered student count is updated:Test Case PASS...");

		} else {
			System.out.println(
					"entered classroom  is not updated and entered student count is not updated:Test Case FAIL...");
		}
		// Deleting the entered data
		classroomPage.deleteClassroomAction();

		// Signout Script
		commonPage.signOutAction();
	}
}
