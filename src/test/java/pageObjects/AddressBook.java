package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class AddressBook extends BaseClass {
	
	public  WebDriver driver;

	public AddressBook(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		
	}

}
