package testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PageList;

import com.huice.auto.framework.page.BaseCase;
@Test
public class UserTestClass extends BaseCase{
	public PageList list=new PageList();
	
	@BeforeMethod
	public void initPage() {
		if(!list.isInit()){
			list.initPageList(driver);
		}
	}
	
	public void userCenterTestCase() {
		list.loginPage.LoginAction("djb", "111111");
		list.userPage.clickLeftMenu("我的标签");
		list.userPage.clickLeftMenu("我的红包");
		list.logoutPage.LogoutAction();
	}
}
