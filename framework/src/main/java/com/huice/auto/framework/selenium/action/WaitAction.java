package com.huice.auto.framework.selenium.action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.huice.auto.framework.selenium.element.BasePageElement;

public class WaitAction extends BasePageElement{

	/**
	 * 等待指定的时间，此时间必须等待的
	 * @param millis 毫秒
	 */
	protected void waitForMillis(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 持续等待一段时间
	 * @param i
	 * @param unit
	 */
	protected void waitDurationTime(long i,TimeUnit unit) {
		waitForMillis(unit.toMillis(i));
	}
	
	/**
	 * 设置浏览器页面加载的超时时间
	 * @param time	时间值
	 * @param unit 时间单位
	 */
	protected void setPageLoadTimeOut(long time, TimeUnit unit) {
		driver.manage().timeouts().pageLoadTimeout(time, unit);
	}
	
	/**
	 * 设置页面脚本的加载的超时时间
	 * @param time	时间值
	 * @param unit 时间单位
	 */
	protected void setScriptExecuteTimeOut(long time, TimeUnit unit) {
		driver.manage().timeouts().setScriptTimeout(time, unit);
	}
	
	/**
	 * 设置元素查找的超时时间
	 * @param time 时间值
	 * @param unit 时间单位
	 */
	protected void setWebElementFindTimeOut(long time, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(time,unit); 
	}
		
	/**
	 * 等待指定Title页面载入（忽略左右空格）
	 * @param title 指定页面的Title
	 * @param second 等待的秒数
	 * @return 
	 */
	protected Boolean waitForPageLoadByTitle(final String title, long second) {
       return (new WebDriverWait(driver, second)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                   return d.getTitle().trim().equalsIgnoreCase(title.trim());
               }
        }
        );
	}
	
	/**
	 * 等待指定URL页面载入
	 * @param url 指定页面的URL
	 * @param second 等待的秒数
	 * @return Boolean 等待的断言是否存在
	 */
	protected Boolean waitForPageLoadByURL(final String url, long second) {
       return (new WebDriverWait(driver, second)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                   return d.getCurrentUrl().equalsIgnoreCase(url);
               }
        }
        );
	}
	
	
	protected Boolean waitForElement(final How how,final String value, long second) {
	       return (new WebDriverWait(driver, second)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                   return getElementsByHow(how, value).size() > 0;
	               }
	        }
	        );
		}
	
	/**
	 * 等待元素属性变化 
	 * @param how
	 * @param value
	 * @param attri 属性
	 * @param attValue 属性值
	 * @param second 等待时间
	 * @return
	 */
	protected Boolean waitWebElementAttriChange(final How how,final String value, final String attri,
			final String attValue,long second) {	
		 WebElement e = getElementByHow(how, value);
		return waitWebElementAttriChange(e, attri, attValue, second);
	}
	
	/**
	 * 等待元素属性变化
	 * @param e 元素
	 * @param attri 属性
	 * @param attValue 属性值
	 * @param second 等待时间
	 * @return
	 */
	protected Boolean waitWebElementAttriChange(final WebElement e, final String attri,
			final String attValue,long second) {			
		return (new WebDriverWait(driver, second))
		.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				if (getAttributeByName(e,attri).trim().equals(attValue)){
					return true;
				} else if (getAttributeByName(e,attri).trim().matches(attValue)) {
					return true;
				} else {
					return false;
				}
			}
		});
	}
	
	/**
	 * 等待指定的预期条件
	 * @param ExpectedCondition<?>
	 * @param second 等待的秒数
	 */
	protected void waitForExpectedCondition(final ExpectedCondition<?> expected, long second) {
		try{
			new WebDriverWait(driver, second).until(expected);
		}catch(Exception e){
			AssertJUnit.fail("等待了"+second+"秒，"+expected.toString());
		}
	}	

}
