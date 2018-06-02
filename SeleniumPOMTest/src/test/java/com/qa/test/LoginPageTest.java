package com.qa.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyAccountPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	MyAccountPage myAccountPage;

	Logger log = Logger.getLogger(LoginPageTest.class);

	// initialize
	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		loginPage = homePage.loginFromHomePage();
	}


	@Test
	public void verifyUserLabelTest()
	{
		SoftAssert softAssert = new SoftAssert();
		String userLabel = loginPage.verifyUserLabel();
		softAssert.assertEquals(userLabel, "Hi, Khai");
		Assert.assertEquals(userLabel, "Hi, Khai");
		softAssert.assertAll();

	}
	
	@Test
	public void verifyMyAccountTest()
	{
		loginPage.viewMyAccount();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
