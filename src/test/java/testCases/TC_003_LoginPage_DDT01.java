package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.XLUtility;

public class TC_003_LoginPage_DDT01 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void test_LoginDDT(String email,String password,String exp)
	{
		logger.info(" Starting TC_003_LoginDDT01 ");
		
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
			lp.Login(rb.getString("email"), rb.getString("password"));
			
			/*
			 * lp.setEmail(email); logger.info("Provided Email ");
			 * 
			 * lp.setPassword(password); logger.info("Provided Password ");
			 * 
			 * lp.clklogin(); logger.info("Clicked on Login");
			 */
			
			
			boolean targetpage=lp.ismyAccountPageExists();
			
			if(exp.equals("Valid"))
			{
				if(targetpage==true)
				{
					logger.info("Login Success ");
					
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					logger.error("Login Failed ");
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
					MyAccountPage myaccpage=new MyAccountPage(driver);
					myaccpage.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{		
					logger.error("Login Failed ");
					Assert.assertTrue(true);
				}
			}
			
			
		}catch(Exception e)
		{
			logger.fatal("Login Failed ");
			Assert.fail();
		}
		
		logger.info(" Finished TC_003_LoginDDT01 ");
		
	}
	
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\LoginData1.xlsx";
		
		//XLUtility xlutil=new XLUtility(path);
		
		int totalrows=XLUtility.getRowCount(path,"Sheet1");	
		int totalcols=XLUtility.getCellCount(path,"Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= XLUtility.getCellData(path, "Sheet1", i, j);  //1,0
			}
		}
	return logindata;
				
	}
	
	
	
	
}