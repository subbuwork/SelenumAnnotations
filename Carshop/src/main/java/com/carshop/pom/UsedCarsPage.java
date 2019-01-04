package com.carshop.pom;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.carshop.utils.PropertyReader;
import com.carshop.utils.ExcelUtils;
import com.carshop.utils.TimeElapsed;

public class UsedCarsPage {
	
	static final Logger logger = Logger.getLogger(UsedCarsPage.class.getSimpleName());
	
	WebDriver driver;
	PropertyReader propsReader;
	TimeElapsed timeElapsed;
	ExcelUtils excelFile;
	
	public UsedCarsPage(WebDriver webDriver){
		this.driver = webDriver;
		propsReader = new PropertyReader("WebElementLocators.properties");
		timeElapsed = new TimeElapsed();
		excelFile = new ExcelUtils("testdata_results.xlsx");
	}
	
	@FindBy(how = How.XPATH,using="//div[@class='u-h4']/span/strong")
	WebElement cars_count;
	
	@FindBy(how = How.ID, using = "btnCookieConsent")
	WebElement accept_cookie;
	
	@FindBy(how = How.NAME,using= "postcode")
	WebElement post_code;
	
	@FindBy(how = How.NAME, using = "freeText")
	WebElement key_search;
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchcapMakeName']")
	WebElement make;
	
	@FindBy(how = How.ID, using = "makesTop")
	WebElement go_to_botton;
	
