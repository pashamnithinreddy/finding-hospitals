package pageobjectmodel;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.ExcelUtilities;

public class Objects1 extends BasePage {

	public Objects1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//div[text()='Find Doctors']")
	WebElement findDoctors;
	@FindBy(xpath="//div[text()='Surgeries']")
	WebElement surgeries;
	@FindBy(xpath="//input[@placeholder='Search location']")
	WebElement city;
	@FindBy(xpath="//input[contains(@placeholder,'Search doctors')]")
	WebElement doctors;
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']")
	WebElement pat_stories;
	@FindBy(xpath="//ul[@role='listbox'][@data-qa-id='doctor_review_count_list']//li")
	List<WebElement> pat_stories_list;
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']")
	WebElement exp_years;
	@FindBy(xpath="//ul[@role='listbox'][@data-qa-id='years_of_experience_list']//li")
	List<WebElement> exp_years_list;
	@FindBy(xpath="//div[@data-qa-id='sort_by_section']")
	WebElement sort;
	@FindBy(xpath="//ul[@role='listbox'][@data-qa-id='sort_by_list']//li")
	List<WebElement> sort_list;
	@FindBy(xpath="//span[text()='All Filters']")
	WebElement allFilters;
	@FindBy(xpath="//div[@data-qa-id='Fees_radio']")
	List<WebElement> fees ;
	@FindBy(xpath="//div[@data-qa-id='Availability_radio']")
	List<WebElement> avail ;
	@FindBy(xpath="//h2[@class='doctor-name']")
	List<WebElement> doctors_list ;
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-main'][text()='Dentist']")
	WebElement dentist;
	@FindBy(xpath="//button[@data-qa-id='search_location']")
	WebElement location;
	
	
	public void click_doctors()
	{
		findDoctors.click();
	}
	public void click_surgeries() {
		surgeries.click();
	}
	public void searchCity() {
		city.clear();
		city.sendKeys("Bangalore");
	}
	public void searchDoctor() throws InterruptedException
	{
		doctors.sendKeys("Dentist");
		Thread.sleep(1000);
		dentist.click();
	}
	public void selectStories() throws InterruptedException {
		pat_stories.click();
		Random rd= new Random();
		int i=rd.nextInt(pat_stories_list.size());
		pat_stories_list.get(i).click();
		Thread.sleep(2000);
	}
	public void selectExp() throws InterruptedException {
		exp_years.click();
		Random rd= new Random();
		int i=rd.nextInt(exp_years_list.size());
		exp_years_list.get(i).click();
		Thread.sleep(2000);
	}
	public void applyFilters() throws InterruptedException {
		allFilters.click();
		Random rd= new Random();
		int i=rd.nextInt(fees.size());
		fees.get(1).click();
		Thread.sleep(2000);
		allFilters.click();
		int k=rd.nextInt(avail.size());
		avail.get(k).click();
	}
	public void selectSort() throws InterruptedException {
		Thread.sleep(1000);
		sort.click();
		Random rd= new Random();
		int i=rd.nextInt(sort_list.size());
		sort_list.get(1).click();
		Thread.sleep(1500);
	}
	public void switchNextWindow() {
		Set<String> winIds= driver.getWindowHandles();
		List<String>winIds_list= new ArrayList<String>(winIds);
		driver.switchTo().window(winIds_list.get(1));
	}
	public void switchDefaultWindow() {
		Set<String> winIds= driver.getWindowHandles();
		List<String>winIds_list= new ArrayList<String>(winIds);
		driver.switchTo().window(winIds_list.get(0));
	}
	
	public void doctorDetails() throws InterruptedException
	{
		
		for(int i=0;i<5;i++)
		{  
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(doctors_list.get(i)));
			js.executeScript("arguments[0].scrollIntoView();",doctors_list.get(i));
			System.out.println(doctors_list.get(i).getText());
			String s=doctors_list.get(i).getText();
			XSSFRow k=ExcelUtilities.createRow(i+1);
			ExcelUtilities.setData(k, 0, s );
			//doctors_list.get(i).click();
			js.executeScript("arguments[0].click();",doctors_list.get(i));
			switchNextWindow();
			String details= driver.findElement(By.xpath("//div[@class='c-profile--qualification']")).getText();
			System.out.println(details);
			ExcelUtilities.setData(k, 1, details );
			System.out.println("******************************");
			driver.close();
			switchDefaultWindow();
		}
		
	}
	
	

}
