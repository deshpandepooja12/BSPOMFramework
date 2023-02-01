package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest {

	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	
	@BeforeMethod
	public void Setup()
	{
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
			
	}
	
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title = loginpage.getLoginPageTitle();
		System.out.println("LoginPage title is:"+ title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
		
	@Test(priority=2)
	public void LoginTest()
	{
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	
}
