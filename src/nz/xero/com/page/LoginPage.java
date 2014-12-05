package nz.xero.com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private static final String username = "thinkdifferent30@gmail.com";
	private static final String password = "8loversden;	
	
    @FindBy(id = "email")
    private static WebElement emailInputElement;

    @FindBy(id = "password")
    private static WebElement passwordElement;
    
    @FindBy(id = "submitButton")
    private static WebElement submitElement; 
    
    public LoginPage(WebDriver webDriver){
    	PageFactory.initElements(webDriver, this);
    }
	
    public void loginAs() {    	    	
    	emailInputElement.sendKeys(username);
		
    	passwordElement.sendKeys(password);
		
    	submitElement.click();		
		
    }
	
}
