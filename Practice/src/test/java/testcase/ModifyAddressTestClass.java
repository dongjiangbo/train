package testcase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.PageList;

import com.huice.auto.framework.page.BaseCase;
@Test
public class ModifyAddressTestClass extends BaseCase{
public PageList list=new PageList();
	
	@BeforeMethod
	public void initPage() {
		if(!list.isInit()){
			list.initPageList(driver);
		}
	}
	
	public void modifyAddressTestCase(){
		list.loginPage.LoginAction("djb","111111");
		list.userPage.clickLeftMenu("收货地址");
		list.modifyAddressPage.modifyAddressAction();
		list.logoutPage.LogoutAction();
	}
}
