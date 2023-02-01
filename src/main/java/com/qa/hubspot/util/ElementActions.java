package com.qa.hubspot.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {

	WebDriver driver;
	
	public ElementActions(WebDriver driver)
	{
		this.driver=driver;
	}
	
	/**
	 * This method helps to find the element on the basis of the locator.
	 * @param locator
	 */
	public WebElement getElement(By locator)
	{
		waitForElementPresent(locator);
		WebElement element = null;
		try {
			element=driver.findElement(locator);
		}
		catch(Exception e)
		{
			System.out.println("Some exception occured while creating the element" +locator);
		}
		
		return element;
	}
	
	public void waitForElementPresent(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void doClick(By locator)
	{
		try {
			getElement(locator).click();
			
		}catch(Exception e) {
			System.out.println("Some exception occured while clicking the element"+locator);
		}
		
	}
	
	public void doSendkeys(By locator,String value)
	{
		try {
			
			getElement(locator).sendKeys(value);
		}catch(Exception e)
		{
			System.out.println("Some exception occured while sending keys"+locator);
		}
		
		
	}
	
	public String doGetText(By locator)
	{
		String text=null;
		try
		{
		text = getElement(locator).getText();
		}catch(Exception e)
		{
			System.out.println("Some exception occured while getting text of the element"+locator);
		}
		return text;
	}
	
	
	public String waitForPageTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public Boolean isElementDisplayed(By locator)
	{
		try
		{
			return getElement(locator).isDisplayed();
		}catch(Exception e)
		{
			System.out.println("Element is not visible" +locator);
			return false;
		}
	}
	
	public void switchToFrame(String framename)
	{
		try
		{
			driver.switchTo().frame(framename);
		}catch(Exception e)
		{
			System.out.println("Unable to switch to frame with given name"+framename);
		}
	}
	
	public void selectByValue(By Locator, String value)
	{
		
			Select s = new Select(driver.findElement(Locator));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
			s.selectByValue(value);
			
			}
	


	public void selectValue(By Locator, String value)
	{
		
		List<WebElement> usernames = driver.findElements(Locator);
		
	}
}