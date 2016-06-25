package com.huice.auto.framework.selenium.element;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import com.google.inject.Inject;

/**
 * Web Page Element
 * 
 * @author DongjiangBo
 * @version 0.0.1
 */
public class BasePageElement extends TableWebElement{
	
	@Inject
	protected WebDriver driver;
	
	/**
	 * 通过id获取单个元素
	 * @param id 名称
	 * @return WebElement 获取的元素对象
	 */
	protected WebElement getElementById(String id) {
		return driver.findElement(By.id(id));
	}
	
	/**
	 * 通过id获取多个相同标识的一组元素
	 * @param id名称
	 * @return List<WebElement> 获取的元素集合
	 */
	protected List<WebElement> getElementsById(String id) {
		return driver.findElements(By.id(id));
	}

	/**
	 * 通过XPATH获取单个元素
	 * @param xpath XPATH路径
	 * @return WebElement 获取的元素对象
	 */
	protected WebElement getElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	/**
	 * 通过XPATH获取多个相同标识的一组元素
	 * @param xpath 
	 * @return List<WebElement> 获取的元素集合
	 */
	protected List<WebElement> getElementsByXpath(String xpath) {
		return driver.findElements(By.xpath(xpath));
	}

	/**
	 * 通过链接文本获取单个元素
	 * @param text 文本的内容
	 * @return WebElement 获取的元素对象
	 */
	protected WebElement getElementByLinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));	
	}
	
	/**
	 * 通过LinkText获取多个相同标识的一组元素
	 * @param text LinkText
	 * @return List<WebElement> 获取的元素集合
	 */
	protected List<WebElement> getElementsByLinkText(String linkText) {
		return driver.findElements(By.linkText(linkText));
	}
	
	/**
	 * 通过Name获取单个元素
	 * @param name 元素的name值
	 * @return WebElement 获取的元素对象
	 */
	protected WebElement getElementByName(String name) {
		return driver.findElement(By.name(name));
	}
	
	/**
	 * 通过Name获取多个相同标识的一组元素
	 * @param name Name
	 * @return List<WebElement> 获取的元素集合
	 */
	protected List<WebElement> getElementsByName(String name) {
		return driver.findElements(By.name(name));
	}
	
	/**
	 * 通过TagName获取单个元素
	 * @param tagName HTML标记内容
	 * @return WebElement 获取的元素对象
	 */
	protected WebElement getElementByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));	
	}
	
	/**
	 * 通过TagName获取多个相同标识的一组元素
	 * @param tagname HTML标记
	 * @return List<WebElement> 获取的元素集合
	 */
	protected List<WebElement> getElementsByTagName(String tagName) {
		return driver.findElements(By.tagName(tagName));	
	}	
	
	/**
	 * 通过ClassName获取单个元素
	 * @param className CSS类名
	 * @return WebElement 获取的元素对象
	 */
	protected WebElement getElementByClassName(String className) {
		return driver.findElement(By.className(className));
	}
	
	/**
	 * 通过ClassName获取多个相同标识的一组元素
	 * @param className Class类名
	 * @return List<WebElement> 获取的元素集合
	 */
	protected List<WebElement> getElementsByClassName(String className) {
		return driver.findElements(By.className(className));
	}

	
	/** 通过cssSelector获取单个元素
	 * @param cssSelector CSS选择器
	 * @return WebElement 获取的元素对象
	 */
	protected WebElement getElementByCssSelector(String selector) {
		return driver.findElement(By.cssSelector(selector));
	}
	
	/**
	 * 通过cssSelector获取多个相同标识的一组元素
	 * @param cssSelector CSS选择器
	 * @return List<WebElement> 获取的元素集合
	 */
	protected List<WebElement> getElementsByCssSelector(String selector) {
		return driver.findElements(By.cssSelector(selector));
	}
	
	/** 通过部分文本获取单个元素
	 * @param text 链接的部分文本
	 * @return WebElement 获取的元素对象
	 */
	protected WebElement getElementByPartialLinkText(String partialLinkText) {
		return driver.findElement(By.partialLinkText(partialLinkText));
	}
	
	/**
	 * 通过部分文本获取多个相同标识的一组元素
	 * @param text 链接的部分文本
	 * @return List<WebElement> 获取的元素集合
	 */
	protected List<WebElement> getElementsByPartialLinkText(String partialLinkText) {
		return driver.findElements(By.partialLinkText(partialLinkText));
	}
	
	/**
	 * 根据元素指定的属性值，获得该元素(此方法执行效率较低，根据情况选用)
	 * @param Attributename 属性名称
	 * @param value 属性值
	 * @return 获取的元素
	 */
	protected WebElement getElementByAttribute(String Attributename, String value)
	{
		String [] tagnames = new String[]{"html","head","title","meta","link","style","script","body","div","form","input","a","img","table","th","tr","td","button","font","span","select","option","p","h1","h2","hr"};
		for(String tn : tagnames) {
			List<WebElement> es = getElementsByTagName(tn);
			for(WebElement e : es) {
				try {
					if(e != null && getAttributeByName(e, Attributename).equalsIgnoreCase(value)) {
						return e;
					}
				}
				catch(Exception ex) {
				}
			}
		}
		return null;
	}
	
	/**
	 *  获取父元素下的指定条件的所有子元素的集合
	 * @param parent 父元素
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @return List<WebElement>  获取的子元素集合
	 */
	protected List<WebElement> getElementsFromParent(WebElement parent, How how, String value) {
		return getElementsFromeParentByHow(parent, how, value);
	}
	
	
	
	/**
	 * 按照索引获得一组元素中的某个元素
	 * @param l 元素集合
	 * @param i 序号  从1开始
	 * @return WebElement 元素对象
	 */
	protected WebElement getElementByIndex(List<WebElement> l, int i) {
		if(i>0 && i<=l.size()) {
			return (WebElement)l.toArray()[i-1];
		}
		return null;
	}
	
	/**
	 * 按照索引获得一组元素中的某个元素
	 * @param l 元素集合
	 * @param i 序号  从1开始
	 * @return WebElement 元素对象
	 */
	protected WebElement getElementByIndex(How how, String value, int i) {
		return getElementByIndex(getElementsByHow(how, value), i);
	}
	
	/**
	 * 获得指定元素集合的个数
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @return 相同条件元素的个数
	 */
	protected int getElementsTotal(How how, String value) {
		return getElementsByHow(how, value).size();
	}
	
	/**
	 * 获取父节点元素根据tag
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param parentTagName 父节点Tag
	 * @return
	 */
	protected WebElement getParentElement(How how,String value,String parentTagName) {
		return getElementByHow(how, value).findElement(By.xpath("parent::"+parentTagName));
	}
	
	/**
	 * 获取父节点元素
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @return
	 */
	protected WebElement getParentElement(How how,String value) {
		return getParentElement(getElementByHow(how, value));
		
	}
	
	/**
	 * 获取父节点元素
	 * @param e 指定子元素
	 * @return
	 */
	protected WebElement getParentElement(WebElement e) {
		return e.findElement(By.xpath("parent::*"));
	}
		
	/**
	 * 通过How方式获得指定的元素
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @return 获得的元素
	 */
	protected WebElement getElementByHow(How how, String value) {
		WebElement e;
		switch (how) {
		case CLASS_NAME:
			e = getElementByClassName(value);
			break;
		case CSS:
			e = getElementByCssSelector(value);
			break;
		case ID:
			e = getElementById(value);
			break;
		case LINK_TEXT:
			e = getElementByLinkText(value);
			break;
		case NAME:
			e = getElementByName(value);
			break;
		case PARTIAL_LINK_TEXT:
			e = getElementByPartialLinkText(value);
			break;
		case TAG_NAME:
			e = getElementByTagName(value);
			break;
		case XPATH:
			e = getElementByXpath(value);
			break;
		default:
			if (getElementById(value) != null) {
				e = getElementById(value);
			} else {
				e = getElementByName(value);
			}
			break;
		}
		return e;
	}

	/**
	 * 通过How方式获得指定的元素集合
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @return 获得的元素集合
	 */
	protected List<WebElement> getElementsByHow(How how, String value) {
		List<WebElement> e;
		switch (how) {
		case CLASS_NAME:
			e = getElementsByClassName(value);
			break;
		case CSS:
			e = getElementsByCssSelector(value);
			break;
		case ID:
			e = getElementsById(value);
			break;
		case LINK_TEXT:
			e = getElementsByLinkText(value);
			break;
		case NAME:
			e = getElementsByName(value);
			break;
		case PARTIAL_LINK_TEXT:
			e = getElementsByPartialLinkText(value);
			break;
		case TAG_NAME:
			e = getElementsByTagName(value);
			break;
		case XPATH:
			e = getElementsByXpath(value);
			break;
		default:
			if (getElementsById(value).size() > 0) {
				e = getElementsById(value);
			} else {
				e = getElementsByName(value);
			}
			break;
		}
		return e;
	}
	
	/**
	 * 在父元素下，通过How方式获得指定的元素集合
	 * @param parent 父元素
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @return 获得的元素集合
	 */
	protected List<WebElement> getElementsFromeParentByHow(WebElement parent, How how, String value) {
		List<WebElement> e;
		switch (how) {
		case CLASS_NAME:
			e = parent.findElements(By.className(value));
			break;
		case CSS:
			e = parent.findElements(By.cssSelector(value));
			break;
		case ID:
			e = parent.findElements(By.id(value));
			break;
		case LINK_TEXT:
			e = parent.findElements(By.linkText(value));
			break;
		case NAME:
			e = parent.findElements(By.name(value));
			break;
		case PARTIAL_LINK_TEXT:
			e = parent.findElements(By.partialLinkText(value));
			break;
		case TAG_NAME:
			e = parent.findElements(By.tagName(value));
			break;
		case XPATH:
			e = parent.findElements(By.xpath(value));
			break;
		default:
			if (parent.findElements(By.id(value)).size() > 0) {
				e = parent.findElements(By.id(value));
			} else {
				e = parent.findElements(By.name(value));
			}
			break;
		}
		return e;
	}
	
	/**
	 * 获得元素的innerText值
	 * @param e 元素
	 * @return innerText
	 */
	protected String getText(WebElement e) {
		return e.getText();
	}
	
	/**
	 * 根据How条件，获得指定元素的innerText
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @return innerText
	 */
	protected String getText(How how, String value) {
		return getText(getElementByHow(how, value));
	}
	
	/**
	 * 获得指定元素的属性值
	 * @param e 元素
	 * @param Aname 属性名称
	 * @return 属性的值
	 */
	protected String getAttributeByName(WebElement e, String Aname) {
		return e.getAttribute(Aname);
	}
	
	/**
	 * 根据How条件，获得指定元素的属性值
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param Aname 属性名
	 * @return 属性值
	 */
	protected String getAttributeByName(How how, String value, String Aname) {
		return getAttributeByName(getElementByHow(how, value), Aname);
	}
	
	/**
	 * 获得指定Table元素的单元格的文本
	 * @param how 识别元素的方式 HOW枚举
	 * @param value 元素识别的值
	 * @param row	表格的行
	 * @param column 表格的列
	 * @return 单元格的文本
	 */
	protected String getCellTextFromTable(How how, String value, int row, int column) {
		List<WebElement> rows = getElementsFromParent(getElementByHow(how, value), How.TAG_NAME, "tr");
		List<WebElement> cells = getElementsFromParent((WebElement)rows.toArray()[row-1], How.TAG_NAME, "td");
		return getText((WebElement)cells.toArray()[column-1]);
	}
}