	@FindBy(how = How.ID, using = "makesBottom")
	WebElement go_to_top;
	
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='MakesList']/label")})
	List<WebElement> makesList;
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchmodel']")
	WebElement modellabel;
	
	
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchprice']")
	WebElement priceLabel;
	
	@FindBy(how = How.XPATH,using="//div[@class='o-collapse__panel u-p']/div/div[1]")
	WebElement monthly_payment;
	
	@FindBy(how = How.XPATH, using ="//div[@class='o-collapse__panel u-p']/div/div[2]")
	WebElement full_payment;
	
	@FindBy(how = How.XPATH,using="//label[@for='minPayment']")
	WebElement min_payment;
	
	@FindBy(how = How.XPATH,using="//label[@for='maxPayment']")
	WebElement max_payment;
	
	@FindBy(how = How.XPATH, using = "//label[@for='minPrice']")
	WebElement min_price;

	@FindBy(how = How.XPATH, using = "//label[@for='maxPrice']")
	WebElement max_price;
	
	@FindAll({@FindBy(how = How.XPATH, using="//div[@class = 'o-collapse__panel u-scroll-lg u-b']/label")})
	List<WebElement> payments_list;
	
	List<String> makes_input;
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchmaxAge']")
	WebElement click_age;
	
	@FindAll({@FindBy(how = How.XPATH, using="//div[@id='AgeList']/label")})
	List<WebElement> ageList;
	
	
	@FindBy(how = How.XPATH, using="//label[@for='searchtoMileage']")
	WebElement milagelabel;
	
	@FindAll({@FindBy(how = How.XPATH, using="//div[@id='MileageList']/label")})
	List<WebElement> milageList;
	
	@FindBy(how = How.XPATH, using="//label[@for='searchbodyStyles']")
	WebElement bodyType;
	
	
	@FindAll({@FindBy(how = How.XPATH, using="//div[@id='Body TypeList']/label")})
	List<WebElement> bodyTypeList;
	
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchfuel']")
	WebElement fuelLabel;
	
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='Fuel TypeList']/label")})
	List<WebElement> fuelTypeList;

	
	@FindBy(how = How.XPATH, using = "//label[@for='searchtransmission']")
	WebElement transmissionType;
	
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='TransmissionList']/label")})
	List<WebElement> transmissionsTypeList;
	
	
	@FindBy(how = How.XPATH, using="//label[@for='searchengineSize']")
	WebElement engingelabel;
	
	@FindBy(how = How.XPATH, using = "//label[@for='fromEngine']")
	WebElement minEngineSize;
	
	@FindBy(how = How.XPATH, using = "//label[@for='toEngine']")
	WebElement maxEngineSize;
	
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@class='c-form-group']/label")})
	List<WebElement> engineSizeList;
	
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchcolour']")
	WebElement carColorLabel;
	
	
	@FindAll({@FindBy(how = How.XPATH, using = "//div[@id='ColourList']/label")})
	List<WebElement> colorsList;
	
	@FindBy(how = How.XPATH, using = "//label[@for='moreSearchOptions']")
	WebElement moreOpetions;
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchselectedDoors']")
	WebElement noOfDoors;
	
	
	@FindAll({@FindBy(how = How.XPATH, using= "//div[@id='No. of DoorsList']/label")})
	List<WebElement> doorsList;
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchseats']")
	WebElement noOfSeats;
	
	@FindBy(how = How.XPATH, using = "//label[@for='minSeats']")
	WebElement minSeats;
	
	@FindBy(how = How.XPATH, using = "//label[@for='maxSeats']")
	WebElement maxSeats;
	
	@FindAll({@FindBy(how = How.XPATH, using= "//div[@class='o-collapse u-mb ng-scope']/div/label")})
	List<WebElement> seatsList;
	
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchmaxYearlyTax']")
	WebElement yearsTaxLabel;
	
	@FindAll({@FindBy(how = How.XPATH, using= "//div[@id='Annual TaxList']/label")})
	List<WebElement> taxList;
	
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchminMpg']")
	WebElement fuelEconomy;
	
	@FindAll({@FindBy(how = How.XPATH, using= "//div[@id='Fuel EconomyList']/label")})
	List<WebElement> fuelList;
	
	
	@FindBy(how = How.XPATH, using="//label[@for='searchmaxCarbonEmission']")
	WebElement co2EmissionLabel;
	
	@FindAll({@FindBy(how = How.XPATH, using= "//div[@id='CO<sub>2</sub> EmissionsList']/label")})
	List<WebElement> co2EmissionList;
	
	
	@FindBy(how = How.XPATH, using="//label[@for='searchminEnginePower']")
	WebElement powerBHPLabel;
	
	@FindAll({@FindBy(how = How.XPATH, using= "//div[@id='Power (BHP)List']/label")})
	List<WebElement> powerBHPList;
	
	
	@FindBy(how = How.XPATH, using ="//label[@for='searchtopFeatures']")
	WebElement featureLabel;
	
	
	@FindAll({@FindBy(how = How.XPATH, using= "//div[@id='FeaturesList']/label")})
	List<WebElement> featuresList;
	
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchstore']")
	WebElement storeLabel;
	
	@FindAll({@FindBy(how = How.XPATH, using= "//div[@id='StoreList']/label")})
	List<WebElement> storesList;
	
	
	@FindBy(how = How.XPATH, using = "//label[@for='searchoptions']")
	WebElement moreOptionsLabel;
	
	@FindAll({@FindBy(how = How.XPATH, using= "//div[@id='StoreList']/label")})
	List<WebElement> moreOptionsList;
	
	@FindBy(how = How.XPATH, using="//label[@for='moreSearchOptions']")
	WebElement showLess;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='u-bg-white u-p u-clearfix']/div[1]/button")
	WebElement reset;
	
	@FindBy(how = How.XPATH, using = "//button[@scroll-to='top']")
	WebElement done;
	
	
	
	public void accept_cookie(){
		accept_cookie.click();
	}
	
	public void cars_count_and_time_elapsed(Integer step_num,Long loadingTime){
		 String count = cars_count.getText();
		 logger.info("Cars Count:::"+count+"::Step Num::"+step_num);
		 excelFile.writeData(count,step_num,loadingTime);
	}
	
	public void auction_not_available(Integer step_num,String item_Name){
		logger.info("...Auction not avaiable....");
		excelFile.writeData(step_num,item_Name);
	}
	
	
	public void enter_postal_code(String postal_code){
		logger.info("Entering :::"+postal_code);
		this.timeElapsed.start_time();
		post_code.sendKeys(postal_code);
		Long time = timeElapsed.end_time();
		this.cars_count_and_time_elapsed(1,time);
	}
	
	public void enter_search_key(String search_key){
		logger.info("Entering::::"+search_key);
		this.timeElapsed.start_time();
		key_search.sendKeys(search_key);
		Long time = timeElapsed.end_time();
		this.cars_count_and_time_elapsed(2,time);
	}
	
	public void click_on_make(){
		logger.info("Clicking On Make::");
		make.click();
	}
	
	public void go_to_botton(){
		logger.info("Go To Botton::::");
		go_to_botton.click();
	}
	
	public void go_to_top(){
		logger.info("Go To Top:::::");
		go_to_top.click();
	}
	
	public void select_make(List<String> input_makes){
		logger.info("Select Make:::"+input_makes.toString());
		makes_input = input_makes;
		for(String make : input_makes){
				
            logger.info("For Loop 1:::::"+make);
			for(WebElement element: makesList){
				logger.info("For Loop 2::::::"+element.getText());
				if(element.getText().trim().startsWith(make.toUpperCase())){
					//if(element.isEnabled()){
						logger.info("Element Enabled...."+element.getText());
						if(element.getText().trim().startsWith("LAND ROVER") ||element.getText().trim().startsWith("MG MOTOR UK")){
							logger.info("LAND ROVER OR MG MOTOR UK ::::::::::::");
							if(element.getText().trim().startsWith("LAND ROVER")){
								try{
								WebElement ele = driver.findElement(By.xpath(propsReader.getProperty("LAND_ROVER")));
								Actions actions = new Actions(driver);
								timeElapsed.start_time();
								actions.moveToElement(ele).click().perform();
								Long time = timeElapsed.end_time();
								this.cars_count_and_time_elapsed(3,time);
								
								break;
								}catch(Exception e){
									logger.info("Item not available for auction.........Selecting defualt......");
									this.auction_not_available(3,element.getText());
									e.printStackTrace();
								}
							}else{
								WebElement ele=null;
								try{
								ele = driver.findElement(By.xpath(propsReader.getProperty("MG_MOTOR_UK")));
								Actions actions = new Actions(driver);
								timeElapsed.start_time();
								actions.moveToElement(ele).click().perform();
								Long time = timeElapsed.end_time();
								this.cars_count_and_time_elapsed(3,time);
								
								break;
								}catch (Exception e) {
                                  logger.info("Item not available for auction.........Selecting defualt......");
                                  this.auction_not_available(3,ele.getText());
                                  e.printStackTrace();
								
								}
							}
							
						}else{
					    logger.info("Make:::"+make.toString());
					    WebElement ele=null;
					    try{
						ele = driver.findElement(By.xpath(propsReader.getProperty(make.toUpperCase().trim())));
						timeElapsed.start_time();
						//this.doubleClick(driver, ele);
						ele.click();
						Long time = timeElapsed.end_time();
						this.cars_count_and_time_elapsed(3,time);
					    
						break;
					    }catch (Exception e) {

					         logger.info("Item not available for auction.........Selecting defualt......");
					         this.auction_not_available(3,ele.getText());
					         e.printStackTrace();
					    
					    }
						}
				}
				
			}
			
		}
			
	}
	
	
	public void click_model(){
		logger.info("Select Model:::::");
		modellabel.click();
	}
	
	
