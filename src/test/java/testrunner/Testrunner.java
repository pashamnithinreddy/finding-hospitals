package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { ".//Featurefiles/Adoctorslist.feature", ".//Featurefiles/Bsurgerieslist.feature",
		".//Featurefiles/Cfillingform.feature" }, 
				glue = "stepdefinitions",
				plugin= {"pretty", "html:c_reports/myreport.html", 
						  "rerun:target/rerun.txt",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				         })

public class Testrunner {

}
