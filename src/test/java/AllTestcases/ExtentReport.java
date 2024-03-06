package AllTestcases;

import org.testng.ITestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pageobjectmodel.Objects2;

public class ExtentReport implements  ITestListener{

	
	public ExtentSparkReporter SparkReport;
	public ExtentReports EReport;
	public ExtentTest ETest;
	public void onStart(ITestContext context) {
		SparkReport=new ExtentSparkReporter(System.getProperty("user.dir")+ "/target/myReports.html");
		SparkReport.config().setDocumentTitle("Automation Reports");
		SparkReport.config().setReportName("TestNG Reports");
		SparkReport.config().setTheme(Theme.DARK);
		EReport= new ExtentReports();
		EReport.attachReporter(SparkReport);

	}
	public void onTestSuccess(ITestResult result) {
		
		String path=TestCases.path;
		ETest=EReport.createTest(result.getName()).addScreenCaptureFromPath(path,result.getName());
		ETest.log(Status.PASS, "Test Is Passed: "+ result.getName());
	}
 
	public void onTestFailure(ITestResult result) {
		ETest=EReport.createTest(result.getName());
		ETest.log(Status.FAIL, "Test Is Failed: " +result.getName());
		ETest.log(Status.FAIL,"Failed Because: "+result.getName());
	}
	public void onTestSkipped(ITestResult result) {
		ETest=EReport.createTest(result.getName());
		ETest.log(Status.SKIP," Test Skipped: "+result.getName() );
	}
	public void onFinish(ITestContext context) {
		EReport.flush();
	}

}
