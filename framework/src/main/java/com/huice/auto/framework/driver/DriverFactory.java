package com.huice.auto.framework.driver;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	private static WebDriver driver;
	
	public static WebDriver getdriver(String type) {
		switch(type.toUpperCase()){
		case "CHROME" :
			driver=DriverFactory.getChromeDriver();
			break;
		case "IE" :
			driver=DriverFactory.getInternetExplorerDriver();
			break;
		case "FF" :
		case"FIREFOX":	
			driver=DriverFactory.getFireFoxDriver();
			break;
		default :
			driver=DriverFactory.getInternetExplorerDriver();
			break;
		}
		return DriverFactory.driver;
	}
	private static ChromeDriver getChromeDriver(){
		System.setProperty("webdriver.chrome.driver", "E:\\BaiduYunDownload\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		return driver;
	}
	private static FirefoxDriver getFireFoxDriver(){
		FirefoxBinary binary = new FirefoxBinary(new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"));
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxDriver driver = new FirefoxDriver(binary, profile);
		return driver;
	}
	private static InternetExplorerDriver getInternetExplorerDriver(){
		System.setProperty("webdriver.ie.driver", "E:\\BaiduYunDownload\\IEDriverServer_x64_2.41.0\\IEDriverServer.exe");
		InternetExplorerDriver driver=new InternetExplorerDriver();
		return driver;
	}
	
}