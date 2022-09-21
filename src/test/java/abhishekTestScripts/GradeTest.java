package abhishekTestScripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS.genericUtility.BaseClass;

public class GradeTest extends BaseClass {
@Test(retryAnalyzer= org.tyss.ProvidenceSMS.genericUtility.RetryAnalyser.class)
	public void gradeTest() throws InterruptedException {

		String adminUN = property.getDataFromPropertyFile("userName");
		String adminPWD = property.getDataFromPropertyFile("password");
		// Scripts
		commonPage.loginAction(adminUN, adminPWD);
		// Login Validation through welcome message
		String expected = "Welcome back!".trim();
		String actual = webdriver.loginValidation();
		// webdriver.verifyWebPage(message,"Welcome back!");
		Assert.assertEquals(actual, expected);

        // Click on GradeTAB
		adminHomePage.clickAdminTab(webdriver, driver);
        // get Data From excel with Key
		String name = gradePage.addGrade(webdriver, excel, javaUtility);
		// ScrollBar
		
		
		WebElement scroll = gradePage.scroll();
		Point loc = scroll.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		
		// entered data is in the tables
		List<WebElement> gradeList = gradePage.table1SubjectAction();

		String gr = gradePage.coloumnSubjectAction1().getText();

//		String ad = gradePage.coloumnSubjectAction2().getText();
//
//		String ha = gradePage.coloumnSubjectAction3().getText();

		if (name.contains(gr)) {
			System.out.println("entered grade: TC Pass");

		}

		else {
			System.out.println(" TC: Fail...");

		}

		// ScrollBar
		WebElement scroll1 = gradePage.scroll1SubjectAction();
		Point loc1 = scroll1.getLocation();
		int x1 = loc1.getX();
		int y1 = loc1.getY();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(" + x1 + "," + y1 + ")");

//		gradePage.deleteGradeAction();

		// Signout Script
		commonPage.signoutAction();

	}

}
