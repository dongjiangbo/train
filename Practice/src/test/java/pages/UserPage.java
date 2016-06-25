package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;

import com.huice.auto.framework.selenium.BasePage;

public class UserPage extends BasePage{
	
	private String url="http://www.huicewang.com/ecshop/user.php";
	public UserPage(WebDriver driver) {
		super(driver);
	}
	public void clickLeftMenu(String menuName){
		open(url);
		List<WebElement> menus=getElementsFromeParentByHow(getElementByClassName("userMenu"),How.TAG_NAME,"a");
		for(WebElement menu:menus){
			if(getText(menu).contains(menuName)){
				click(menu);
				break;
			}
			
		}
	}

}
