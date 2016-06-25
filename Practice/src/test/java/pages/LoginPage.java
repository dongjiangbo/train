package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;

import com.huice.auto.framework.selenium.BasePage;


public class LoginPage extends BasePage{
	
	private String url="http://www.huicewang.com/ecshop/user.php";
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public void LoginAction(String username,String password){
		open(url);
		type(How.NAME,"username",username);
		type(How.NAME,"password",password);
		click(How.NAME,"submit");
		waitForElement(How.CLASS_NAME,"f4_b",30);
		assertElementText(How.CLASS_NAME,"f4_b",username);
	}

}
