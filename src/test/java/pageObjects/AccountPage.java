package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
	
	public  WebDriver driver;
	
	@FindBy(name="email")
	WebElement txtEmail;

	

}
