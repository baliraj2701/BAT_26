package stepspackage;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import nopComPageObject.AddNewCustomerPage;
import nopComPageObject.AdminPage;
import nopComPageObject.VendorsPage;
import utilitypackage.ReadConfig;

public class StepDefination extends BaseClass {

	//hooks concept in cucumber
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Set up method execute before each scenario");
		
		readConfig=new ReadConfig();
		
		String browserName=readConfig.getBrowser();//chrome
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}
	}
	
	@Given("User luanch chrome browser")
	public void user_luanch_chrome_browser() {
	
		//driver=new ChromeDriver();
		admin=new AdminPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String url) {
	   driver.get(url);
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
	    admin.setUserName(email);
	    admin.setPassword(password);
	}

	@When("User click on Login button")
	public void user_clikc_on_login_button() {
	    admin.clickLogin();//call AdminPage method >clickLogin 
	}

	@Then("User validate title should be {string}")
	public void user_validate_title_should_be(String title) {
	  //Validation
		Assert.assertEquals(driver.getTitle(), title);//Assert Pass
	}	

	@Then("User close broser")
	public void user_close_broser() {
	  driver.quit();
	}
	
	//vendors
	
	@When("User click on customers menu")
	public void user_click_on_customers_menu() {
	    vendors=new VendorsPage(driver);
	    vendors.clickOnCustomerMenu();
	}

	@When("User click on vendors item")
	public void user_click_on_vendors_item() {
	  vendors.clickOnVendorItem();
	}

	@Then("User see vendors page")
	public void user_see_vendors_page() {
	  Assert.assertEquals(vendors.getPageTitle(),"Vendors / nopCommerce administration");
	}

	@When("User enter vendor name as {string} and email as {string}")
	public void user_enter_vendor_name_as_and_email_as(String vName, String VEmail) {
	  vendors.searchVendorName(vName);
	  vendors.searchVendorEmail(VEmail);
	}

	@When("User click on search button")
	public void user_click_on_search_button() {
	   vendors.clickOnSearchButton();
	}
	
	//Add new customer
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		addCust=new AddNewCustomerPage(driver);
		   Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
		    Thread.sleep(2000);
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menuu() throws Exception {
		 addCust.clickOnCustomesMenu();
		    Thread.sleep(2000);
	}

	@When("User click on customers menu item")
	public void user_click_on_customers_menu_item() throws InterruptedException {
		 addCust.clickOnCustomesMenuItem();
		    Thread.sleep(2000);
	}

	@When("User click on new add button")
	public void user_click_on_new_add_button() throws Exception {
		addCust.clickOnAddNew();
	    Thread.sleep(2000);
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws Exception {
		 Thread.sleep(2000);
	       Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("user enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String NewPassword, String firstName, String lastName, String gender, String compName, String adminComment) throws Exception {
		 addCust.SetEmail(newEmail);
		  addCust.SetPassword(NewPassword);
		  addCust.SetFirstName(firstName);
		  addCust.SetLastName(lastName);
		  addCust.SetGender(gender);
		//  addCust.enterDob("6/13/1988");
		//  addCust.enterManagerOfVendor("Vendor 1");
		  addCust.SetCompanyName(compName);
		  addCust.SetAdminContent(adminComment);
		    Thread.sleep(2000);
	}

	@When("user click on save button")
	public void user_click_on_save_button() {
		   addCust.clickOnSave();
	}

	@Then("User can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) throws Exception {
		 Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
		    Thread.sleep(2000);
	}
	
	@Then("close browser")
	public void close_browser() {
       driver.quit();
	}

	
	@After
	public void captureScreenshot() {
		System.out.println("We can write code to capture to screenshot of failed scenarion");
	}

}
