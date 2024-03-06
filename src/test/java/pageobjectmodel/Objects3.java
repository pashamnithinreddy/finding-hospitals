package pageobjectmodel;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Objects3 extends BasePage{

	public Objects3(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="(//input[@name='name'])[1]")
	public WebElement name;
	@FindBy(xpath="(//input[@id='organizationName'])[1]")
	public WebElement org_name;
	@FindBy(xpath="(//input[@id='contactNumber'])[1]")
	public WebElement contact_num;
	@FindBy(xpath="(//input[@id='officialEmailId'])[1]")
	public WebElement email;
	@FindBy(xpath="(//select[@id='organizationSize'])[1]")
	public WebElement org_size;
	@FindBy(xpath="(//select[@id='interestedIn'])[1]")
	public WebElement interest;
	@FindBy(xpath="(//button[text()='Schedule a demo'])[1]")
	public WebElement button ;
	@FindBy(xpath="(//div[@class='u-text--bold text-alpha'])[1]")
	public WebElement thankyou;
	public void select_org_size() {
		Select sel= new Select(org_size);
		sel.selectByValue("1001-5000");
	}
	public void select_interest() {
		Select sel= new Select(interest);
		sel.selectByValue("Taking a demo");
	}
	public boolean thankyoumsg() {
		if(thankyou.isDisplayed())
		{
			return true;
		}
		else
			return false;
	}
	public void sendname(String a) {
		
		name.sendKeys(a);
	}
public void sendorgname(String b) {
		
	org_name.sendKeys(b);
	}
public void sendno(String c) {
	
	contact_num.sendKeys(c);
}
public void sendemail(String d) {
	
	email.sendKeys(d);
}
public void clickButton() {
	
	button.click();
 }
}
