package nopComPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class VendorsPage {

public WebDriver ldriver;
	
	public VendorsPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//web element on vendor page
	
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement customer_Menu;
	
	@FindBy(xpath = "//p[text()=' Vendors']")
	WebElement vendorsItem;
	
	@FindBy(xpath = "//input[@id='SearchName']")
	WebElement vendorName;
	
	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement vendorEmail;
	
	@FindBy(xpath = "//button[@id='search-vendors']")
	WebElement searchButton;
	
	//user defined method
	
	public String getPageTitle() {
		return ldriver.getTitle();
		
	}
	
	public void clickOnCustomerMenu() {
		customer_Menu.click();
	}
	
	public void clickOnVendorItem() {
		vendorsItem.click();
	}
	
	public void searchVendorName(String vName) {
		vendorName.sendKeys(vName);
	}
	
	public void searchVendorEmail(String vEmail) {
		vendorEmail.sendKeys(vEmail);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
}
