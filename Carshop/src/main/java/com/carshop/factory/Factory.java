package com.carshop.factory;

import org.openqa.selenium.WebDriver;

public abstract class Factory {
   
	public abstract WebDriver createDriver(String browser_name);
	
	
}
