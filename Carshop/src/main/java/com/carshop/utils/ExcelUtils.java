package com.carshop.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.carshop.input.InputData;

public class ExcelUtils {
	Logger logger = Logger.getLogger(ExcelUtils.class.getSimpleName());
	InputData inputData;
	String file_path = "D:\\development\\ClientProjects\\UK\\Carshop\\reports\\";
	String file_name;
	PropertyReader propsReader;
	List<String> makes;
	List<String> models;
	List<String> prices;
	List<String> colors;
	List<String> features;
	List<String> bodyTypes;
	List<String> engineSizes;
	List<String> stores;
	List<String> moreOptions;
	List<String> noOfSeats;
	
    public ExcelUtils(String file_name){
    	this.file_name = file_name;
    	inputData = new InputData();
    	propsReader = new PropertyReader("TestStepsConfig.properties");
    	makes = new ArrayList<String>();
    	models = new ArrayList<String>();
    	prices = new ArrayList<String>();
    	colors = new ArrayList<String>();
    	features = new ArrayList<String>();
    	bodyTypes = new ArrayList<String>();
    	engineSizes = new ArrayList<String>();
    	stores = new ArrayList<String>();
    	moreOptions = new ArrayList<String>();
    	noOfSeats = new ArrayList<String>();
    	
    }
	
	public InputData readData(){
		logger.info("Reading Data from excel file....");
		makes = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(file_path+file_name);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			XSSFSheet sheet = workbook.getSheet("data");
			inputData.setPostCode(sheet.getRow(11).getCell(2).getStringCellValue());
			
            inputData.setKeywordSearch(sheet.getRow(12).getCell(2).getStringCellValue());
            
			for(String value:sheet.getRow(13).getCell(2).getStringCellValue().split(",")){
				logger.info("Makes adding to list:::"+value);
				makes.add(value);
			}
			inputData.setMakes(makes);
			
			for(String value:sheet.getRow(14).getCell(2).getStringCellValue().split(",")){
				logger.info("Models adding to List::"+value);
				models.add(value);
			}
			inputData.setModels(models);
			
			for(String value :sheet.getRow(15).getCell(2).getStringCellValue().split(",")){
				logger.info("Price adding to List:::"+value);
				prices.add(value);
			}
			inputData.setPrices(prices);
			
			
			inputData.setAge(sheet.getRow(16).getCell(2).getStringCellValue().trim());

			inputData.setMilage(sheet.getRow(17).getCell(2).getStringCellValue().trim());
			
			for(String value :sheet.getRow(18).getCell(2).getStringCellValue().split(",") ){
				logger.info("Body type adding to list..."+value);
				bodyTypes.add(value);
			}
			inputData.setBodyTypes(bodyTypes);

			inputData.setFuel_type(sheet.getRow(19).getCell(2).getStringCellValue().trim());
			
            inputData.setTransmisstionType(sheet.getRow(20).getCell(2).getStringCellValue().trim());
            
            
			for(String value :sheet.getRow(21).getCell(2).getStringCellValue().split(",") ){
				logger.info("Engine sizse addig to List......"+value);
				engineSizes.add(value);
			}
			inputData.setEngineSizes(engineSizes);
			
			
			for(String value :sheet.getRow(22).getCell(2).getStringCellValue().split(",")){
				logger.info("Adding colors to list:::"+value);
				colors.add(value);
			}
			inputData.setColors(colors);

			inputData.setNoOfDoors(sheet.getRow(23).getCell(2).getStringCellValue());
			
			for(String value: sheet.getRow(24).getCell(2).getStringCellValue().split(",")){
				logger.info("Adding Seats to list:::"+value);
				noOfSeats.add(value);
			}
			inputData.setNoOfSeats(noOfSeats);
			
			inputData.setAnnualTax(sheet.getRow(25).getCell(2).getStringCellValue());

			inputData.setFuelEconomy(sheet.getRow(26).getCell(2).getStringCellValue());
			
			
            inputData.setCo2Emission(sheet.getRow(27).getCell(2).getStringCellValue().trim());
			
			inputData.setPowser(sheet.getRow(28).getCell(2).getStringCellValue().trim());
			
            for(String value :sheet.getRow(29).getCell(2).getStringCellValue().split(",") ){
            	logger.info("Adding features to list:::"+value);
            	features.add(value);
            }
            inputData.setFeatures(features);
            
			for(String value:sheet.getRow(30).getCell(2).getStringCellValue().split(",")){
				logger.info("Adding stores to list:::"+value);
				stores.add(value);
			}
			inputData.setStores(stores);
			
			for(String value:sheet.getRow(31).getCell(2).getStringCellValue().split(",") ){
				logger.info("Adding more optons to list:::"+value);
				moreOptions.add(value);
			}
			inputData.setMoreOptions(moreOptions);
			
			/*for(int i = 13; i<= 33; i++){
				logger.info((sheet.getRow(i).getCell(2).toString()));
			}*/
			workbook.close();
			fis.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputData;
	}
	
	
	
	public void writeData(String input,Integer step_num,Long loadingTime){
				logger.info("Writing data to test case table:::"+input);	
		try {
			FileInputStream fis = new FileInputStream(file_path+file_name);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet("data");
			sheet.getRow(propsReader.getNumericProperty(step_num)).getCell(3).setCellValue(input.trim());
			sheet.getRow(propsReader.getNumericProperty(step_num)).getCell(4).setCellValue(loadingTime);
			fis.close();
			FileOutputStream fos = new FileOutputStream(file_path+file_name);
			workbook.write(fos);
			workbook.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
public void writeData(Integer step_num,String item_name){
		logger.info("Writing data to test case table:::"+step_num);	
try {
	FileInputStream fis = new FileInputStream(file_path+file_name);
	
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("data");
	sheet.getRow(propsReader.getNumericProperty(step_num)).getCell(5).setCellValue("Auction Not available("+item_name+")");
	fis.close();
	FileOutputStream fos = new FileOutputStream(file_path+file_name);
	workbook.write(fos);
	workbook.close();
	
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}
	
	/*public static void main(String[] args) {
		BasicConfigurator.configure();
	    ExcelUtils rf = new ExcelUtils("testdata_results.xlsx");
		rf.readData();
		
		
	}*/

}
