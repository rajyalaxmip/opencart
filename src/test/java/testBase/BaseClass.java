package testBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	public WebDriver driver;
	public Logger logger;//for logging
	public ResourceBundle rb;
	
	@BeforeClass(groups = {"master","sanity","regression"})
	@Parameters({"browser"})
	public void setup(String br)
	{
		//loading Config File//
		rb=ResourceBundle.getBundle("config");
		//for logging//
		logger = LogManager.getLogger(this.getClass());
		
		//for Drivers
		if (br.equals("chrome"))
		{
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();		
		}
		else if (br.equals("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
		
	}
	
	@AfterClass
	public void tearDown()
	{
	driver.close();
	}	
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public int randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(5);
		return (Integer.parseInt(generatedString2));
	}
	
}