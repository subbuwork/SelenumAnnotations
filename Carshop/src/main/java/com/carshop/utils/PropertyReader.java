package com.carshop.utils;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class PropertyReader {
	final static Logger logger = Logger.getLogger(PropertyReader.class.getSimpleName());
	
	private  String value = "";
	private  Properties props = new Properties();
	private  FileInputStream fis;
	
	private  String file_path = "D:\\development\\ClientProjects\\UK\\Carshop\\resource\\";
	private String file_name;
	
	public PropertyReader(String filename){
		this.file_name = filename;
	}
	
	public  String getProperty(String prop_name){
		logger.info("Property Key::"+prop_name);
		try {
			fis = new FileInputStream(file_path+file_name);
			
			// load a properties file
			props.load(fis);
			
			value = props.getProperty(prop_name);
			logger.info("Value:::"+value);
			//System.out.println("Value:::"+prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public  Integer getNumericProperty(Integer step_num){
		logger.info("Property Key::"+step_num);
		String value1 = "";
		try {
			fis = new FileInputStream(file_path+file_name);
			
			// load a properties file
			props.load(fis);
			
			value1 = props.getProperty(step_num.toString());
			logger.info("Value:::"+value);
			//System.out.println("Value:::"+prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Integer(value1);
	}
	
	/*public static void main(String args[]){
		
		PropertyReader.getProperty("BASE_URL");
		
	}*/

}
