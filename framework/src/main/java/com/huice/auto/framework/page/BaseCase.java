package com.huice.auto.framework.page;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.huice.auto.framework.driver.DriverFactory;



@Test
public class BaseCase {

	public WebDriver driver;

	@BeforeClass(alwaysRun=true)
	@Parameters("{browser}")
	public void initDriver(@Optional("CHROME") String browser){
		driver=DriverFactory.getdriver(browser);
	}
	
	@AfterClass(alwaysRun=true)
	public void destoryDriver(){
		driver.quit();
	}
	
}
