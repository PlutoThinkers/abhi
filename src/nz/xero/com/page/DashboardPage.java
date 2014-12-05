package nz.xero.com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Dashboard{
	
	public Dashboard(WebDriver webDriver){
		PageFactory.initElements(webDriver, this);
	}

	public void navigateToSalesPage(WebDriver webDriver) {
		webDriver.navigate().to("https://go.xero.com/Accounts/Receivable/Dashboard/");
	}

}
