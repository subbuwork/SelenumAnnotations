package com.carshop.browser;

import org.openqa.selenium.WebDriver;

public interface Browser {
	
	public  WebDriver createDriver(String browser_name);

}
