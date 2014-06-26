package nz.xero.com;

import nz.xero.com.page.DashboardPage;
import nz.xero.com.page.LoginPage;
import nz.xero.com.page.RepeatingInvoicesPage;
import nz.xero.com.page.SalesPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class XeroWebApplicationAction {

	private static final String BASE_URL = "https://go.xero.com";
	private WebDriver webDriver;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private SalesPage salesPage;
	private RepeatingInvoicesPage repeatingInvoicesPage;
		
	private void setup(){
		webDriver = new FirefoxDriver();
		webDriver.get(BASE_URL);
		loginPage = new LoginPage(webDriver);
		dashboardPage = new DashboardPage(webDriver);
		salesPage = new SalesPage(webDriver);
		repeatingInvoicesPage = new RepeatingInvoicesPage(webDriver);
	}
		
	
	public void createNewRepeatingInvoice(String endDate){
		setup();
		loginPage.loginAs();
		dashboardPage.navigateToSalesPage(webDriver);
		salesPage.selectNewRepeatingInvoice();
		repeatingInvoicesPage.createNewRepeatingInvoice(webDriver, endDate);
		webDriver.close();
	}
	
	public boolean isRepeatingInvoiceEndDateDisplayed(){
		return repeatingInvoicesPage.isRepeatingInvoiceEndDateDisplayed();		
	}

}
