package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddressBook {
	
	public  WebDriver driver;

	public AddressBook(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

}
