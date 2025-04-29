package stepspackage;

import org.openqa.selenium.WebDriver;

import nopComPageObject.AddNewCustomerPage;
import nopComPageObject.AdminPage;
import nopComPageObject.VendorsPage;
import utilitypackage.ReadConfig;

public class BaseClass {

	 WebDriver driver;
	 
	 AdminPage admin;
	 
	 ReadConfig readConfig;
	 
	 VendorsPage vendors;
	 
	 AddNewCustomerPage addNewCust;
}
