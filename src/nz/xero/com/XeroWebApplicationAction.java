package nz.xero.com;

import nz.xero.com.page.DashboardPage;
import nz.xero.com.page.InvoicesPage;
import nz.xero.com.page.LoginPage;
import nz.xero.com.page.RepeatingInvoicesPage;
import nz.xero.com.page.SalesPage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class XeroWebApplicationAction {

	private static final String BASE_URL = "https://go.xero.com";
	private WebDriver webDriver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private SalesPage salesPage;
	private RepeatingInvoicesPage repeatingInvoicesPage;
	private InvoicesPage invoicesPage;	
	
	public XeroWebApplicationAction() {
	}
	
	private void setup(){
		webDriver = new FirefoxDriver();
		webDriver.get(BASE_URL);
		loginPage = new LoginPage(webDriver);
		dashboardPage = new DashboardPage(webDriver);
		salesPage = new SalesPage(webDriver);
		repeatingInvoicesPage = new RepeatingInvoicesPage(webDriver);
		invoicesPage = new InvoicesPage(webDriver);		
	}
		
	
	public void createNewRepeatingInvoice(String endDate){
		setup();
		loginPage.loginAs();
		dashboardPage.navigateToSalesPage(webDriver);
		salesPage.selectNewRepeatingInvoice();
		repeatingInvoicesPage.createNewRepeatingInvoice(webDriver, endDate);
		WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Click to view.")));		
		invoicesPage.clickToViewNewRepeatingInvoice();
		webDriver.close();
	}
	
	public boolean isRepeatingInvoiceEndDateDisplayed(){
		return repeatingInvoicesPage.isRepeatingInvoiceEndDateDisplayed();		
	}

	public boolean isRepeatingInvoiceWeeklyDisplayed() {
		return repeatingInvoicesPage.isRepeatingInvoiceWeeklyDisplayed();
	}

	public boolean isRepeatingInvoiceMonthlyDisplayed() {
		return repeatingInvoicesPage.isRepeatingInvoiceMonthlyDisplayed();
	}	

}
