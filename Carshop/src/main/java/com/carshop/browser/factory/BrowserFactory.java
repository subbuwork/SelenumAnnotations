
package com.carshop.browser.factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.carshop.browsers.ChromeBrowser;
import com.carshop.browsers.FireFoxBrowser;
import com.carshop.factory.Factory;

/**
 * @author Subbu
 *
 */
public class BrowserFactory extends Factory{

	final static Logger logger = Logger.getLogger(BrowserFactory.class.getSimpleName());
	private  WebDriver webDriver;
	public BrowserFactory() {
		logger.info("BrowserFactory::: Constructor....");
	}
	
	public  WebDriver createDriver(String browser_name) {
        logger.info("Browser Name::::"+browser_name);
		if (browser_name.trim().equalsIgnoreCase("chrome")){
			webDriver = ChromeBrowser.createDriver();	
		} else if(browser_name.trim().equalsIgnoreCase("firefox")){
			webDriver = FireFoxBrowser.createDriver();
		}
		return webDriver;
	}

}
