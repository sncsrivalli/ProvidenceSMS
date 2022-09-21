package org.providencesms.admin.pavani;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.SMS_Sandford_Park_School.BaseClass;
import org.tyss.objectRepository.Allexampage;
import org.tyss.objectRepository.Tabnamesforhomepage;

public class CreateExamTest extends BaseClass {
	@Test
	public void createExamTest() throws InterruptedException {

		String examname = "exam" + jb.getRandomNumber(10000);
		Allexampage ad = new Allexampage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		commonpage.clickRequiredTab(Tabnamesforhomepage.EXAMTAB, wb);
		commonpage.clickRequiredTab(Tabnamesforhomepage.CREATEEXAMTAB, wb);
		ad.addButtonClick();
		ad.addExam(examname);
		jb.customWait(4);
		List<WebElement> headerlist = ad.getHeaderList();
		List<WebElement> namelist = new ArrayList<WebElement>();
		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Name")) {
				namelist = ad.getNameList();

				int count = 0;

				for (WebElement n : namelist) {
					String nd = n.getText();

					if (nd.equals(examname)) {
						System.out.println("TC Pass");
						count++;
						break;

					}

				}
				wb.jsIntialization(driver);
				WebElement n3 = ad.nextbutton();
				wb.scrollTillElementViewUsingJS(n3);
				
				WebElement n=ad.numberOfTimesNextButtonClick();
				String n1 = n.getText();
				
				for(int i=2;i<=Integer.parseInt(n1);i++)
				{             jb.customWait(2);
					wb.scrollTillElementViewUsingJS(n3);

				ad.nextbuttonClick();
				namelist = ad.getNameList();
				for (WebElement n2 : namelist) {
					String nd = n2.getText();

					if (nd.equals(examname)) {
						System.out.println("TC Pass");
						count++;
						break;

					}
				}
				}
				if (count == 0) {
					Assert.fail("Test case Fail ,newly created exam not found");
					System.out.println("Tc fail");
				}

			}

		}

	}
}
