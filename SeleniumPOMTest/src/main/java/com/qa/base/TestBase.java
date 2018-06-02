package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	// initialize and load configure properties
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase()
	{
		prop = new Properties();
		try {
			
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/"
													+ "com/qa/config/config.properties");
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//initialize driver
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriver"));
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgeDriver"));
			driver = new ChromeDriver();
		}
		
		if (browserName.equalsIgnoreCase("edge"))
		{
			// setup window size for edge
			Dimension eWindowSize = new Dimension(1024, 768);
			driver.manage().window().setSize(eWindowSize);
		}
		
		else
		{
			driver.manage().window().maximize();
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();		
		
		driver.get(prop.getProperty("url"));
		
		
		
		
	}
	

}
