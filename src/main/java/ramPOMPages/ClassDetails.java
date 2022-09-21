package ramPOMPages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClassDetails {
	
	//declaration
		@FindBy(xpath="//span[.='Classroom']") private WebElement classRoomTab;
	    
		@FindBy(id="name") private WebElement classRoomNameTextfield;
		@FindBy(id="student_count") private WebElement studentCountTextfield;
		@FindBy(xpath="//button[.='Submit']") private WebElement submittButton;
		
		@FindBy(xpath="//a[.='Delete']") private WebElement deleteButton;
		@FindBy(xpath="//a[@id='btnYes']") private WebElement yesButton;
				
		
		//initialization all element variable
		public ClassDetails(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		//Business library
		public void clickClassRoomTab() {
			classRoomTab.click();
		}


        public void addClassRoom(Map<String, String> map) {
	      classRoomNameTextfield.sendKeys(map.get("Name"));
	       studentCountTextfield.sendKeys(map.get("Student count"));
	       submittButton.click();
         }
        
        public void deleteClassRoom() {
        	deleteButton.click();
        	yesButton.click();
        }
        
        
        
        
        
}