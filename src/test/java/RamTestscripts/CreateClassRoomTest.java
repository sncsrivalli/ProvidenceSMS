package RamTestscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS_GenericUtility.BaseClass;

public class CreateClassRoomTest extends BaseClass {
	@Test
	public void createClassroomTest() throws InterruptedException {
     
		loginpage.loginAction(email, password);
		//ClassDetails classdetails=new ClassDetails(driver);
		Map<String, String> map = excelUtility.getDataFromExcelInMapGrade("Sheet3");
		classdetails.clickClassRoomTab();
		classdetails.addClassRoom(map);
		classdetails.deleteClassRoom();
		System.out.println("TestCase pass");
		//Assert.fail();
		commonpage.signOutAction();
			
	 
		
		
	
	}

}
