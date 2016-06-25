package pages;

import org.openqa.selenium.WebDriver;

public class PageList {
	public LoginPage loginPage;
	public LogoutPage logoutPage;
	public UserPage userPage;
	public ModifyAddressPage modifyAddressPage;
	public ModifyInfoPage modifyInfoPage;
	public MessagePage messagePage;
	
	private boolean isInit=false;
	public void initPageList(WebDriver driver){
		this.loginPage=new LoginPage(driver);
		this.logoutPage=new LogoutPage(driver);
		this.userPage=new UserPage(driver);
		this.modifyAddressPage=new ModifyAddressPage(driver);
		this.modifyInfoPage=new ModifyInfoPage(driver);
		this.messagePage=new MessagePage(driver);
		this.isInit=true;
	}
	public boolean isInit(){
		return this.isInit;
	}
	
}
