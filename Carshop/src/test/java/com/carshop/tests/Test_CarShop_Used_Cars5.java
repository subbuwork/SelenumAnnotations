
package com.carshop.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.carshop.browser.Browser;
import com.carshop.browser.impl.BrowserImpl;
import com.carshop.input.InputData;
import com.carshop.pom.UsedCarsPage;
import com.carshop.utils.ExcelUtils;
import com.carshop.utils.PropertyReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author subbu
 *
 */
public class Test_CarShop_Used_Cars5 {
	
	final static Logger logger = Logger.getLogger(Test_CarShop_Used_Cars5.class.getSimpleName());
	
	//Creating ExtentReport and ExtentTest  reference values
	ExtentReports report;
	ExtentTest test;
	
	WebDriver webDriver;
	Browser browser;
	PropertyReader propsReader;
	String BASE_URL;
	StopWatch watch;
	String file_path = "D:\\development\\ClientProjects\\UK\\Carshop\\reports\\";
	UsedCarsPage usedCars;
	ExcelUtils excelFile;
	InputData input;
	
	@BeforeSuite
	@Parameters("browser_name")
	public void setUp(String browser_name){
		logger.info("Browser Name::"+browser_name);
		propsReader = new PropertyReader("EnvConfig.properties");
		excelFile = new ExcelUtils("testdata_results.xlsx");
		input = excelFile.readData();
		BASE_URL  =  propsReader.getProperty("BASE_URL");
		browser = new BrowserImpl();
		logger.info("URL:::"+BASE_URL);
		webDriver =  browser.createDriver(browser_name);
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void tearDown(){
		logger.info("::::::Quiting Browser:::::::::");
	   // webDriver.quit();
		
	}
	
	@BeforeTest
	public void setupReport(){
		System.out.println("Before test...");
		report = new ExtentReports(file_path+"TestReport.html");
	}
	
	@AfterMethod
    public void getResult(ITestResult result)
    {
		System.out.println("Debug....");
        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL, result.getThrowable());
             
        }
        report.endTest(test);
    }
	
	@AfterTest
    public void endreport()
    {
		System.out.println("After test.....");
        report.flush();
        //report.close();
    }
	
	 
	
	@Test
	public void test_01_used_cars() throws Exception{
		test = report.startTest("test_01_used_cars");
		test.log(LogStatus.INFO, "test_01_used_cars");
		
		List<String> makes = new ArrayList<String>();
		makes.add("Honda");
		
		webDriver.get(BASE_URL+"/used-cars");
		usedCars = PageFactory.initElements(webDriver, UsedCarsPage.class);
		usedCars.accept_cookie();
		Thread.sleep(2);
		//usedCars.enter_postal_code(input.getPostCode());
		usedCars.enter_postal_code(input.getPostCode().trim());
		
		//usedCars.enter_search_key(input.getKeywordSearch());
		usedCars.enter_search_key(input.getKeywordSearch().trim());
		
		//webDriver.findElement(By.xpath("//label[@for='searchcapMakeName']")).click();
		usedCars.click_on_make();
		usedCars.select_make(input.getMakes());
		//usedCars.select_make(input.getMakes());
		//usedCars.cars_count();
		usedCars.click_model();
		Thread.sleep(5);
		usedCars.select_model(input.getModels());
		
		usedCars.click_price();
		usedCars.select_monthly_payment();
		//usedCars.click_full_price();
		
		//usedCars.click_min_price();
		usedCars.click_min_payment();
		
		usedCars.select_monthly_min_payment_option_from_drop_down(input.getPrices().get(0));
		//usedCars.select_monthly_min_payment_option_from_drop_down("£5,000");
		
		//usedCars.click_max_price();
		usedCars.click_max_payment();
		
		//usedCars.select_monthly_max_payment_option_from_drop_down("£9,000");
		usedCars.select_monthly_max_payment_option_from_drop_down(input.getPrices().get(0));
		
	    //Selecting age
		usedCars.click_age();
		usedCars.select_age(input.getAge());
		
		
		//selecting milage
		usedCars.click_milage();
		Thread.sleep(2);
		usedCars.select_milage(input.getMilage());
		
		//Select Body Type
		usedCars.click_body_type();
		Thread.sleep(2);
		usedCars.select_body_type(input.getBodyTypes());
		
		//Select Fuel Type
		usedCars.click_fuel_type();
		Thread.sleep(2);
		usedCars.select_fuel_type(input.getFuel_type());
		
		
		//Select Transmission Type
		usedCars.click_transmission_type();
		Thread.sleep(2);
		usedCars.select_transmission_type(input.getTransmisstionType());
		
		//Select Engine Type..
		usedCars.click_engine_size();
		
		usedCars.click_min_engine_size();
		Thread.sleep(2);
		usedCars.select_min_engine_size(input.getEngineSizes().get(0));
		
		
		usedCars.click_max_engine_size();
		Thread.sleep(2);
		usedCars.select_max_engine_size(input.getEngineSizes().get(1));
		
		//Select Car color
		usedCars.click_color();
		usedCars.select_car_color(input.getColors());
		
		//Click on More.
		Thread.sleep(2);
		usedCars.click_more();
		
		
		//Select Doors..
		usedCars.click_no_of_doors();
		Thread.sleep(2);
		usedCars.select_no_of_doors(input.getNoOfDoors());
		
		
		
		//Select Seats
		usedCars.click_no_of_seats();
		
		usedCars.click_min_seats();
		usedCars.select_min_no_of_seats(input.getNoOfSeats().get(0));
		
		usedCars.click_max_seats();
		Thread.sleep(2);
		usedCars.select_max_no_of_seats(input.getNoOfSeats().get(1));
		
		//Select Annual Tax..
		usedCars.click_annual_tax();
		Thread.sleep(2);
		usedCars.select_annual_tax(input.getAnnualTax());
		
		//Fuel Economy
		
		usedCars.click_fuel_economy();
		Thread.sleep(2);
		usedCars.select_fuel_economy(input.getFuelEconomy());
		
		//Co2 Emission
		
		usedCars.click_co2_emission();
		usedCars.select_co2_emissiony(input.getCo2Emission());
		
	
		//Power (BHP)
		usedCars.click_power_bhp();
		usedCars.select_power_bhp(input.getPowser());
	
		// Features..
		//List<String> fList = new ArrayList<String>();
		//fList.add("Air Conditioning");
		//fList.add("Bluetooth");
		usedCars.click_features();
		usedCars.select_features(input.getFeatures());
		
			
		//Store
		usedCars.click_store();
		//List<String> sList = new ArrayList<String>();
		//sList.add("Swindon");
		//sList.add("Norwich");
		
		usedCars.select_store(input.getStores());
		
		usedCars.click_done();
		
		//Pass the test in report
		test.log(LogStatus.PASS, "Test Verified");
		
		
		
		
	}


}
