package com.huice.auto.framework.selenium.action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class KeyboardAction extends NavigateAndElementAction{
	/**
	 * 模拟键盘操作，只对IE和火狐有效<br />
	 * 非字符（a-z）和数字（0-9）的键值
	 * @param key Keys对象
	 */
	protected void pressKey(Keys key) {
		new Actions(driver).sendKeys(key).perform();
	}
	
	/**
	 * 模拟多个键值的组合按键操作，只对IE和火狐有效
	 * @param keystosend
	 */
	protected void pressKey(CharSequence... keystosend) {
		new Actions(driver).sendKeys(Keys.chord(keystosend)).build().perform();
	}
}
