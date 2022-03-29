package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="//span[contains(text(),'My Account')]")
//	WebElement lnkMyaccount1;
	
//	@FindBy(xpath = "//ul[@class= 'dropdown-menu dropdown-menu-right']/li/a[text()='Logout']")
//	WebElement lnkLogout;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	

}
