package com.realAnalist.cwcot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload {
	public WebDriver driver;
	public WebDriverWait wait;
	public Robot robot;

	@BeforeTest
	public void main() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nagasesha Reddy\\eclipse-workspace\\RealAnalist\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		System.out.println("wait 60 min");
		driver.get("https://www.naukri.com/mnjuser/profile?id=&orgn=homepage");
	}

	@Test(priority = 0)
	public void logIn() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		driver.findElement(By.id("usernameField")).sendKeys("nagasesha999@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("darling143");
		driver.findElement(By.xpath("(//*[text()='Login'])[3]")).click();
	}

	@Test(priority = 1)
	public void uplosdResume() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id= 'attachCV' and @class ='fileUpload waves-effect waves-light btn-large']"))
				.click();

		robot = new Robot();
		robot.setAutoDelay(3000);
		StringSelection stringselection = new StringSelection(
				"C:\\Users\\Nagasesha Reddy\\Desktop\\Resume-3.3years\\Selenium3+yearsResume.doc");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
