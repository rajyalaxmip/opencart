package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//a[text()='Your Store']")
	WebElement msgHeader;
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccount;
			
	
//	public void setEmail(String email)
//	{
//		txtEmail.sendKeys(email);
//	}
//	
//	public void setPassword(String pwd)
//	{
//		txtPassword.sendKeys(pwd);
//	}
//	
//	public void clklogin()
//	{
//		btnLogin.click();
//	}
	
	public AccountPage Login(String email,String pwd) {
		txtEmail.sendKeys(email);
		txtPassword.sendKeys(pwd);
		btnLogin.click();
		return new AccountPage();
		
	}
	
	public String getHeader()
	{
		return(msgHeader.getText());
	}
	
	public String validateLoginPageTitle()
	{
		return (driver.getTitle());
	
	}
	
	public boolean ismyAccountPageExists(){
	{
		try 
		{
			return(myAccount.isDisplayed());
			
		} catch (Exception e) {
			return(false);
		}
	}		
		
	}	

}
