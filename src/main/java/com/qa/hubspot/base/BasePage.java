package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties prop;
	
	public WebDriver init_driver(Properties prop)
	{
		String browser = prop.getProperty("browser");
		
	if(browser.equals("chrome"))
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}else if(browser.equals("firefox"))
	{
			
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
	}
	else
	{
		System.out.println("Please provide a proper browser value..");
	}
	
	driver.manage().window().fullscreen();
	
	driver.get(prop.getProperty("url"));
	return driver;
}
	
	public Properties init_properties()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src/main/java/com/qa/hubspot/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return prop;
		
		
	}
}

