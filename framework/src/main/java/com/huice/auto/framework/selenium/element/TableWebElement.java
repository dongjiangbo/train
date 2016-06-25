package com.huice.auto.framework.selenium.element;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class TableWebElement {

	/**
	 * 按索引获取Table中某单元格某类型的的对象
	 * 
	 * @param parent TR父节点对象
	 * @param row 行， 最小值为1
	 * @param column 列 ， 最小值为1
	 * @param tagName 类型
	 * @param index 索引从1开始
	 * @return
	 */
	protected WebElement getCellDataElement(WebElement parent, int row,
			int column, String tagName, int index) {
		List<WebElement> e = getCellDataElementList(parent, row, column,
				tagName);
		if (e.size() > 0) {
			if (index <= 0) {
				index = 0;
			} else if (index >= e.size()) {
				index = e.size() - 1;
			} else {
				index = index - 1;
			}
			return e.get(index);
		} else {
			return null;
		}
	}

	/**
	 * 获取某行单元格所有单元格,忽略隐藏元素
	 * 
	 * @param parent tr父节点对象
	 * @param row 行， 最小值为1
	 * @param column列 ， 最小值为1
	 * @param tagName 类型
	 * @return
	 */
	protected List<WebElement> getCellDataElementList(WebElement parent,
			int row, int column, String tagName) {
		return filterHideTag(getCellElement(parent, row, column).findElements(
				By.xpath("descendant::" + tagName)));
	}

	/**
	 * 获取行数量
	 * 
	 * @param parent
	 * @return
	 */
	protected int getRowNum(WebElement parent) {
		return getRowElementList(parent).size();
	}

	/**
	 * 获取列数量
	 * 
	 * @param parent tr父节点对象
	 * @param row 行， 最小值为1
	 * @return
	 */
	protected int getCellNum(WebElement parent, int row) {
		return getCellElementList(parent, row).size();
	}

	/**
	 * 获取行table中所有的行对象
	 * 
	 * @param parent tr父节点对象
	 * @return
	 */
	protected List<WebElement> getRowElementList(WebElement parent) {
		return filterHideTag(parent.findElements(By.xpath("child::tr")));
	}

	/**
	 * 获取table中单元格的对象
	 * 
	 * @param parent tr父节点对象
	 * @param row 行， 最小值为1
	 * @param column 列，最小值为1
	 * @return
	 */
	protected WebElement getCellElement(WebElement parent, int row, int column) {
		List<WebElement> e = getCellElementList(parent, row);
		if (e.size() > 0) {
			if (column <= 0) {
				column = 0;
			} else if (column >= e.size()) {
				column = e.size() - 1;
			} else {
				column = column - 1;
			}
			return e.get(column);
		} else {
			return null;
		}
	}

	/**
	 * 获取tabe中某行的所有单元格对象
	 * 
	 * @param parent tr父节点对象
	 * @param row 行， 最小值为1
	 * @return
	 */
	protected List<WebElement> getCellElementList(WebElement parent, int row) {
		List<WebElement> e = getRowElementList(parent);
		if (e.size() > 0) {
			if (row <= 0) {
				row = 0;
			} else if (row >= e.size()) {
				row = e.size() - 1;
			} else {
				row = row - 1;
			}

			int i = filterHideTag(
					e.get(row).findElements(By.xpath("child::th"))).size();
			if (i != 0) {
				return filterHideTag(e.get(row).findElements(
						By.xpath("child::th")));
			} else {
				return filterHideTag(e.get(row).findElements(
						By.xpath("child::td")));
			}
		} else {
			return null;
		}
	}

	/**
	 * 过滤隐藏标签
	 * 
	 * @param list
	 * @return
	 */
	private List<WebElement> filterHideTag(List<WebElement> list) {
		List<WebElement> li = new ArrayList<WebElement>();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getAttribute("type") != null) {
					if (list.get(i).getAttribute("type")
							.equalsIgnoreCase("hidden")) {

					} else {
						li.add(list.get(i));
					}
				} else if (list.get(i).isDisplayed()) {
					li.add(list.get(i));
				}
			}
		}
		return li;
	}
}