public void select_model(List<String> models){
		logger.info("Select model........."+models.toString());
		
	for(String make: makes_input){
		logger.info("Retreving Model for ::"+make);
		String model_xpath1 ="//SPAN[@class='ng-binding'][text()='"+make.toUpperCase().trim()+"'";
		String models_xpath = model_xpath1+propsReader.getProperty("MODELS_XPATH2").trim();
		logger.info("Final Model xpath:::"+models_xpath);
		List<WebElement> model_elements = driver.findElements(By.xpath(models_xpath));
		for(String model:models){
			logger.info("Model From Input........."+model);
			for(WebElement element: model_elements){
				logger.info("Model From List......................"+element.getText());
				if(element.getText().trim().startsWith(model.trim())){
					logger.info("...Model found in the List.....");
					try{
						timeElapsed.start_time();
						element.click();
						//this.doubleClick(driver,element);
						//Thread.sleep(2);
						
						Long time = timeElapsed.end_time();
						this.cars_count_and_time_elapsed(4,time);
						break;
					}catch (Exception e) {
					logger.info(".........Auction not avaiable....");
					this.auction_not_available(4,element.getText());
					e.printStackTrace();
				}
			}
		  }
		}
	}
}
	
	
public void click_price(){
	logger.info("Clickign on price label..");
	priceLabel.click();
}


