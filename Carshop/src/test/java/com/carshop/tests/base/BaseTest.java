package com.carshop.tests.base;



import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class BaseTest {
	
	final static Logger log = Logger.getLogger(BaseTest.class.getSimpleName());

		ExtentReports report;
		ExtentTest test;
		
	@BeforeTest
	public void setReport(String test_name){
		
		report = new ExtentReports("D:\\development\\ClientProjects\\UKClients\\Carshop\\reports\\TestReport.html");
		test = report.startTest(test_name);
	}
	
	@AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL, result.getThrowable());
           report.endTest(test);
        }
        
    }
	
	
	 @AfterTest
	 public void endreport()
	    {
	      report.flush();
	      report.close();
	    }
}
