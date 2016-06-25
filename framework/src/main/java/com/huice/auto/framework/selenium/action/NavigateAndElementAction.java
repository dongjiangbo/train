package com.huice.auto.framework.selenium.action;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class NavigateAndElementAction extends WaitAction{
	/**
	 * 使用当前Driver打开指定URL的页面
	 * @param url URL地址
	 */
	protected void open(String url) {
		driver.get(url);
	}
	
	/**
	 * 使用URL对象打开指定的URL的页面
	 * @param url URL地址
	 */
	protected void open(URL url) {
		driver.navigate().to(url);
	}
	
	/**
	 * 使用navigate对象打开指定的URL的页面
	 * @param url URL地址
	 */
	protected void openByNavigate(String url) {
		driver.navigate().to(url);
	}
	
	/**
	 * 浏览器回退
	 */
	protected void goBack()	{
		goBack(1);
	}
	
	/**
	 * 浏览器回退指定的次数
	 * @param n 回退次数
	 */
	protected void goBack(int n) {
		if(n<1){
			n=1;
		}
		while(n != 0){
			driver.navigate().back();
			n--;
		}
	}
	
	/**
	 * 浏览器前进
	 */
	protected void goForward() {	
		goForward(1);	
	}
	
	/**
	 * 浏览器前进指定的次数
	 */
	protected void goForward(int n)	{
		if(n<1){
			n=1;
		}
		while(n != 0){
			driver.navigate().forward();
			n--;
		}
	}
	
	/**
	 * 浏览器刷新
	 */
	protected void refresh() {
		driver.navigate().refresh();
	}
	
	/**
	 * 浏览器最大化<br />
	 */
	protected void Maximize() {
		driver.manage().window().maximize();
	}
	
	/**
	 * 获取当前页面的标题
	 * @return String 标题字符串
	 */
	protected String getTitle() {
		return driver.getTitle();
	}
	
	/**
	 * 获取当前页面的地址
	 * @return String 得到当前页面的地址
	 */
	protected String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * 获取当前页面的Response的内容（在JS改变页面前的）
	 * @return String Response的HTML代码
	 */
	protected String getCurrentSource() {
		return driver.getPageSource();
	}
	
	/**
	 * 获取当前窗口的句柄
	 * @return String 返回的窗口的句柄值
	 */
	protected String getCurrentWindow() {
		return driver.getWindowHandle();
	}
	
	/**
	 * 获取所有窗口的句柄
	 * @return Set<String> 一个包含多个窗口句柄的集合
	 */
	protected Set<String> getAllWindow() {
		return driver.getWindowHandles();
	}
		
	/**
	 * 关闭所有非当前句柄的窗口
	 */
	protected void closeOtherWindow() {
		String currentWindow = getCurrentWindow();
		Set<String> handles = getAllWindow();
		for(String h : handles)
		{
			if(currentWindow.equalsIgnoreCase(h)) continue;
			switchWindow(h).close();
		}
		switchWindow(currentWindow);
	}
	
	/**
	 * 根据名称或者句柄切换窗口
	 * @param window的句柄或者名称
	 * @return 指向该窗口的WebDriver
	 */
	protected WebDriver switchWindow(String WindownameOrHandle) {
		if(WindownameOrHandle.trim().length()>0)
		{
			return driver.switchTo().window(WindownameOrHandle);
		}
		return null;
	}
	
	/**
	 * 切换到最近开启的窗口
	 * @return 指向该窗口的WebDriver
	 */
	protected WebDriver switchNextOpenWindow() {
		Object[] aw =  getAllWindow().toArray();
		return switchWindow(aw[aw.length-1].toString());
	}
	
	/**
	 * 添加Cookie 警告：chrome浏览器无效
	 * @param cookie 
	 */
	protected void addCookie(Cookie cookie) {
		driver.manage().addCookie(cookie);
	}
	
	/**
	 * 获取页面上的所有cookie  警告：chrome浏览器无效
	 */
	protected Set<Cookie> getAllCookies() {
		return driver.manage().getCookies();
	}
	
	/**
	 * 根据cookie的key值获取value值  警告：chrome浏览器无效
	 * @param key cookie的key
	 * @return Cookies字段的值
	 */
	protected Cookie getCookieByKey(String key) {
		return driver.manage().getCookieNamed(key);
	}
	
	/**
	 * 删除cookie  警告：chrome浏览器无效
	 * @param cookie
	 */
	protected void deleteCookie(Cookie cookie){
		driver.manage().deleteCookie(cookie);
	}

	/**
	 * 根据key值删除页面上的cookie值  警告：chrome浏览器无效
	 * @param key cookie的key
	 */
	protected void deleteCookieByKey(String key) {
		driver.manage().deleteCookieNamed(key);
	}
	
	/**
	 * 删除页面上的所有cookie值  警告：chrome浏览器无效
	 */
	protected void deleteAllCookies() {
		driver.manage().deleteAllCookies();		
	}
		
	/**
	 * 关闭当前窗口
	 * 警告：不建议在TestCase中使用 推荐使用{@link #closeOtherWindow()}
	 */
	protected void close() {
		driver.close();
	}
		
	/**
	 * 关闭由Driver生成的所有的窗口<br />
	 * 警告：不建议在TestCase中使用
	 */
	protected void quit() {
		driver.quit();
	}


	/**
	 * 在框架页面中，切换到指定的Frame页面
	 * @param framenameOrId frame的名称或者ID
	 * @return 指向该窗口的WebDriver
	 */
	protected WebDriver switchFrame(String framenameOrId) {
		waitForMillis(1000);
		return driver.switchTo().frame(framenameOrId);
	}
	
	/**
	 * 在框架页面中，切换到指定的Frame页面，根据Frame元素对象
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @return WebDriver对象
	 */
	protected WebDriver switchFrame(How how ,String value) {
		return switchFrame(getElementByHow(how, value));
	}
	
	/**
	 * 在框架页面中，切换到指定的Frame页面，根据Frame元素对象
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @return WebDriver对象
	 */
	protected WebDriver switchFrame(WebElement e) {
		waitForMillis(1000);
		return driver.switchTo().frame(e);
	}
	
	/**
	 * 由具体的iframe页面切换回整个框架页面
	 * @return WebDriver对象
	 */
	protected WebDriver switchDefautPage() {
		waitForMillis(1000);
		return driver.switchTo().defaultContent();
	}
	
	/**
	 * 切换到当前页面的获得焦点的元素，如果没有的话直接切换到body元素
	 * @return WebElement 元素对象
	 */
	protected WebElement switchActiveElement() {
		return driver.switchTo().activeElement();
	}
	
	/**
	 * 对指定的元素进行点击操作
	 * @param 元素对象
	 */
	protected void click(WebElement e) {
		if(e != null && e.isDisplayed())
		{
			e.click();
		}
	}
	
	/**
	 * 根据指定的条件，对相应的元素进行点击操作
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 */
	protected void click(How how, String value) {
		click(getElementByHow(how, value));
	}
	
	/**
	 * 依据元素的文本进行点击操作
	 * @param text 元素的文本
	 */
	protected void clickByText(String text ) {
		click(getElementByLinkText(text));
	}
	
	/**
	 * 依据元素的ID值进行点击操作
	 * @param id 元素ID
	 */
	protected void clickById(String id) {
		click(getElementById(id));
	}
	
	/**
	 * 依据元素的Name值进行点击操作
	 * @param name 元素Name
	 */
	protected void clickByName(String name) {
		click(getElementByName(name));		
	}
	
	/**
	 * 点击元素鼠标不释放
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 */
	protected void clickAndHold(How how,String value) {
		new Actions(driver).clickAndHold(getElementByHow(how,value));		
	}
	
	/**
	 * 对元素的背景进行点击
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 */
	protected void contextClick(How how,String value) {
		WebElement e = getElementByHow(how, value);
        Actions a = new Actions(driver);
        a.moveToElement(e).build().perform();
        a.contextClick(e).build().perform(); 
	}	
	
	/**
	 * 在单选按钮的集合中，按照索引点击指定的radio元素
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param index 元素的序列
	 */
	protected void clickForRadioByIndex(How how, String value , int index) {
		clickForRadioByIndex(getElementsByHow(how, value),index);
	}
	
	/**
	 * 在单选按钮的集合中，按照索引点击指定的radio元素
	 * @param we 元素集合
	 * @param index 元素的序列
	 */
	protected void clickForRadioByIndex(List<WebElement> we , int index) {
		getElementByIndex(we, index).click();
	}
		
	/**
	 * 点击任意个数的多选按钮
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param array 多选按钮序列的数组
	 */
	protected void clickForCheckBoxByArray(How how, String value, int[] array) {
		List<WebElement> l = getElementsByHow(how, value);
		clickForCheckBoxByArray(l,array);
	}
	
	/**
	 * 点击任意个数的多选按钮
	 * @param es checkbox元素集合
	 * @param array 多选按钮序列的数组
	 */
	protected void clickForCheckBoxByArray(List<WebElement> es, int[] array) {
		int length = array.length;
		if(length > 0) {
			while(length >0) {
				getElementByIndex(es, array[length-1]).click();
				length--;
			}
		}		
	}
	
	/**
	 * 随机选择复选框（多选）
	 * @param how
	 * @param value
	 */
	protected void clickForCheckBoxByRandom(How how, String value) {
		clickForCheckBoxByRandom(getElementsByHow(how, value));
	}
	
	/**
	 * 随机选择复选框（多选）
	 * @param es 复选框元素的集合          
	 */
	protected void clickForCheckBoxByRandom(List<WebElement> es) {
		boolean isclick = false;
		for(int i=0;i<es.size();i++) {
			if(new Random().nextInt(2) == 1){
				click(es.get(i));
				isclick = true;
			}
		}		
		if(!isclick)click(getElementByIndex(es, 1));
	}
	
	/**
	 * 根据指定的option的文本或者value值，进行下拉框的选择操作
	 * @param e Select元素
	 * @param text  选项内容
	 */
	protected void select(WebElement e, String text) {
		try{
			new Select(e).selectByVisibleText(text);
		}
		catch(Exception ex) {
			new Select(e).selectByValue(text);
		}
	}
	
	/**
	 * 根据下拉框的内容或者value，选择指定的选项。注意：只适用于Select元素。
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param text  选项内容
	 */
	protected void select(How how, String value, String text) {
		select(getElementByHow(how, value), text);
	}
	
	/**
	 * 根据指定的元素进行下拉框的操作
	 * @param e Select元素
	 * @param index 索引 起始0
	 */
	protected String select(WebElement e, int index) {		
		List<WebElement> ws = new Select(e).getOptions();
		if(ws.size()!=0){
			if (index <= 0) {
				index = 0;
			}else if(index >= ws.size()){
				index = ws.size()-1;
			}
			
			new Select(e).selectByIndex(index);
			return ws.get(index).getText();
		}
		return null;		
	}	
	
	/**
	 * 更具下拉框的序列，选择指定的选项。注意：只适用于Select元素。
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param index 索引 起始0
	 */
	protected String select(How how, String value, int index) {
		return select(getElementByHow(how, value), index);
	}
	
	/**
	 * 根据下拉框的长度，随机进行选择
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param start 随机的范围开始的序列的起始位置，默认为0
	 */
	protected String selectRandomByIndex(How how, String value, int start) {
		WebElement select = getElementByHow(how, value);
		return selectRandomByIndex(select,start);
	}
	
	/**
	 * 根据下拉框的长度，随机进行选择
	 * @param select 下拉框元素
	 * @param start 随机的范围开始的序列的起始位置，默认为0
	 */
	protected String selectRandomByIndex(WebElement select, int start) {
			List<WebElement> ws = new Select(select).getOptions();
			if(ws.size()!=0){
				if (start <=0 ) {
					start = 0;
					return select(select, start);
				}else if(start >= ws.size()){
					start = ws.size()-1;
					return select(select, start);
				}else{
					int  rand = new Random().nextInt(ws.size()-start)+start;
					return select(select,rand);
				}
			}
			return null;
	}	
	
	/**
	 * 根据元素执行双击操作
	 * @param e 双击的元素
	 */
	protected void doubleClick(WebElement e) {
		new Actions(driver).doubleClick(e).perform();
	}
	
	/**
	 * 根据指定的条件，对相应的元素进行双击操作
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 */
	protected void doubleClick(How how, String value) {
		doubleClick(getElementByHow(how, value));
	}
	
	/**
	 * 将鼠标移动到指定的元素位置
	 * @param e 要移动的位置
	 */
	protected void mouseMoveToElement(WebElement e) {
		new Actions(driver).moveByOffset(e.getLocation().x, e.getLocation().y).perform();
		new Actions(driver).moveToElement(e).perform();
	}
	
	/**
	 * 根据指定的条件，将鼠标移动到指定的元素上
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 */
	protected void mouseMoveToElement(How how, String value) {
		mouseMoveToElement(getElementByHow(how, value));
	}
	
	/**
	 * 将鼠标移动到指定的元素位置进行点击
	 * @param e 目标元素
	 */
	protected void mouseMoveToElementAndClick(WebElement e) {
        Actions a = new Actions(driver);
        a.moveToElement(e).build().perform();
        a.click(e).build().perform();        
    } 

	/**
	 * 将鼠标移动到指定的元素位置进行点击
	 * @param e 目标元素
	 */
	protected void mouseMoveToElementAndClick(How how, String value) {
		mouseMoveToElementAndClick(getElementByHow(how, value));
    } 
		
	/**
	 * 对指定的元素进行输入文本操作(会清除原来的内容)
	 * @param e 操作的元素
	 * @param inputText 输入的文本
	 */
	protected void type(WebElement e, String inputText) {
		clear(e);
		e.sendKeys(inputText);
	}
	
	/**
	 * 根据指定的条件，对相应的元素进行输入文本操作
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 */
	protected void type(How how, String value, String inputText) {
		type(getElementByHow(how, value), inputText);
	}
	
	/**
	 * 依据元素的ID值进行输入文本操作
	 * @param id 元素ID
	 * @param inputText 输入的文本
	 */
	protected void typeById(String id, String inputText) {
		type(getElementById(id), inputText);
	}

	/**
	 * 依据元素的Name值进行输入文本操作
	 * @param name 元素name
	 * @param inputText 输入的文本
	 */
	protected void typeByName(String name, String inputText) {
		type(getElementByName(name), inputText);
	}
	
	/**
	 * 清空输入框（包括INPUT和TEXTAREA元素）中文本
	 * @param e 要操作的对象
	 */
	protected void clear(WebElement e) {
		e.clear();
	}

	/**
	 * 根据指定的条件，对相应的元素进行清空文本操作
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 */
	protected void clear(How how, String value) {
		clear(getElementByHow(how, value));
	}
	
	/**
	 * 表单元素的submit操作
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 */
	protected void submit(How how, String value) {
		getElementByHow(how, value).submit();
	}
	
	/**
	 * 执行JS脚本
	 * @param script 要执行的JS脚本
	 */
	protected void executeJS(String script) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript(script);
	}
	
	/**
	 * 执行JS脚本,如果不执行设置一下浏览器
	 * @param script 脚本
	 * @param element web对象元素
	 */
	protected void executeJS(String script,WebElement element){
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript(script, element);
	}
	/**
	 * 执行JS脚本,如果不执行设置一下浏览器
	 * @param script 脚本
	 * @param how 识别元素的方式 HOW枚举
	 * @param value  元素的值
	 */
	protected void executeJS(String script,How how,String value){
		executeJS(script,getElementByHow(how, value));
	}
	
	/**
	 * 修改元素指定的属性
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素的值
	 * @param attribute 属性名称
	 * @param attValue 属性值
	 */
	protected void setAttribute(How how,String value,String attribute,String attValue){
		String js = String.format("arguments[0]."+attribute+"='"+attValue+"'");
		executeJS(js, how, value);		
	}
	
	/**
	 * 修改元素指定的属性
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素的值
	 * @param attribute 属性名称
	 * @param attValue 属性值
	 */
	protected void setAttribute(How how,String value,String attribute,boolean b){
		String js = String.format("arguments[0]."+attribute+"="+b);
		executeJS(js, how, value);		
	}	
}
