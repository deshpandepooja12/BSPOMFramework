package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {

	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	HomePage homePage;
	
	@BeforeMethod
	public void Setup()
	{
		basepage = new BasePage();
		prop = basepage.init_properties();
		driver = basepage.init_driver(prop);
		loginpage = new LoginPage(driver);
		homePage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
			
	}
	
	@Test(priority=1)
	public void HomePageTitleTest()
	{
		String title=homePage.getHomePageTitle();
		System.out.println("Home Page Title is:"+title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void HomePageLogoTest()
	{
		
		Assert.assertTrue(homePage.isHomePageLogoVisible());
		System.out.println("BS logo is visible");
		
		
	}
	
	@Test
	public void loggedInUserTest()
	{
		Assert.assertTrue(homePage.isAccountNameVisible());
		String accountname = homePage.getAccountNameText();
		System.out.println("Account username is :"+accountname); 
		Assert.assertEquals(accountname,Constants.accountname);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}
	
	
	
}
