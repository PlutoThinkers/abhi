package nz.xero.com.specification;

import nz.xero.com.XeroWebApplicationAction;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class RepeatingInvoicePageTest {
	private XeroWebApplicationAction xeroWebApplicationAction = new XeroWebApplicationAction();

    public void createNewRepeatingInvoice(String endDate) {
    	xeroWebApplicationAction.createNewRepeatingInvoice(endDate);
    }
        
    public boolean isRepeatingInvoiceEndDateDisplayed(){
		return xeroWebApplicationAction.isRepeatingInvoiceEndDateDisplayed();
    	
    }
    
 }
