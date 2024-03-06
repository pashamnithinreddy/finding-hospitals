
package BasePackage;
 
import java.io.File;
import java.io.FileReader;

import java.io.IOException;

import java.net.URL;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;

public class BaseTest {

public WebDriver driver;
public static String path;

public static Logger logger;

public Properties p;

    @Parameters({"browser","os"})

	@BeforeClass

	public void Browserlaunch(String browser,String os) throws IOException

	{


		FileReader file = new FileReader(".//src/test/resources/config.properties");

		p = new Properties();

        p.load(file);


		logger = LogManager.getLogger(this.getClass());

		if(p.getProperty("execution_environment").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabalities = new DesiredCapabilities();

			//os

			if(os.equalsIgnoreCase("windows")) {

				capabalities.setPlatform(Platform.WIN11);

			}

			else if (os.equalsIgnoreCase("mac")) {

				capabalities.setPlatform(Platform.MAC);

			}

			else {

				System.out.println("no matching os .....");

				return;

			}

			//browser

			if(browser.equalsIgnoreCase("chrome")) {

				capabalities.setBrowserName("chrome");

			}

			else if(browser.equalsIgnoreCase("edge")) {

				capabalities.setBrowserName("MicrosoftEdge");

			}

			else {

				System.out.println("no matching browser .....");

				return;

			}

			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);

		}

		else if(p.getProperty("execution_environment").equalsIgnoreCase("local")) {

			// launching browser based on condition - locally

			if(browser.equalsIgnoreCase("chrome")) {

				driver = new ChromeDriver();

				logger.info("Chrome browser opened successfully");

			}

			else if(browser.equalsIgnoreCase("edge")){

				driver = new EdgeDriver();

				logger.info("Edge browser opened successfully");

			}

			else {

				System.out.println("no matching browser......");

				logger.info("no matching browser......");

				return;

			}

		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get(p.getProperty("appUrl"));

		driver.manage().window().maximize();
		ExcelUtilities.excelInit();

	}

	@AfterClass

	public void closeBrowser() throws IOException

	{
        ExcelUtilities.closeExcel();
		driver.quit();

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
