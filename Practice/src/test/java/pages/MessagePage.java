package pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;

import com.huice.auto.framework.selenium.BasePage;

public class MessagePage extends BasePage{

	public MessagePage(WebDriver driver) {
		super(driver);
	}
	public void messageAction(String message) {
		clickForRadioByIndex(How.NAME, "msg_type", new Random().nextInt(5) +1);
		typeByName("msg_title", "留言标题");
		typeByName("msg_content", message);
		click(How.CLASS_NAME, "bnt_bonus");
	}
	
	public void deleteMessageAction() {
		waitForElement(How.LINK_TEXT, "删除", 20);
		clickByText("删除");
		assertAlertText("你确实要彻底删除这条留言吗？");
		accept();
	}

}
