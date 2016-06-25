package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;
import org.testng.AssertJUnit;

import com.huice.auto.framework.selenium.BasePage;

public class LogoutPage extends BasePage{

	public LogoutPage(WebDriver driver) {
		super(driver);
		
	}
	public void LogoutAction(){
		waitForElement(How.LINK_TEXT,"退出",20);
		clickByText("退出");
		waitForElement(How.ID,"ECS_MEMBERZONE",20);
		AssertJUnit.assertTrue("检查是否成功登出", getText(How.ID,"ECS_MEMBERZONE").contains("欢迎光临本店"));
	}
	
}