public void select_monthly_payment(){
	logger.info("Selecting monthly payment....");
	monthly_payment.click();
}

public void click_min_payment(){
	logger.info("Selecting Min Payment....");
	min_payment.click();
	
}

public void click_max_payment(){
	logger.info("Selecting Max Payment....");
	max_payment.click();
	
}

public void select_monthly_min_payment_option_from_drop_down(String payment_option){
	
	logger.info("..Monthly Minimum payment from input..."+payment_option);
	for(WebElement webelement:payments_list){
		logger.info("Min Option from List::"+webelement.getText());
		if(webelement.getText().startsWith(payment_option)){
			logger.info("...Min payment found in the list.....");
			try{
			timeElapsed.start_time();
			webelement.click();
			Long time = timeElapsed.end_time();
			this.cars_count_and_time_elapsed(5, time);
			break;
			}catch (Exception e) {
              logger.info("...Auction Not avaiable....");
              this.auction_not_available(5,webelement.getText());
			}
		}else{
			logger.info(webelement.getText()+":::Element not matched with..."+payment_option);
		}
		
	}
	
}

public void select_monthly_max_payment_option_from_drop_down(String payment_option){
	
	logger.info("Select Monthly Max payment..."+payment_option);
	for(WebElement webelement:payments_list){
		logger.info("Max Option from List::"+webelement.getText());
		if(webelement.getText().startsWith(payment_option)){
			logger.info(".........Max payment found in the list.....");
			try{
			timeElapsed.start_time();
			webelement.click();
			Long time = timeElapsed.end_time();
			this.cars_count_and_time_elapsed(5,time);
			break;
			}catch (Exception e) {
				logger.info("..Auction not avaiable.....");
                this.auction_not_available(5, webelement.getText());   
			}
		}else{
			logger.info("Element not found........"+payment_option);
		}
		
	}
	
}

public void click_full_price(){
	logger.info("Clicking Full Price..");
	full_payment.click();
}


public void click_min_price(){
	logger.info("Clicking Min price...");
	min_price.click();
}

public void click_max_price(){
	logger.info("Clicking Max price...");
	max_price.click();
}


public void click_age(){
	logger.info("Click Age...");
	click_age.click();
}

public void select_age(String age){
	logger.info("..age from input::"+age);	
	for(WebElement element:ageList){
		logger.info("Age from list::"+element.getText().toString());
		
			logger.info("Element  enabled......"+element.getText());
			if(element.getText().trim().startsWith(age.trim())){
				logger.info(".....Selecting  age from list..."+age+"::"+element.getText().toString());
				try{
				timeElapsed.start_time();
				element.click();
				Long time = timeElapsed.end_time();
				this.cars_count_and_time_elapsed(6, time);
				break;
				}catch (Exception e) {
					logger.info("Item not available for auction..... Leaving as default....");
					this.auction_not_available(5,element.getText());
				}
			}else {
				System.out.println("Element not matched..");
			}
	}
}

public void click_milage(){
	logger.info("Clicking Milage.....");
	milagelabel.click();
}

public void select_milage(String milage){
	logger.info("Milage from input::"+milage);
	for(WebElement element: milageList){
		logger.info("Milage from list::"+element.getText());
		if(element.getText().trim().startsWith(milage.trim())){
			logger.info("...........Milage found in the List...");
				try{
				timeElapsed.start_time();
				element.click();
				Long time = timeElapsed.end_time();
				this.cars_count_and_time_elapsed(7,time);
				break;
				}catch (Exception e) {
                   logger.info(".....Auction Not Available....");
                   this.auction_not_available(7,element.getText());
				}
			}else{
				logger.info("Element not matched......");
			}
	}
}


public void click_body_type(){
	logger.info("Clicking Body Type.....");
	bodyType.click();
}

