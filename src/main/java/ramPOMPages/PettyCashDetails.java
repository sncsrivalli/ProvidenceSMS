package ramPOMPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PettyCashDetails {
//	WebDriver driver;
//	ExcelUtility excel=new ExcelUtility();
	//declaration
		@FindBy(xpath="//span[text()='My Petty Cash']") private WebElement myPettyCashTab;
		@FindBy(xpath="//a[text()='Add ']") private WebElement addButton;
		
		@FindBy(xpath="//input[@id='textDesc_1']") private WebElement pettycashDescriptionTextfield;
		@FindBy(xpath="//input[@id='textAmount_1']") private WebElement amountTextfield;
		@FindBy(xpath="//input[@id='btnSubmit']") private WebElement submittButton;
		
		@FindBy(xpath="//select[@class='form-control input-sm']") private  WebElement entryDropdown;
		
		//initialization all element variable
		public PettyCashDetails(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		//Business library
		public void clickMyPettyCashTab() {
			myPettyCashTab.click();
			addButton.click();
			}
		
		public void addMyPettyCash(Map<String, String> map) {
			pettycashDescriptionTextfield.sendKeys(map.get("PettyCash_Description"));
			amountTextfield.sendKeys(map.get("Amount"));
			submittButton.click();
		}
		
		public void selectIndex() {
			Select s=new Select(entryDropdown);
			s.selectByIndex(3);
		}
		
		
//		public void vali() {
//			String teacherName = excel.getDataFromExcelFile("Sheet3", 8, 5);
//			driver.findElement(By.xpath("//input[@type='search']")).sendKeys(teacherName);
//			List<WebElement> pettycashlist = driver.findElements(By.xpath("//table[@id='example1']/tbody/tr"));   //tbody[@class='tBody1']/tr
//			int size = pettycashlist.size();
//			System.out.println(size);
//			
//			for(int i=0;i<size;i++) {
//				String receivedByName = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(i+1)+"]/td[2]")).getText();
//				String paidStatus = driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(i+1)+"]/td[6]")).getText();
//			     if(receivedByName.equals(teacherName) && paidStatus.equals("Pending")) {
//			    	 driver.findElement(By.xpath("//table[@id='example1']/tbody/tr["+(i+1)+"]/td[7]/a[.='Approve']")).click();
//			    	 
//			    	 excel.writeToExcel("Sheet3", 8, 4, "Pass");
//			    	 System.out.println("Test case is pass");
//			    	 driver.findElement(By.xpath("//a[@id='btnYesApprove']")).click();
//			    	 
//			    	 break;
//			     } else if(i==size-1) {
//			    	 excel.writeToExcel("Sheet3", 8, 4, "Fail");
//			    	 System.out.println("Test case is Fail");
//			     }
//				
//				}
//		}
		
		
		
}
