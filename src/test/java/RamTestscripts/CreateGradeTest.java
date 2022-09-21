package RamTestscripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.tyss.ProvidenceSMS_GenericUtility.BaseClass;

public class CreateGradeTest extends BaseClass {
	@Test
	public void createGradeTest() throws InterruptedException {
	   
		loginpage.loginAction(email, password);
		Map<String, String> map = excelUtility.getDataFromExcelInMapGrade("Sheet3");
        //gradedetails = new GradeDetails(driver);
		gradedetails.clickGradeTab();
		gradedetails.addGrade(map);
		gradedetails.allGrade(map);
		commonpage.Scroll(webdriverUtility);       
		gradedetails.selectIndex();
        String gradeText = commonpage.getTextAction();
 	    System.out.println(gradeText);
	    gradedetails.waitTillElementisClickable(gradedetails.getEle());
		//gradedetails.deleteGrade();
        gradedetails.waitTillElementisClickable(gradedetails.getyes());
	    //	gradedetails.yesbut();	
	   System.out.println("TestCase pass");
	}

}



