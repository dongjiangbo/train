package com.huice.auto.framework.until;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Reporter;

public class Logger {
 private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     
	 public static boolean isLog = true;	 
	 
	 public static boolean isToStandardOut = false;

	 public static boolean isFormat = true;
	 
     public static int verbose = 1;     
     
     public static void log(String s, int level, boolean logToStandardOut) {
    	 if(isLog){
    		 Reporter.log(logPrefix(s), level, logToStandardOut);
    	 }    	 
     }
     
     public static void log(String s) {
    	 log(s,verbose,isToStandardOut);
     }
     
     public static void log(String s, int level){
    	 log(s,level,isToStandardOut);
     }
     
     public static void log(String s, boolean logToStandardOut){
    	 log(s,verbose,logToStandardOut);
     }
	  
	private static String logPrefix(String s) {
		Date logtime = new Date();
		if(isFormat) {
			return "[" + System.getProperty("Project.EnglishName", "train3") + " "+ DATE_FORMAT.format(logtime) + "] " + s;
		}
		return s;
	}
	
	public static void setLog() {
		if (System.getProperty("Logger", "true").equalsIgnoreCase("false")) {
			Logger.isLog = false;
		}
		if (System.getProperty("Logger.StandardOut", "false").equalsIgnoreCase("true")) {
			Logger.isToStandardOut = true;
		}
		if (System.getProperty("Logger.Format", "true").equalsIgnoreCase("false")) {
			Logger.isFormat = false;
		}		
	}
}
