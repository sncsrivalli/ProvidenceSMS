package org.providencesms.admin.pavani;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.SMS_Sandford_Park_School.BaseClass;
import org.tyss.objectRepository.CreateGradePage;
import org.tyss.objectRepository.Tabnamesforhomepage;

public class CreateGradeTest extends BaseClass {
	@Test
	public void createGradeTest() throws InterruptedException {

		commonpage.clickRequiredTab(Tabnamesforhomepage.GRADETAB, wb);

		CreateGradePage cgp = new CreateGradePage(driver);

		String grade = "grade" + jb.getRandomNumber(10000);
		cgp.createGrade(grade, 100, 200);
		cgp.sendRangeAndGrade("75-100", "A");
		
	        Thread.sleep(3000);
		List<WebElement> headerlist = cgp.getHeaderList();

		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Grade")) {
				List<WebElement> gradelist = cgp.getGradeList();

				int count = 0;

				for (WebElement g : gradelist) {
					String gd = g.getText();

					if (gd.equals(grade))

					{
						System.out.println("TC Pass");
						
						count++;
						break;

					}

				}
				wb.jsIntialization(driver);
				WebElement n3 = cgp.NextButtonInAllGrade();
				wb.scrollTillElementViewUsingJS(n3);
				
				WebElement n=cgp.numberOfTimesNextButtonClick();
				String n1 = n.getText();
				
				for(int i=2;i<=Integer.parseInt(n1);i++)
				{             
					
				
				
				cgp.clickNextButtonInAllGrade();

				gradelist = cgp.getGradeList();

				for (WebElement g : gradelist) {
					String gd = g.getText();

					if (gd.equals(grade)) {
						System.out.println("TC Pass");
						
						count++;
						break;

					
				}}
				}
				if (count == 0) {
					Assert.fail("Test case is fail newly created grade is not found");
					System.out.println("Tc fail");
				}

			}

		}

	}

}
