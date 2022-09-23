package abhishekTestScripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.tyss.providenceSMS.genericUtility.BaseClass;
import org.tyss.providenceSMS.genericUtility.TabNames;


public class GradeTest extends BaseClass {
@Test
	public void gradeTest() throws InterruptedException {

		String adminUN = property.getDataFromPropertyFile("userName");
		String adminPWD = property.getDataFromPropertyFile("password");
		// Scripts
		commonPage.loginAction(adminUN, adminPWD);

        // Click on GradeTAB
		commonPage.clickRequiredTab(webdriver, TabNames.GRADETAB);
        // get Data From excel with Key
		String name = gradePage.addGrade(webdriver, excel, javaUtility);
		// ScrollBar
		
		
		WebElement scroll = gradePage.scroll();
		Point loc = scroll.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
		
		String gr = gradePage.coloumnSubjectAction1().getText();


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


		// Signout Script
		commonPage.signOutAction();

	}

}
