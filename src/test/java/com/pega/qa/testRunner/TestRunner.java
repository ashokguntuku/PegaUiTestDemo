package com.pega.qa.testRunner;

import java.io.File;

import org.junit.AfterClass;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;
import com.pega.qa.TestBase.TestBaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
features = {"src/test/java/com/pega/qa/featurefiles"},
glue = {"com/pega/qa/stepDefinitions"},
format={"json:target/cucumber.json","html:target/site/cucumber-pretty"},
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
tags = {"@ModifyURLsTests"},
monochrome = true,
dryRun = false

)
@Test
public class TestRunner extends AbstractTestNGCucumberTests{

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(TestBaseClass.getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
