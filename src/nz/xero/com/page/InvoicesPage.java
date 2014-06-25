package nz.xero.com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicesPage {		

  @FindBy(linkText = "Click to view.")
  private WebElement clickToViewRepeatingInvoiceLink;	
	
    public InvoicesPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }		
	
	public void clickToViewNewRepeatingInvoice(){
		clickToViewRepeatingInvoiceLink.click();		
	}


}
