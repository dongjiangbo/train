package testcase;

import org.testng.annotations.BeforeMethod;


import org.testng.annotations.Test;

import pages.PageList;

import com.huice.auto.framework.page.BaseCase;
@Test
public class MessageTestClass extends BaseCase{
public PageList list=new PageList();
	
	@BeforeMethod
	public void initPage() {
		if(!list.isInit()){
			list.initPageList(driver);
		}
	}
	public void messageTestCase(){
		list.loginPage.LoginAction("djb","111111");
		list.userPage.clickLeftMenu("我的留言");
		list.messagePage.messageAction("aaaaaaa");
		list.messagePage.deleteMessageAction();
		list.logoutPage.LogoutAction();
	}
}
