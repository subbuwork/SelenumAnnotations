/**
 * Author: subbu
   Date:Oct 26, 2017 :::10:48:48 AM
   Project Name:Carshop
 */
package com.carshop.browsers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {
    
	final static Logger logger = Logger.getLogger(ChromeBrowser.class.getSimpleName());
	private static WebDriver webDriver;
	public ChromeBrowser() {
		logger.info("ChromeBrowser::: Construcor...");
		
	}
	
	public static WebDriver createDriver(){
		logger.info("Inside:: createDriver method");
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
		return webDriver;
	}	
}
