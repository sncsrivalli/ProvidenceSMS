package abhishekTestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.tyss.providenceSMS.genericUtility.BaseClass;
import org.tyss.providenceSMS.genericUtility.TabNames;

public class PettyCashTest extends BaseClass {
	@Test
	public void pettycashTest() throws InterruptedException {

		String adminUN = property.getDataFromPropertyFile("userName");
		String adminPWD = property.getDataFromPropertyFile("password");

		// Scripts
		commonPage.loginAction(adminUN, adminPWD);

		
		// Click on PettyCashTAB
		commonPage.clickRequiredTab(webdriver, TabNames.PETTYCASHTAB);

		// get Data From excel with Key
		Map<String, String> map = myPettyCash.addPettyCash(webdriver, excel);

		// Signout Script
		commonPage.signOutAction();

	}

}