public void select_body_type(List<String> bodyTypes){
	logger.info("Body Type from input::"+bodyType);
	for(String bodyType:bodyTypes){
			for(WebElement element: bodyTypeList){
			logger.info(".........Body Type from list::"+element.getText());
							
			 if(element.getText().trim().startsWith(bodyType.trim())){
				 logger.info("....Brody type found in the list.....");
						try{
							    timeElapsed.start_time();
								element.click();
								Long time = timeElapsed.end_time();
								this.cars_count_and_time_elapsed(8, time);
								break;
						}catch (Exception e) {
							logger.info("Itme not available for auction........selecting default.....");
							this.auction_not_available(8,element.getText());
						}
						
					}else{
						logger.info("Element not matched......");
					}
			}
	}
}

public void click_fuel_type(){
	logger.info("Clicking Fuel Type.....");
	fuelLabel.click();
}

public void select_fuel_type(String fuelType){
	logger.info("Fuel Type from input::"+fuelType);
	
	for(WebElement element: fuelTypeList){
	logger.info("Fuel type from list::"+element.getText());
		if(element.getText().trim().startsWith(fuelType.trim())){
			logger.info("..Fuel found in the list.....");
				try{
					timeElapsed.start_time();
					element.click();
					Long time = timeElapsed.end_time();
					this.cars_count_and_time_elapsed(9, time);
					break;
				}catch (Exception e) {
					logger.info("...Auction Not avaiable.......");
					this.auction_not_available(9,element.getText());
				}
		}else{
			logger.info(".........Element not matched.......");
		}
	}
	
}

public void click_transmission_type(){
	logger.info("Clicking Transmission Type.....");
	transmissionType.click();
}

public void select_transmission_type(String transmissionType){
	logger.info("Transmission Type from input::"+transmissionType);
	for(WebElement element: transmissionsTypeList){
		logger.info("Transmission type from list::"+element.getText());			
			if(element.getText().trim().startsWith(transmissionType.trim())){
			logger.info("....Transmission found in the list.....");	
					try{
						timeElapsed.start_time();
						element.click();
						Long time = timeElapsed.end_time();
						this.cars_count_and_time_elapsed(10,time);
						break;
					}catch(Exception ex){
						logger.info("......Auction Not available.......");
						this.auction_not_available(10,element.getText());
					}
			}else{
				logger.info("Element not matched......");
			}
	}
}


public void click_engine_size(){
	logger.info("Clicking Engine Size.....");
	engingelabel.click();
}

public void click_min_engine_size(){
	logger.info("Clicking Min Engine Size.....");
	minEngineSize.click();
}

public void click_max_engine_size(){
	logger.info("Clicking Max Engine Size.....");
	maxEngineSize.click();
}

public void select_min_engine_size(String min_engineSize){
	logger.info("Min Engine Size from input::"+min_engineSize);
	
	for(WebElement element: engineSizeList){
		
		logger.info("Min Engine size from list::"+element.getText());
			
			if(element.getText().trim().startsWith(min_engineSize.trim())){
				try{
					timeElapsed.start_time();
					element.click();
					Long time = timeElapsed.end_time();
					this.cars_count_and_time_elapsed(11, time);
					break;
				}catch (Exception e) {
					logger.info("Itme not available for auction........selecting default.....");
					this.auction_not_available(11,element.getText());
				}
				
			}else{
				logger.info("Element not matched......");
			}
	}
	
}

public void select_max_engine_size(String max_engineSize){
	logger.info("Max Engine Size from input::"+max_engineSize);
	
	for(WebElement element: engineSizeList){
		
		logger.info("Max Engine size from list::"+element.getText());			
			if(element.getText().trim().startsWith(max_engineSize.trim())){
				try{
					    timeElapsed.start_time();
						element.click();
						Long time = timeElapsed.end_time();
						this.cars_count_and_time_elapsed(11,time);;
						break;
				}catch(Exception ex){
					logger.info("=============Item not available for auction==========");
					this.auction_not_available(11,element.getText());
				}
			}else{
				logger.info("Element not matched......");
			}
	}
}


public void click_color(){
	logger.info("Clicking Color......");
	carColorLabel.click();
}


