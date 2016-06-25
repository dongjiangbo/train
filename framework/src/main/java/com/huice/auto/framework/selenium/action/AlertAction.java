package com.huice.auto.framework.selenium.action;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.How;

public class AlertAction extends AssertAction{

	/**
	 * 单击确定alert、confirm窗口
	 */
	protected void accept() {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * 确认所有alert弹出窗
	 */
	protected void acceptAllAlert() {
		while (isAlert()) {
			accept();
		}
	}
	
	/**
	 * 单击confirm取消按钮
	 */
	protected void cancel() {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * 逐个单击confirm取消所有弹出窗
	 */
	protected void cancelAllAlert(){
		while(isAlert()){
			cancel();
		}
	}
	
	/**
	 * prompt弹出框，填入指定的文本<br />
	 * （部分IE，需要IE选项----安全选项----自定义级别------脚本下的允许网站使用脚本窗口提示获得信息设置启用）
	 * @param inputText 输入的文本
	 */
	protected void prompt(String inputText) {
		Alert alert  = driver.switchTo().alert();
		alert.sendKeys(inputText);
		alert.accept();
	}
	
	/**
	 * 选择上传文件操作
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param filepath 上传文件路径 例如 C:\\a.txt
	 */
	protected void upload(How how, String value, String filepath) {
		if(new File(filepath).exists()) {
			getElementByHow(how, value).sendKeys(filepath);
		}
		waitForMillis(1000);
	}
}
