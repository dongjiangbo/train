package pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;

import com.huice.auto.framework.selenium.BasePage;

public class ModifyAddressPage extends BasePage{

	public ModifyAddressPage(WebDriver driver) {
		super(driver);
	}
	public void modifyAddressAction(){
		waitDurationTime(1,TimeUnit.SECONDS);
		selectRandomByIndex(How.NAME,"country",1);
		waitDurationTime(1,TimeUnit.SECONDS);
		selectRandomByIndex(How.NAME,"province",1);
		waitDurationTime(1,TimeUnit.SECONDS);
		selectRandomByIndex(How.NAME,"city",1);
		waitDurationTime(1,TimeUnit.SECONDS);
		selectRandomByIndex(How.NAME,"district",1);
		waitDurationTime(1,TimeUnit.SECONDS);
		typeByName("email",String.valueOf(new Random().nextInt(1000))+"@qq.com");
		typeByName("consignee","董江波");
		typeByName("address","123456789");
		typeByName("tel","15081841403");
		clickByName("submit");
		waitDurationTime(2,TimeUnit.SECONDS);
	}

}
