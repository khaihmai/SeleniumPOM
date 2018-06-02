package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Create PageFactory or objects repositories
	
	@FindBy(xpath ="//span[@class='swa-header--hot-state-name']")
	WebElement userNamelabel;
	
	@FindBy(xpath="//a[@href='/myaccount']")
	WebElement myaccount;
	
	//Initialize LoginPage object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String verifyUserLabel()
	{
		return userNamelabel.getText();
	}
	
	public MyAccountPage viewMyAccount()
	{
		myaccount.click();
		return new MyAccountPage();
	}
	
	
	
	

}
