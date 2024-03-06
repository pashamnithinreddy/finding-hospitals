package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseTest;

public class BasePage extends BaseTest{
	public static String path;
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
