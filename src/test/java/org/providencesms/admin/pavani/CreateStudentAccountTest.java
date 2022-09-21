package org.providencesms.admin.pavani;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tyss.SMS_Sandford_Park_School.BaseClass;
import org.tyss.objectRepository.CreateStudentPage;
import org.tyss.objectRepository.Tabnamesforhomepage;

public class CreateStudentAccountTest extends BaseClass {
	@Test
	public void createstudentaccounttest() {

		CreateStudentPage cd = new CreateStudentPage(driver);
		commonpage.clickRequiredTab(Tabnamesforhomepage.STUDENTTAB, wb);
		commonpage.clickRequiredTab(Tabnamesforhomepage.ADDSTUDENTTAB, wb);
		String name = "name" + jb.getRandomNumber(10000);
		cd.enterStudentDetails(Integer.parseInt(eb.getDataFromExcel("Student", 1, 0)) + jb.getRandomNumber(1000),
				eb.getDataFromExcel("Student", 1, 1), name, eb.getDataFromExcel("Student", 1, 3),
				"sa" + jb.getRandomNumber(1000) + "@gmail.com", eb.getDataFromExcel("Student", 1, 5),
				eb.getDataFromExcel("Student", 1, 6), eb.getDataFromExcel("Student", 1, 7),
				eb.getDataFromExcel("Student", 1, 8));

		cd.enterGurdianDetails(Integer.parseInt(eb.getDataFromExcel("Student", 1, 9)),
				eb.getDataFromExcel("Student", 1, 10), eb.getDataFromExcel("Student", 1, 11),
				eb.getDataFromExcel("Student", 1, 12), eb.getDataFromExcel("Student", 1, 13),
				eb.getDataFromExcel("Student", 1, 14), eb.getDataFromExcel("Student", 1, 15),
				eb.getDataFromExcel("Student", 1, 16), eb.getDataFromExcel("Student", 1, 17));

		cd.nextButton();

		cd.selectGrade("Grade 1");
Assert.fail();
		List<WebElement> headerlist = cd.getHeaderList();

		for (WebElement hl : headerlist) {
			String headername = hl.getText();
			if (headername.equals("Subject")) {
				List<WebElement> subjectlist = cd.getSubjectList();
				for (WebElement g : subjectlist) {
					String gd = g.getText();

					if (gd.equals(eb.getDataFromExcel("Student", 1, 19))) {
						cd.selectSubject();
						break;

					}
				}

			}
		}
		cd.clickSubmitButton();

		cd.clickCloseIcon(driver);

		commonpage.clickRequiredTab(Tabnamesforhomepage.STUDENTTAB, wb);
		commonpage.clickRequiredTab(Tabnamesforhomepage.ALLSTUDENTTAB, wb);

		cd.selectGrade(eb.getDataFromExcel("Student", 1, 18));

		cd.clickSubmitButton();
		
		List<WebElement> headerlist1 = cd.getHeaderList();

		for (WebElement hl : headerlist1) {
			String headername = hl.getText();
			if (headername.equals("Name")) {
				List<WebElement> namelist = cd.getNameList();
				int count = 0;
				for (WebElement h2 : headerlist1) {
					String headername1= h2.getText();
					if (headername1.equals("Name")) {
						List<WebElement> namelist1 = cd.getNameList();

						

						for (WebElement n : namelist1) {
							String nd = n.getText();

							if (nd.equals(name)) {
								System.out.println("TC Pass");
								count++;
								break;

							}

						}
						WebElement n=cd.numberOfTimesNextButtonClick();
						String n1 = n.getText();
						

						for (int i = 2; i <=Integer.parseInt(n1); i++) {

								cd.nextButtonInAllStudent();
								List<WebElement> namelist2 = cd.getNameList();

								for (WebElement n2 : namelist2) {
									String nd = n2.getText();

									if (nd.equals(name)) {
										System.out.println("TC Pass");
										count++;
										break;

									

								}
							}
					
						}
						
					}
					
					}
				if (count == 0) {
					Assert.fail("Test case is fail newly added student record is not found");
					System.out.println("Tc fail");
			}
				
				
			}
			
		}
		

	}

}
