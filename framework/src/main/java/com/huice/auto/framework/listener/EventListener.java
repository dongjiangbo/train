package com.huice.auto.framework.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.huice.auto.framework.until.HightLight;


public class EventListener implements WebDriverEventListener{

	
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		HightLight.undoHighLight(driver, element);
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		HightLight.undoHighLight(driver, element);
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		
		
	}

	public void afterNavigateBack(WebDriver driver) {
		
	}

	public void afterNavigateForward(WebDriver driver) {
		
		
	}

	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterNavigateTo(String str, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void afterScript(String str, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
	
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeNavigateTo(String str, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void beforeScript(String str, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable throwable, WebDriver driver) {
		// TODO Auto-generated method stub
		
	}

}
