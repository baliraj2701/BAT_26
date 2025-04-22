package nopComPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	public WebDriver ldriver;
	
	public AdminPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	//We are used @findBy
	
	@FindBy(xpath = "//input[@id='Email']") 
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='Password']") 
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']") 
	WebElement btnLogin;
	
	//User defined method to perform operation on above web element ref.
	public void setUserName(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);//admin@yourstore.com
	}
	
	public void setPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);//admin
	}
	
	public void clickLogin() {
	   
		btnLogin.click();//Its perform on login button
	}
}
