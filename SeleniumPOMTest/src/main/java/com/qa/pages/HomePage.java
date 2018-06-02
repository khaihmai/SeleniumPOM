/**
 * 
 */
package com.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

/**
 * @author khaim
 *
 */
public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[@class='swa-header--link swa-header--login js-swa-header--login']")
	WebElement loginclick;
	
	@FindBy(xpath="//span[@class='swa-header--login-header']")
	WebElement loginText;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitBtn;
	
	
	// Page Factory initialization
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	// get SWA title page
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyClickOnLoginTitle()
	{
		loginclick.click();
		return loginText.getText();
	}
	
	public LoginPage loginFromHomePage() throws InterruptedException
	{
		String uid = prop.getProperty("username");
		String pass = prop.getProperty("password");
		System.out.println(uid);
		System.out.println(pass);
		loginclick.click();
		username.sendKeys(uid);
		Thread.sleep(3000);
		password.sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		submitBtn.submit();
		return new LoginPage();
		
	}
	
	

}
