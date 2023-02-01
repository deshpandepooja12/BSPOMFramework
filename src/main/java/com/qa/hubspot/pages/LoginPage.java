package com.qa.hubspot.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementActions;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
		
	//1. Create OR/Page objects -> using by locator
	
	By userinputbox = By.xpath("//input[@id='react-select-2-input']");
	By paaswordinputbox = By.xpath("//input[@id='react-select-3-input']");
	By loginBtn = By.xpath("//button[@id='login-btn']");
	
	
	//2. Define a constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		elementActions = new ElementActions(driver);
	}
	
	//3. Page Actions/Methods
	public String getLoginPageTitle()
	{
		return elementActions.waitForPageTitle(Constants.LOGIN_PAGE_TITLE);
	}
	
	public HomePage doLogin(String username,String pwd) {
		
		
		elementActions.doSendkeys(userinputbox, username);
		driver.findElement(userinputbox).sendKeys(Keys.TAB);
		elementActions.doSendkeys(paaswordinputbox, pwd);
		driver.findElement(paaswordinputbox).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		elementActions.doClick(loginBtn);

		return new HomePage(driver);
		
	}
	
		
}