public void select_car_color(List<String> car_colors){
	logger.info("Car Color from input:::"+car_colors);
	for(String color: car_colors){
			for(WebElement element: colorsList){
				logger.info("Color from List::"+element.getText());
				if(element.getText().trim().startsWith(color.trim())){
					try{
						logger.info("...Elements matched...."+color+"::"+element.getText());
						timeElapsed.start_time();
						//this.doubleClick(driver,element);
						element.click();
						Long time = timeElapsed.end_time();
						this.cars_count_and_time_elapsed(12,time);
						break;
					}catch (Exception e) {
						logger.info("Item not available for auction.....");
						this.auction_not_available(12,element.getText());
						//break;
					}
				}else{
					logger.info("Element not matched....");
				}
			}
	}
}

public void doubleClick(WebDriver driver,WebElement webElement){
	logger.info("Double Click........."+webElement.getText().toString());
	try{
	Actions actions = new Actions(driver);
	Thread.sleep(2);
	actions.moveToElement(webElement).doubleClick().build().perform();
	}catch (Exception e) {
       e.printStackTrace();
	}
}


public void click_more(){
	logger.info("Clicking More.....");
	moreOpetions.click();
}


public void click_no_of_doors(){
	logger.info("Click No Of Doors......");
	noOfDoors.click();
}


public void select_no_of_doors(String no_of_doors){
	logger.info("No Of Doors from input:::"+no_of_doors);
	for(WebElement element:doorsList){
		try{
			if(element.getText().trim().startsWith(no_of_doors.trim())){
				logger.info("Element matched...");
				timeElapsed.start_time();
				element.click();
				Long time = timeElapsed.end_time();
				this.cars_count_and_time_elapsed(13, time);
				break;
			}else{
				logger.info("Element not matched....");
			}
		}catch (Exception e) {
			logger.info("Item not avaiable for auciton.....");
            this.auction_not_available(13,element.getText());
		}
		
	}
	
	
}

public void click_no_of_seats(){
	logger.info("Click No Of Seats......");
	noOfSeats.click();
}


public void click_min_seats(){
	logger.info("Click Min seats.....");
	minSeats.click();
}

public void click_max_seats(){
	logger.info("Click Max seats.....");
	maxSeats.click();
}

public void select_min_no_of_seats(String no_of_seats){
	logger.info("Min No Of Seats from input:::"+no_of_seats);
	
	for(WebElement element:seatsList){
		try{
			if(element.getText().trim().startsWith(no_of_seats.trim())){
				logger.info("Element matched...");
				timeElapsed.start_time();
				element.click();
				Long time = timeElapsed.end_time();
				this.cars_count_and_time_elapsed(14, time);
				break;
			}else{
				logger.info("Element not matched....");
			}
		}catch (Exception e) {
			logger.info("Item not avaiable for auciton.....");
			this.auction_not_available(14,element.getText());
		}
	}
	
}

public void select_max_no_of_seats(String no_of_seats){
	logger.info("Max No Of Seats from input:::"+no_of_seats);
	for(WebElement element:seatsList){
			if(element.getText().trim().startsWith(no_of_seats.trim())){
				logger.info("Element matched...");
				try{
					timeElapsed.start_time();
					element.click();
					Long time = timeElapsed.end_time();
					this.cars_count_and_time_elapsed(14,time);
					break;
				}catch (Exception e) {
                  logger.info("Item not available for auction.......");
                  this.auction_not_available(14,element.getText());
				}
			}else{
				logger.info("Element not matched....");
			}
	}
	
}


public void click_annual_tax(){
	logger.info("Clicking  Annual Tax........");
	yearsTaxLabel.click();
}


public void select_annual_tax(String tax){
	logger.info("Tax from input:::"+tax);
	
	for(WebElement element: taxList){
		logger.info("tax from list:::"+element.getText());
		if(element.getText().trim().startsWith(tax.trim())){
			logger.info(".....Elements matched....");
			try {
				timeElapsed.start_time();
				element.click();
				Long time = timeElapsed.end_time();
				this.cars_count_and_time_elapsed(15,time);
				break;
			} catch (Exception e) {
				logger.info("..............Item not available for auction............");
				this.auction_not_available(15,element.getText());
			}
		}else{
			logger.info("Element not matched......");
		}
				
	}	
}


public void click_fuel_economy(){
	logger.info("Clicking  Fuel Economy........");
	fuelEconomy.click();
}


