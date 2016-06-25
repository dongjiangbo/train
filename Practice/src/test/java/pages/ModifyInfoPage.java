package pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;

import com.huice.auto.framework.selenium.BasePage;

public class ModifyInfoPage extends BasePage{

	public ModifyInfoPage(WebDriver driver) {
		super(driver);
	}
	public void modifyinfoAction(){
		waitForElement(How.NAME,"birthdayYear",20);
		selectRandomByIndex(getElementByName("birthdayYear"),1);
		waitForElement(How.NAME,"birthdayMonth",20);
		selectRandomByIndex(getElementByName("birthdayMonth"),1);
		waitForElement(How.NAME,"birthdayDay",20);
		selectRandomByIndex(getElementByName("birthdayDay"),1);
		waitForElement(How.NAME,"sex",20);
		clickForRadioByIndex(How.NAME,"sex",new Random().nextInt(3)+1);
		typeByName("email",String.valueOf(new Random().nextInt(10000))+"@qq.com");
		typeByName("extend_field1",String.valueOf(new Random().nextInt(10000))+"@qq.com");
		typeByName("extend_field2",String.valueOf(new Random().nextInt(10000)));
		typeByName("extend_field3",String.valueOf(new Random().nextInt(10000)));
		typeByName("extend_field4",String.valueOf(new Random().nextInt(10000)));
		typeByName("extend_field5",String.valueOf(new Random().nextInt(10000)));
		selectRandomByIndex(How.NAME,"sel_question",1);
		typeByName("passwd_answer","111111");
		clickByName("submit");
		waitDurationTime(2,TimeUnit.SECONDS);
	}
}
