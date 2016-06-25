package com.huice.auto.framework.selenium.action;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

public class AssertAction extends KeyboardAction{
	/**
	 * 检查页面中源代码中某个元素是否存在，
	 * 
	 * @param how 识别元素的方式 HOW枚举
	 * @param value元素的值
	 * @return true存在 false不存在
	 */
	protected boolean isWebElementExist(How how, String value) {
		if (getElementsByHow(how, value).size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查页面中某个元素是否处于显示状态
	 * 
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素的值
	 * @return true显示 false不显示
	 */
	protected boolean isWebElementDisplayed(How how, String value) {
		return isWebElementDisplayed(getElementByHow(how, value));
	}

	/**
	 * 检查页面中某个元素是否处于显示状态
	 * 
	 * @param e 指定元素
	 * @return true显示 false不显示
	 */
	protected boolean isWebElementDisplayed(WebElement e) {
		if (e.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查页面中某个元素是否可用
	 * 
	 * @param how 识别元素的方式 HOW枚举
	 * @param value元素的值
	 * @return true可用 false不可用
	 */
	protected boolean isWebElementEnabled(How how, String value) {
		return isWebElementEnabled(getElementByHow(how, value));
	}

	/**
	 * 检查页面中某个元素是否可用
	 * 
	 * @param e 指定元素
	 * @return true可用 false不可用
	 */
	protected boolean isWebElementEnabled(WebElement e) {
		if (e.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查页面中的元素是否被选中
	 * 
	 * @param how识别元素的方式 HOW枚举
	 * @param value元素的值
	 * @return true选中 false未选中
	 */
	protected boolean isWebElementSelected(How how, String value) {
		return isWebElementSelected(getElementByHow(how, value));
	}

	/**
	 * 检查页面中的元素是否被选中
	 * 
	 * @param e 指定元素
	 * @return true选中 false未选中
	 */
	protected boolean isWebElementSelected(WebElement e) {
		if (e.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断页面alert弹出窗是否存在
	 * 
	 * @return true存在 false不存在
	 */
	protected boolean isAlert() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	/**
	 * 检查当前页面是否包含指定的文本内容<br />
	 * 
	 * @param text 要检查的文本的内容
	 * @return true存在 false不存在
	 */
	protected boolean isTextPresent(String text) {
		if (text.length() > 0) {
			return getText(How.TAG_NAME, "html").contains(text);
		}
		return false;
	}

	/**
	 * 检查属性名是否存在
	 * 
	 * @param e 被检查的元素
	 * @param aName 属性名称
	 * @return true存在 false不存在
	 */
	protected boolean isAttributeNameExist(WebElement e, String aName) {
		if (e.getAttribute(aName) == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 检查属性名是否存在
	 * 
	 * @param how 识别元素的方式 HOW枚举
	 * @param value元素的值
	 * @param aName 属性名
	 * @return true存在 false不存在
	 */
	protected boolean isAttributeNameExist(How how, String value, String aName) {
		return isAttributeNameExist(getElementByHow(how, value), aName);
	}

	/**
	 * 断言当前的标题（忽略左右空格）
	 * 
	 * @param except 预期的值
	 */
	protected void assertCurrentTitle(String except) {
		AssertJUnit.assertEquals("当且页面的Title不对！", except.trim(), getTitle()
				.trim());
	}

	/**
	 * 断言当前页面的URL地址
	 * 
	 * @param except 预期的值
	 */
	protected void assertCurrentUrl(String except) {
		AssertJUnit.assertEquals("当前页面的URL不对！", except, getCurrentUrl());
	}

	/**
	 * 断言指定的文本是否在当前页面<br />
	 * 
	 * @param text 检查的文本
	 * @param isPresent 是否存在 true检查是否存在，false检查是否不存在
	 */
	protected void assertTextPresent(String text, Boolean isPresent) {
		if (isPresent) {
			AssertJUnit.assertTrue(String.format("文本“%s”在页面中不存在!", text),
					isTextPresent(text));
		} else {
			AssertJUnit.assertFalse(String.format("文本“%s”在页面中存在!", text),
					isTextPresent(text));
		}
	}

	/**
	 * 断言文本是否在当前页面存在<br />
	 * 
	 * @param text 检查的文本
	 * @param message 断言提示信息
	 * @param isPresent 是否存在 true检查是否存在，false检查是否不存在
	 */
	protected void assertTextPresent(String text, String message,
			Boolean isPresent) {
		if (isPresent) {
			AssertJUnit.assertTrue(
					String.format("%s。文本“%s”在页面中不存在!", message, text),
					isTextPresent(text));
		} else {
			AssertJUnit.assertFalse(
					String.format("%s。文本“%s”在页面中存在!", message, text),
					isTextPresent(text));
		}
	}

	/**
	 * 断言元素是否存在
	 * 
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param time 等待时间，单位秒
	 */
	protected void assertElementPresent(final How how, final String value,
			int time) {
		try {
			(new WebDriverWait(driver, time))
					.until(new ExpectedCondition<WebElement>() {
						public WebElement apply(WebDriver d) {
							return getElementByHow(how, value);
						}
					});
		} catch (TimeoutException ex) {
			AssertJUnit.fail(String.format("指定的元素  %s（by %s） 的元素不存在！", value,
					how));
		}
	}

	/**
	 * 断言指定元素的指定的属性值是否正确
	 * 
	 * @param e 元素对象
	 * @param Attributename 属性名称
	 * @param except 属性预期值
	 */
	protected void assertElementAttribute(WebElement e, String Attributename,
			String except) {
		AssertJUnit.assertEquals("元素的属性值不对！", except,
				getAttributeByName(e, Attributename));
	}

	/**
	 * 断言指定元素的指定的属性值是否正确
	 * 
	 * @param Attributename 属性名称
	 * @param except 属性预期值
	 */
	protected void assertElementAttribute(How how, String value,
			String Attributename, String except) {
		assertElementAttribute(getElementByHow(how, value), Attributename,
				except);
	}

	/**
	 * 断言指定的元素内页面的显示文本（innerText）是否正确
	 * 
	 * @param how识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param except 文本预期值
	 */
	protected void assertElementText(How how, String value, String except) {
		AssertJUnit.assertEquals("元素内的文本不正确！", except, getText(how, value));
	}

	/**
	 * 断言指定表格中指定位置单元格的内容
	 * 
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param row 表格行
	 * @param column 表格列
	 * @param except 单元格预期值
	 */
	protected void assertElementTextByTableCell(How how, String value, int row,
			int column, String except) {
		AssertJUnit.assertEquals("单元格内容不正确！", except,
				getCellTextFromTable(how, value, row, column));
	}

	/**
	 * 依据指定的URL 验证新窗口是否打开<br />
	 * 注意：在当前的窗口句柄没有切换前验证
	 * 
	 * @param expectUrl 预期的URL地址
	 */
	protected void assertNewWindow(String url) {
		String currentWindow = getCurrentWindow();
		Object[] aw = getAllWindow().toArray();
		AssertJUnit.assertEquals("新开窗口的URL不对！", url,
				switchWindow(aw[aw.length - 1].toString()).getCurrentUrl());
		switchWindow(currentWindow);
	}
	
	/**
	 * 断言Alert弹框的文本值
	 * @param excepted
	 */
	protected void assertAlertText(String excepted) {
		waitForMillis(2000);
		if(isAlert()){
			AssertJUnit.assertEquals("检查Alert弹框的文本是否正确！", excepted, driver.switchTo().alert().getText());
		}else {
			AssertJUnit.assertTrue("检查Alert弹框并未弹出！",false);
		}
	}
}
