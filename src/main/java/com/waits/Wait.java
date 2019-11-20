package com.waits;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	private static final List  = null;
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static void emlicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static WebElement waitElementToBeClickable(String typeOfLocator, String value) {
		wait = new WebDriverWait( driver, 20);
		WebElement element = null;
		if(typeOfLocator.equalsIgnoreCase("id")) {
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id(value)));
		}else if(typeOfLocator.equalsIgnoreCase("xpath")) {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(value)));
		}else if(typeOfLocator.equalsIgnoreCase("name")) {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.name(value)));
		}else if(typeOfLocator.equalsIgnoreCase("css")) {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(value)));
		}else if(typeOfLocator.equalsIgnoreCase("linkText")) {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(value)));
		}else if(typeOfLocator.equalsIgnoreCase("class")) {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.className(value)));
		}
		return element;
		
	}
	
	 
}
