package com.huice.auto.framework.selenium;


import org.openqa.selenium.WebDriver;

import com.huice.auto.framework.selenium.action.AlertAction;

public class BasePage extends AlertAction{
	
	public BasePage(WebDriver driver){
		this.driver=driver;
	}
}
