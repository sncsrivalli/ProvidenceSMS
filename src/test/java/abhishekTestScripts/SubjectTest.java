package abhishekTestScripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS.genericUtility.BaseClass;

public class SubjectTest extends BaseClass {
@Test
	public void subjectTest() throws InterruptedException {

		String adminUN = property.getDataFromPropertyFile("userName");
		String adminPWD = property.getDataFromPropertyFile("password");

		// Scripts
		commonPage.loginAction(adminUN, adminPWD);

		// Login Validation through welcome message
		String message = webdriver.loginValidation();
		// webdriver.verifyWebPage(message,"Welcome back!");
		
		// Assert.assertEquals(message, "Welcome back!");
		if (message.equals("Welcome back!")) {
			System.out.println("Login is sucessfull..");
		} else {
			System.out.println("Login is failure..");
		}

		// Click on SubjectTAB
		adminHomePage.clickAdminTab2(webdriver, driver);

		// get Data From excel with Key
		Map<String, String> map = subjectPage.addSubject(webdriver, excel);

		WebElement dropdown = subjectPage.dropdownSubjectAction();
		webdriver.dropdownByText(dropdown, "100");

		// ScrollBar
		// Thread.sleep(3000);
		WebElement scroll = subjectPage.nextSubjectAction();
		// jsu.scrollTillElementUsingJSE(scroll);
		Point loc = scroll.getLocation();
		int x = loc.getX();
		int y = loc.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");

		// entered data is in the tables
		List<WebElement> subjectList = subjectPage.table1SubjectAction();
		List<WebElement> subjectNameList = new ArrayList<WebElement>();

		for (WebElement A : subjectList) {
			String headerName = A.getText();
			System.out.println(headerName);
			if (headerName.equals("Subject")) {
				subjectNameList = subjectPage.table2SubjectAction();
				for (WebElement d : subjectNameList) {
					System.out.println(d.getText());
				}
			}
			for (WebElement subjectName : subjectNameList) {
				String name = subjectName.getText();
				System.out.println(subjectName.getText());
				if (name.equals("autocad")) {
					System.out.println("Subject name is added: Pass");
					break;
				}

			}

		}
		// deleting the Subject
		subjectPage.deleteSubjectAction();

		// Signout Script
		commonPage.signoutAction();

	}
}
