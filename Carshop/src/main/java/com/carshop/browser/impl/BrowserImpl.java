package com.carshop.browser.impl;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.carshop.browser.Browser;
import com.carshop.browser.factory.BrowserFactory;

public class BrowserImpl implements Browser {
    final static Logger logger = Logger.getLogger(BrowserImpl.class.getSimpleName());
    
	public BrowserImpl() {
		
	}
    
	private WebDriver webDriver;
	
	public  WebDriver createDriver(String browser_name) {
		logger.info("Inside::"+logger.getName()+"::BrowserImpl class createDriver()");
		System.out.println("Inside::"+logger.getName()+"::BrowserImpl class createDriver()");
		webDriver = new BrowserFactory().createDriver(browser_name);
		return webDriver;
	}
}
