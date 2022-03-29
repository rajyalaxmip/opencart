package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {
	
@Test(groups = {"regression","master"})
public void test_account_Registration()
 {
	try
	 {
		logger.info("Starting the first test case");
		driver.get(rb.getString("appURL"));
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName("Jon");
		regpage.setLastName("Candy");
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone("65656123");
		regpage.setPassword("abcx1z");
		regpage.setConfirmPassword("abcx1z");
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		String confmsg=regpage.getConfMessage();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Success");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Failed");
			Assert.assertTrue(false);
		}
		
	 }catch (Exception e) {
		logger.error("Registration Failed");
		Assert.fail();
	}
	logger.info("Finished the first test case");
		
	}
		
	
}