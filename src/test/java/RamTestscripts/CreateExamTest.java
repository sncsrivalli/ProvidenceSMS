package RamTestscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS_GenericUtility.BaseClass;

public class CreateExamTest extends BaseClass {
	@Test
	
	public void createExamTest() throws Throwable {
		loginpage.loginAction(email, password);
		Map<String, String> map = excelUtility.getDataFromExcelInMapGrade("Sheet3");
		
		commonpage.getMessage();
		examdetails.clickExamTab();
		examdetails.addExam(map);
		//dropdown
		examdetails.selectIndex();
		
		//convert into commonpage
		examdetails.waitTillElementisClickable(examdetails.getEle());
		//gradedetails.deleteGrade();

		examdetails.waitTillElementisClickable(examdetails.getyes());
	    //	gradedetails.yesbut();	
		System.out.println("TestCase pass");
	    commonpage.signOutAction();
	    
	}
	

}
