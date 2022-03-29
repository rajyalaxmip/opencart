package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginPage2 extends BaseClass {
	LoginPage lp;
	AccountPage accpage;
	MyAccountPage myaccpage;
 
@Test(groups = {"sanity","master"})	
public void test_Login()
{
	logger.info(" Starting TC_002_Login ");
	
	try
	{
		driver.get(rb.getString("appURL"));
		logger.info("Home Page Displayed ");
		
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account ");
		hp.clickLogin();
		logger.info("Clicked on Login ");
		
		LoginPage lp=new LoginPage(driver);
		accpage=lp.Login(rb.getString("email"), rb.getString("password"));
		//title
		String Title= lp.validateLoginPageTitle();
		Assert.assertEquals(Title, "My Account");
		
		/*
		 * lp.setEmail(rb.getString("email")); logger.info("Provided Email ");
		 * 
		 * lp.setPassword(rb.getString("password")); logger.info("Provided Password ");
		 * 
		 * lp.clickLogin(); logger.info("Clicked on Login");
		 */
		
		
		boolean targetpage=lp.ismyAccountPageExists();
		
		if(targetpage)
		{
			logger.info("Login Success ");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login Failed ");
			Assert.assertTrue(false);
		}
	}	
	catch(Exception e)
	{
		logger.fatal("Login Failed ");
		Assert.fail();
	}
	
	logger.info(" Finished TC_002_Login ");
	
}

	
}