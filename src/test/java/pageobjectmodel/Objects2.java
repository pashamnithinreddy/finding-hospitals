package pageobjectmodel;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePackage.ExcelUtilities;

public class Objects2 extends BasePage {

	public Objects2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
  @FindBy(xpath="//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
  List<WebElement> surgeries_list;
  @FindBy(xpath="//span[@class='nav-interact']")
  WebElement for_Corp;
   @FindBy(xpath="(//a[@event='Nav Provider Marketing:Interacted:Plus Corporate'])[1]")
  WebElement hwp;
   @FindBy(xpath="//h1[@data-qa-id='surgical-solution-sub-header']")
   WebElement location;
   
   public void getsurgeries_list(){
	  
	   for(int i=0;i<surgeries_list.size();i++)
	   {
		  String types= surgeries_list.get(i).getText();
		   System.out.println(types);
		  XSSFRow k1= ExcelUtilities.createRow(i+7);
		  ExcelUtilities.setData(k1, 0, types);
	   }
	   
   }
   public void click_forCorp()
   {
	   for_Corp.click();
	   hwp.click();
   }
   public void scrollDown() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(location));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",location);
		
	}
   public void scrollUp() {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",for_Corp);
		
	}
   public static String screenshot(WebDriver driver,String filename) throws IOException
   {

 TakesScreenshot ts= (TakesScreenshot)driver;
  File src=ts.getScreenshotAs(OutputType.FILE);
  File trg=new File("C:\\Users\\2303767\\eclipse-workspaceeclipse\\Hackathon 2.zip_expanded\\Hackathon\\Cucumber-screenshots\\"+filename+".png");
  FileUtils.copyFile(src,trg);
  return trg.getAbsolutePath();
   

 }
 
}
