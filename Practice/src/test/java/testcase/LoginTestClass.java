package testcase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PageList;

import com.huice.auto.framework.page.BaseCase;

@Test
public class LoginTestClass extends BaseCase{

public PageList list=new PageList();
	
	@BeforeMethod
	public void initPage() {
		if(!list.isInit()){
			list.initPageList(driver);
		}
	}
	public void LoginTest() {
		list.loginPage.LoginAction("djb", "111111");
		list.logoutPage.LogoutAction();
	}

}
