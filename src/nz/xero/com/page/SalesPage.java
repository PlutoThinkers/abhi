package nz.xero.com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sales{
	
    @FindBy(css = "#ext-gen1036 > span")
    private WebElement newButton;
    
    @FindBy(css = "li.ico-repeating-invoice > a > b")
    private WebElement newRepeatingInvoiceButton;
    
    public SalesPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }
    
	public void selectNewRepeatingInvoice() {
		newButton.click();
		newRepeatingInvoiceButton.click();
	}

}
