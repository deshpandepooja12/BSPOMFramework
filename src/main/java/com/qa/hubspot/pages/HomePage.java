package com.qa.hubspot.pages;


import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;


public class HomePage extends BasePage{

	WebDriver driver;
	Properties prop;
	ElementActions elementActions;
	
	//locators
	By BSLogo = By.xpath("//a[@class='Navbar_logo__26S5Y']");
	By accountName = By.xpath("//span[contains(text(),'demouser')]");
	
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	//Page Actions
	public String getHomePageTitle()
	{
		return elementActions.waitForPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	public boolean isHomePageLogoVisible()
	{
		
		return elementActions.isElementDisplayed(BSLogo);
		
	}

	
	public boolean isAccountNameVisible()
	{
		return elementActions.isElementDisplayed(accountName);
	}
	
	public String getAccountNameText()
	{
		
		return elementActions.doGetText(accountName);
	}
	
		
	
	
}