public void select_fuel_economy(String fueltype){
	logger.info("Fuel economy from input:::"+fueltype);
	
	for(WebElement element: fuelList){
		logger.info("Fuel economy from list:::"+element.getText());
		if(element.getText().trim().startsWith(fueltype.trim())){
			logger.info(".....Elements matched....");
			try {
				timeElapsed.start_time();
				element.click();
				Long time = timeElapsed.end_time();
				this.cars_count_and_time_elapsed(16,time);
				break;
			} catch (Exception e) {
				logger.info("..............Item not available for auction............");
				this.auction_not_available(16,element.getText());
			}
		}else{
			logger.info("Element not matched......");
		}
				
	}
}
	
	
	
public void click_co2_emission(){
		logger.info("Clicking  CO2 Emission........");
		co2EmissionLabel.click();
	}


public void select_co2_emissiony(String co2Emission){
		logger.info("Co2 Emission from input:::"+co2Emission);
		
		for(WebElement element: co2EmissionList){
			logger.info("Fuel economy from list:::"+element.getText());
			if(element.getText().trim().startsWith(co2Emission.trim())){
				logger.info(".....Elements matched....");
				try {
					timeElapsed.start_time();
					element.click();
					Long time = timeElapsed.end_time();
					this.cars_count_and_time_elapsed(17,time);
					break;
				} catch (Exception e) {
					logger.info("..............Item not available for auction............");
					this.auction_not_available(17,element.getText());
				}
			}else{
				logger.info("Element not matched......");
			}
					
		}		
	
	
}



public void click_power_bhp(){
	logger.info("Clicking  powerbhp........");
	powerBHPLabel.click();
}


public void select_power_bhp(String powerbhp){
	logger.info("power bhp from input:::"+powerbhp);
	
	for(WebElement element: powerBHPList){
		logger.info("Power BHP from list:::"+element.getText());
		if(element.getText().trim().startsWith(powerbhp.trim())){
			logger.info(".....Elements matched....");
			try {
				timeElapsed.start_time();
				element.click();
				Long time = timeElapsed.end_time();
				this.cars_count_and_time_elapsed(18,time);
				break;
			} catch (Exception e) {
				logger.info("..............Item not available for auction............");
				this.auction_not_available(18,element.getText());
			}
		}else{
			logger.info("Element not matched......");
		}
				
	}		


}



public void click_features(){
	logger.info("Clicking  Features........");
	featureLabel.click();
}


public void select_features(List<String> flist){
	logger.info("Features from input:::"+flist);
	
	for(String feature :flist){
	
	for(WebElement element: featuresList){
		logger.info("Feature from list:::"+element.getText());
		if(element.getText().trim().startsWith(feature.trim())){
			logger.info(".....Elements matched....");
			try {
				timeElapsed.start_time();
				element.click();
				Long time = timeElapsed.end_time();
				this.cars_count_and_time_elapsed(19,time);
				break;
			} catch (Exception e) {
				logger.info("..............Item not available for auction............");
				this.auction_not_available(19,element.getText());
			}
		}else{
			logger.info("Element not matched......");
		}
				
	}	
	}


}

public void click_store(){
	logger.info("Clicking  Store........");
	storeLabel.click();
}

public void select_store(List<String> slist){
	logger.info("Stores from input:::"+slist);
	
	for(String store :slist){
	
	for(WebElement element: storesList){
		logger.info("Store from list:::"+element.getText());
		if(element.getText().trim().startsWith(store.trim())){
			logger.info(".....Elements matched....");
			try {
				timeElapsed.start_time();
				//this.doubleClick(driver, element);
				element.click();
				Long time = timeElapsed.end_time();
				this.cars_count_and_time_elapsed(20,time);
				break;
			} catch (Exception e) {
				logger.info("..............Item not available for auction............");
				this.auction_not_available(20, element.getText());
			}
		}else{
			logger.info("Element not matched......");
		}
				
	}	
	}


}

public void click_showless(){
	logger.info("Clicking show less....");
	showLess.click();
}

public void click_reset(){
	logger.info("Clicking reset.......");
	reset.click();
}

public void click_done(){
	logger.info("Clicking done....");
	done.click();
}


}
