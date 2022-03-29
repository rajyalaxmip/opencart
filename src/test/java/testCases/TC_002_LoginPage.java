package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginPage extends BaseClass {
	LoginPage lp;
	AccountPage accpage;
	MyAccountPage myaccpage;
 
@Test(groups = {"sanity","master"})	
public void test_login()
 {
	   logger.info("Starting TC_002_Login test case");
//HomePage   
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();				
//Login Page
		
		lp = new LoginPage(driver);		
		accpage=lp.Login(rb.getString("email"), rb.getString("password"));
//title
		String Title= lp.validateLoginPageTitle();
		Assert.assertEquals(Title, "My Account");
		
		//myaccpage = new MyAccountPage(driver);
		//myaccpage.clickLogout();
		
		
		}
		
	
}