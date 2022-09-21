package abhiPOMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.tyss.ProvidenceSMS.genericUtility.TabNames;
import org.tyss.ProvidenceSMS.genericUtility.WebDriverUtility;

public class CommonPage {
	//Declaration of all elements 
	    //Login
		@FindBy(id = "email")
		private WebElement emailTextField;
		@FindBy(id = "password")
		private WebElement passwordTextField;
		@FindBy(id = "btnSubmit")
		private WebElement submitButton;
		
		//signout
		@FindBy(xpath = "//div[@class='navbar-custom-menu']/descendant::li[@class='dropdown user user-menu']")
		private WebElement signOutBar;
		@FindBy(xpath = "//a[text()='Sign out']")
		private WebElement signOut;
		
		//Dynamic Path Declaration
		private String dynamicPathtab = "//span[text()='%s']";
		
		//initialization of all common elements in Commomnpage
		public CommonPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		//Business Library login
		public void loginAction(String email, String password) {
			emailTextField.sendKeys(email);
			passwordTextField.sendKeys(password);
			submitButton.click();
		}
		
		//business Library tabs
		public void clickRequiredTab(WebDriverUtility webDriverUtility, TabNames tabName) {
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicPathtab,tabName.getTabName()).click();	
		}
		
		//Business Library SignOut
		public void signoutAction()
		{
			signOutBar.click();
			signOut.click();
		}
}
