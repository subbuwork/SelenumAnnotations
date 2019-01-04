package com.carshop.utils;

//import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class TimeElapsed {
	
	final static Logger logger = Logger.getLogger(TimeElapsed.class.getSimpleName());
	Long start_time;
	Long end_time;
	Long time_elapsed;
	
	public Long start_time(){
		logger.info("...........Start Time....");
		start_time = System.currentTimeMillis();
		return start_time;
	}
	
	public Long end_time(){
		logger.info("....End Time....");
		end_time = System.currentTimeMillis();
		Long time_elapsed = this.timeElapsed(start_time, end_time);
		logger.info("Time Elapsed..."+time_elapsed);
		return time_elapsed;
		
	}
	
	public Long timeElapsed(Long start_time,Long end_time){
		logger.info("..........Time Elapsed...Start Time:::"+start_time+"::End Time::"+end_time);
		time_elapsed = end_time - start_time;
		
		//Resetting to default;
		start_time = new Long(0);
		end_time = new Long(0);
		return time_elapsed;
	}
	
	public void test_time_elapsed(Integer iter){
		this.start_time();
		logger.info("Inside:: test_time_elapsed() method..."+iter);
		for(int i = 1; i<=10;i++){
			System.out.println("I:::"+i);
		}
		this.end_time();
	}
	
 /* public static void main(String[] args) {
		System.out.println("Main....");
		BasicConfigurator.configure();
		TimeElapsed elapsed = new TimeElapsed();
		elapsed.test_time_elapsed(1);
		elapsed.test_time_elapsed(2);
		
	}*/

}
