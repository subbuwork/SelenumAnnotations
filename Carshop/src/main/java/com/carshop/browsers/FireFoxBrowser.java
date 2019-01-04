/**
 * Author: subbu
   Date:Oct 26, 2017 :::10:48:48 AM
   Project Name:Carshop
 */
package com.carshop.browsers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowser {
    
	final static Logger logger = Logger.getLogger(FireFoxBrowser.class.getName());
	private static WebDriver webDriver;
	public FireFoxBrowser() {
		logger.info("FireFoxBrowser::: Construcor...");
		
	}
	
	public static WebDriver createDriver(){
		logger.info("Inside:: createDriver method");
		System.setProperty("webdriver.gecko.driver","C:\\Python35\\geckodriver.exe");
        webDriver = new FirefoxDriver();
		return webDriver;
	}
		

}
