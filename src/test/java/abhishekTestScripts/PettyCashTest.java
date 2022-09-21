package abhishekTestScripts;

import java.util.Map;
import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS.genericUtility.BaseClass;

public class PettyCashTest extends BaseClass {
	@Test
	public void pettycashTest() throws InterruptedException {

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

		// Click on PettyCashTAB
		adminHomePage.clickAdminTab3(webdriver, driver);

		// get Data From excel with Key
		Map<String, String> map = pettyCashPage.addPettyCash(webdriver, excel);

		// Signout Script
		commonPage.signoutAction();

	}

}
