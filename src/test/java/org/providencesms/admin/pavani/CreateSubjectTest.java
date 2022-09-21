package org.providencesms.admin.pavani;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateSubjectTest extends BaseClass {
	@Test
	public void createsubjecttest()
	{
	
	 CreateSubjectPage createsubjectpage=new CreateSubjectPage(driver);
	commonpage.clickRequiredTab(Tabnamesforhomepage.SUBJECTTAB, wb);
	 String subject = "subject"+jb.getRandomNumber(10000);
	createsubjectpage.sendSubject(subject);
    createsubjectpage.clickOnSubmit();
	 List<WebElement> headerlist = createsubjectpage.getHeaderList();
    
	 List<WebElement> subjectlist = new ArrayList<WebElement>();
	 for(WebElement hl:headerlist)
	 {String headername=hl.getText();
	 if(headername.equals("Subject"))
	 {   subjectlist=createsubjectpage.getSubjectList();
	 
		 
	 WebElement n=createsubjectpage.getNextButton();
		 wb.jsIntialization(driver);
		 wb.scrollTillElementViewUsingJS(n);
		 int count=0;
		 
		 
		 for(WebElement s:subjectlist) 
			{String sd=s.getText();
		
			
			if(sd.equals(subject))
			{
				System.out.println("TC Pass");
				count++;
				break;
				
			}
			
			
	}
		
		 
		 n.click();
		 subjectlist=createsubjectpage.getSubjectList();
		 for(WebElement s:subjectlist) 
			{String sd=s.getText();
		
			
			if(sd.equals(subject))
			{
				System.out.println("TC Pass");
				count++;
				break;
				
			}
			
	 }
		 if(count==0)
		 { Assert.fail("test case is fail newly added create subect is not found");
			 System.out.println("Tc fail");
		 }
		
		 
	 }
	 
	 }
	 

}

}



