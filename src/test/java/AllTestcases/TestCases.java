package AllTestcases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseTest;
import pageobjectmodel.Objects1;
import pageobjectmodel.Objects2;
import pageobjectmodel.Objects3;

public class TestCases extends BaseTest {
	@Test(priority=1)
	public void verify_url() throws IOException {
		logger.info("*******Started******");
		String Exp_url="https://www.practo.com/";
		String act_url=driver.getCurrentUrl();
		Assert.assertEquals(Exp_url,act_url);
		path= Objects2.screenshot(driver, "verify_url");
		
	}

    @Test(priority=2)
	public void verify_select1() throws InterruptedException, IOException
	{
		
		Objects1 obj1 = new Objects1(driver);
		obj1.click_doctors();
		obj1.searchCity();
		obj1.searchDoctor();
		path= Objects2.screenshot(driver, "verify_select1");
		logger.info("Searched Doctors");
	}
	@Test(priority=3)
	public void verify_select2() throws InterruptedException, IOException {
		Objects1 obj1 = new Objects1(driver);
		obj1.selectStories();
	    obj1.selectExp();
	    path= Objects2.screenshot(driver, "verify_select2");
	    logger.info("Applying filters");
	}
	@Test(priority=4)
	public void verify_select3() throws InterruptedException, IOException {
		Objects1 obj1 = new Objects1(driver);
		obj1.applyFilters();
		Thread.sleep(2500);
		obj1.selectSort();
		Thread.sleep(1500);
		path= Objects2.screenshot(driver, "verify_select3");
		logger.info("Applied Filters");
	}
	@Test(priority=5)
	public void verify_doc_list() throws InterruptedException, IOException {
		Objects1 obj1 = new Objects1(driver);
		obj1.doctorDetails();
		path= Objects2.screenshot(driver, "verify_doc_list");
		logger.info("Doctors List is Printed");
	}
	@Test(priority=6)
	public void verify_surg_list() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Objects1 obj1 = new Objects1(driver);
		obj1.click_surgeries();
		Objects2 obj2= new Objects2(driver);
		obj2.scrollDown();
		obj2.getsurgeries_list();
		path= Objects2.screenshot(driver, "verify_surg_list");
		logger.info("Surgeries list is printed");
	}
	@Test(priority=7)
	public void verify_clickforCorp() throws IOException {
		Objects2 obj2= new Objects2(driver);
		obj2.click_forCorp();
		path= Objects2.screenshot(driver, "verify_clickforCorp");
		logger.info("clicked on for corporates");
	}
	@Test(priority=8)
	public void verify_button1() throws InterruptedException, IOException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Objects3 obj3= new Objects3(driver);
		Thread.sleep(2000);
		obj3.sendname("Jayanth");
		obj3.sendorgname("Cognizant");
		obj3.sendno("88776655442");
		obj3.sendemail("xyz@gmail.com");
		obj3.select_org_size();
		obj3.select_interest();
		Assert.assertEquals(obj3.button.isEnabled(), false);
		path= Objects2.screenshot(driver, "verify_button2");
		driver.navigate().refresh();
		Thread.sleep(2000);
		logger.info("Button is not enabled");
	}
	@Test(priority=9)
	public void verify_button2() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Objects3 obj3= new Objects3(driver);
		driver.navigate().refresh();
		obj3.sendname("Jayanth");
		obj3.sendorgname("Cognizant");
		obj3.sendno("8877665544");
		obj3.sendemail("xyzgmail");
		obj3.select_org_size();
		obj3.select_interest();
		Assert.assertEquals(obj3.button.isEnabled(),false);
		path= Objects2.screenshot(driver, "verify_button3");
		logger.info("Button is not enabled");
	}
	@Test(priority=10)
	public void verify_button3() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Objects3 obj3= new Objects3(driver);
		driver.navigate().refresh();
		obj3.sendname("Jayanth");
		obj3.sendorgname("Cognizant");
		obj3.sendno("88776655449");
		obj3.sendemail("xyz@gmail");
		obj3.select_org_size();
		obj3.select_interest();
		Assert.assertEquals(obj3.button.isEnabled(),false);
		path= Objects2.screenshot(driver, "verify_button4");
		driver.navigate().refresh();
		Thread.sleep(2000);
		logger.info("Button is not enabled");
		
	}
	@Test(priority=11)
	public void verify_button4() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Objects3 obj3= new Objects3(driver);
		driver.navigate().refresh();
		obj3.sendname("Jayanth");
		obj3.sendorgname("Cognizant");
		obj3.sendno("8877665544");
		obj3.sendemail("xyz@gmail.com");
		obj3.select_org_size();
		obj3.select_interest();
		Assert.assertEquals(obj3.button.isEnabled(), true);
		obj3.clickButton();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(obj3.thankyou));
		Assert.assertEquals(obj3.thankyoumsg(),true);
		path= Objects2.screenshot(driver, "thankyoumsg");
		logger.info("Button is enabled and thank you message is displayed");
	}
	
	
	

}
