package RamTestscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS_GenericUtility.BaseClass;

public class CreatePettyCashTest extends BaseClass {
	@Test
	public void createPettyCashTest() {
		loginpage.teacherLoginAction(temail, tpassword);
		Map<String, String> map = excelUtility.getDataFromExcelInMapGrade("Sheet3");
		pettyCashDetails.clickMyPettyCashTab();
		pettyCashDetails.addMyPettyCash(map);
		javaUtility.robotClass();
		commonpage.signOutTeacher();
		loginpage.loginAction(email, password);
		//commonpage.clickRequiredTab(webDriverUtility, TabNames.MYPETTYCASHTAB);//driver.findElement(By.xpath("//span[.='Petty Cash']")).click();
		commonpage.clickAdminPettyCash();
		pettyCashDetails.selectIndex();
		System.out.println("TestCase pass");
		 commonpage.signOutAction();
	}

}
