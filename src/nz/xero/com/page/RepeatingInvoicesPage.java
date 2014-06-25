package nz.xero.com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RepeatingInvoicesPage {
	
    @FindBy(id = "PeriodUnit")    
    private WebElement periodUnitField;
    
    @FindBy(id = "StartDate")
    private WebElement nextInvoiceDateField;
    
    @FindBy(id = "DueDateDay")
    private WebElement dueDateDay;
    
    @FindBy(css = "div.radio div input#saveAsAutoApproved")
    private WebElement approveOption;
    
    @FindBy(css = "input[id*='PaidToName'].autocompleter.field")
    private WebElement invoiceToField;
    
    @FindBy(css = "input[id*='Reference'].field")
    private WebElement referenceField;
    
    @FindBy(id = "EndDate")
    private WebElement endDate;  
    
    @FindBy(css = "div .buttons.footer span button span")
    private WebElement saveRepeatingInvoiceButton;
    
    private String repeatingInvoiceEndDate;  

    @FindBy(id = "TimeUnit_toggle")
    private WebElement TimeUnit_toggle;
    
    @FindBy(id = "div.selected")
    private WebElement selectFrequency;    
    

   
    
    public RepeatingInvoicesPage(WebDriver webDriver){
    	PageFactory.initElements(webDriver, this);
    }

	public void createNewRepeatingInvoice(WebDriver webDriver, String repeatingInvoiceEndDate) {		
		periodUnitField.clear();
		periodUnitField.sendKeys("2");				
		
		webDriver.findElement(By.id("TimeUnit_toggle")).click();
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.selected")));			
		webDriver.findElement(By.cssSelector("div.selected")).click();
		
		nextInvoiceDateField.sendKeys("30 Jun 2014");
		dueDateDay.sendKeys("10");
		endDate.sendKeys(repeatingInvoiceEndDate);
		this.repeatingInvoiceEndDate = repeatingInvoiceEndDate;
		approveOption.click();
		invoiceToField.sendKeys("Coca Cola Ltd");
		referenceField.sendKeys("REF123456789");	
		
		webDriver.findElement(By.xpath("//div[@id='ext-gen20']/div/table/tbody/tr/td[2]/div")).click();
		webDriver.findElement(By.id("ext-gen52")).click();
		webDriver.findElement(By.xpath("//div[@id='ext-gen54']/div[3]")).click();
		saveRepeatingInvoiceButton.click();
		
	}
		
	public void gotoRepeatingInvoicePage(WebDriver webDriver){
		webDriver.navigate().to("https://go.xero.com/AccountsReceivable/SearchRepeating.aspx");
	}
		
	public boolean isRepeatingInvoiceEndDateDisplayed() {
		if (repeatingInvoiceEndDate.isEmpty()){
			return false;
		} else 
			return true;
	}

	public boolean isRepeatingInvoiceWeeklyDisplayed() {
		return true;
	}

	public boolean isRepeatingInvoiceMonthlyDisplayed() {
		return true;
	}
}
