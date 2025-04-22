package nopComPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashboradPage {

	public WebDriver ldriver;

	public DashboradPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//store web element ref.
	
	//create user defined method
}
