package stepdefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import BasePackage.BaseTest;
import BasePackage.ExcelUtilities;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.Objects1;
import pageobjectmodel.Objects2;
import pageobjectmodel.Objects3;

public class Stepdefinitions{
	Properties p;
	String act_url;
	public static String path;
	public static WebDriver driver;
	public Logger logger=LogManager.getLogger(this.getClass());
	Objects1 obj1 = new Objects1(driver);
	Objects2 obj2 = new Objects2(driver);
	Objects3 obj3 = new Objects3(driver);
	@Given("user should navigate to the practo website")
	public void user_should_navigate_to_the_practo_website() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Select the Browser");
        System.out.println("1.Chrome Browser"+" "+"2.MicroSoft Edge");
        Scanner sc= new Scanner(System.in);
        int user=sc.nextInt();
        if(user==1) {
        driver=new ChromeDriver();
         }
        else {

			driver=new EdgeDriver();
             }
        
        
		driver.get("https://www.practo.com/");
        driver.manage().window().maximize();
        ExcelUtilities.excelInit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        path= BaseTest.screenshot(driver, "NavigatetoUrl");
        logger.info("user is navigated to the practo website");
	    }

	@When("user gets the current url")
	public void user_gets_the_current_url() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	     act_url=driver.getCurrentUrl();
	    //throw new io.cucumber.java.PendingException();
	     logger.info("user got the current url");
	}

	@Then("verify the practo page")
	public void verify_the_practo_page() {
	    // Write code here that turns the phrase above into concrete actions
		String exp_url="https://www.practo.com/";
		Assert.assertEquals(act_url,exp_url);
	    //throw new io.cucumber.java.PendingException();
		logger.info("Verified the practo page");
	}

	@Given("user should click on find doctors")
	public void user_should_click_on_find_doctors() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		obj1.click_doctors();
	   // throw new io.cucumber.java.PendingException();
		path= BaseTest.screenshot(driver, "Finddoctors");
		logger.info("user clicked on find doctors");
	}

	@When("user selects a city")
	public void user_selects_a_city() {
	    // Write code here that turns the phrase above into concrete actions
		
		obj1.searchCity();
	    //throw new io.cucumber.java.PendingException();
		logger.info("user selected a city");
	}

	@When("user a selects a doctor")
	public void user_a_selects_a_doctor() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		obj1.searchDoctor();
	    //throw new io.cucumber.java.PendingException();
		logger.info("user selected a doctor");
	}

	@When("user applies filters")
	public void user_applies_filters() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		obj1.selectStories();
		obj1.selectExp();
		obj1.applyFilters();
		Thread.sleep(2500);
		obj1.selectSort();
		Thread.sleep(1500);
		//throw new io.cucumber.java.PendingException();
		path= BaseTest.screenshot(driver, "apply_filters");
		logger.info("user applied filters");
	}

	@Then("user should get doctors list")
	public void user_should_get_doctors_list() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		obj1.doctorDetails();
	    //throw new io.cucumber.java.PendingException();
		logger.info("user got the doctors list");
	}

	@Given("user clicks on surgeries")
	public void user_clicks_on_surgeries() {
	    // Write code here that turns the phrase above into concrete actions
		
		obj1.click_surgeries();
		logger.info("user clicked on surgeries");
		//throw new io.cucumber.java.PendingException();
	}

	@Then("surgeries list is displayed")
	public void surgeries_list_is_displayed() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		obj2.scrollDown();
		obj2.getsurgeries_list();
	   // throw new io.cucumber.java.PendingException();
		path= BaseTest.screenshot(driver, "surgeries");
		logger.info("surgeries list is displayed");
	}

	@Given("user clicks on For Corporates")
	public void user_clicks_on_for_corporates() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		obj2.click_forCorp();
		//throw new io.cucumber.java.PendingException();
		path= BaseTest.screenshot(driver, "click_forcorporates");
		logger.info("user clicked on For Corporates");
	}


	@Then("user is navigated to form page")
	public void user_is_navigated_to_form_page() {
	    // Write code here that turns the phrase above into concrete actions
		String exp_title= driver.getTitle();
		String act_title="Employee Health | Corporate Health & Wellness Plans | Practo";
		Assert.assertEquals(act_title,exp_title);
	   // throw new io.cucumber.java.PendingException();
		logger.info("user is navigated to form page");
	}

	@Given("user is on form page")
	public void user_is_on_form_page() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(obj3.name.isDisplayed(),true);
	    //throw new io.cucumber.java.PendingException();
		path= BaseTest.screenshot(driver, "formpage");
		logger.info("user is on form page");
	}

	@When("user gives all valid details except phone number")
	public void user_gives_all_valid_details_except_phone_number() throws IOException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(2000);
		obj3.sendname("Jayanth");
		obj3.sendorgname("Cognizant");
		obj3.sendno("88776655449");
		obj3.sendemail("xyz@gmail.com");
		obj3.select_org_size();
		obj3.select_interest();
		Assert.assertEquals(obj3.button.isEnabled(), false);
		
		Thread.sleep(2000);
		logger.info("user gives all valid details except phone number");
		
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("Schedule a demo button has to be disabled")
	public void schedule_a_demo_button_has_to_be_disabled() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(obj3.button.isEnabled(), false);
		path= BaseTest.screenshot(driver, "verify_button2");
	   // throw new io.cucumber.java.PendingException();
		logger.info("Schedule a demo button is disabled");
	}

	@Given("user should refresh the page")
	public void user_should_refresh_the_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.navigate().refresh();
	    //throw new io.cucumber.java.PendingException();
		logger.info("user refreshes the page");
	}

	@When("user gives all valid details except emailId")
	public void user_gives_all_valid_details_except_email_id() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().refresh();
		obj3.sendname("Jayanth");
		obj3.sendorgname("Cognizant");
		obj3.sendno("8877665544");
		obj3.sendemail("xyzgmail");
		obj3.select_org_size();
		obj3.select_interest();
		logger.info("user gives all valid details except emailId");
		
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("Schedule a demo button should be disabled")
	public void schedule_a_demo_button_should_be_disabled() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(obj3.button.isEnabled(),false);
		path= BaseTest.screenshot(driver, "verify_button3");
		logger.info("Schedule a demo button is disabled");
		//path= Objects2.screenshot(driver, "verify_button3");
	  //  throw new io.cucumber.java.PendingException();
	}

	@Given("user should refresh the page to enter details")
	public void user_should_refresh_the_page_to_enter_details() {
	    // Write code here that turns the phrase above into concrete actions
		driver.navigate().refresh();
		logger.info("user refreshes the page to enter details");
	   // throw new io.cucumber.java.PendingException();
	}

	@When("user gives all valid details")
	public void user_gives_all_valid_details() {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().refresh();
		obj3.sendname("Jayanth");
		obj3.sendorgname("Cognizant");
		obj3.sendno("8877665544");
		obj3.sendemail("xyz@gmail.com");
		obj3.select_org_size();
		obj3.select_interest();
		logger.info("user gives all valid details");
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("Schedule a demo button should be enabled")
	public void schedule_a_demo_button_should_be_enabled() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(obj3.button.isEnabled(), true);
		path= BaseTest.screenshot(driver, "verify_button3");
	   // throw new io.cucumber.java.PendingException();
		logger.info("Schedule a demo is enabled");
	}

	@Then("ThankYou message is displayed")
	public void thank_you_message_is_displayed() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		obj3.clickButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(obj3.thankyou));
		Assert.assertEquals(obj3.thankyoumsg(),true);
		path= BaseTest.screenshot(driver, "verify_button4");
		//path= Objects2.screenshot(driver, "thankyoumsg");
		ExcelUtilities.closeExcel();
		driver.quit();
		logger.info("ThankYou message is displayed");
	  //  throw new io.cucumber.java.PendingException();
	}

}
