package com.huice.auto.framework.until;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Colors;

/*
 * 设置输入编辑框时的颜色
 */
public class HightLight {
	public static boolean is=true;
	public static int size = 3;

	public static Colors beforecolor = Colors.YELLOW;

	public static Colors aftercolor = Colors.RED;

	public static void doHighLight(WebDriver driver, WebElement element) {
		if (is) {
			String css = String.format(
					"arguments[0].style.border ='%dpx solid %s'", size,
					beforecolor.getColorValue().asHex());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(css, element);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void undoHighLight(WebDriver driver, WebElement element) {
		if (is) {
			String css = String.format(
					"arguments[0].style.border ='%dpx solid %s'", size,
					aftercolor.getColorValue().asHex());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			try{
				js.executeScript(css, element);
			}catch(Exception e){
				
			}	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
