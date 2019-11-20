package com.realAnalist.cwcot;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailFileUpload {
	public WebDriver driver;
	public WebDriverWait wait;
	public Robot robot;

	Properties prop;

	@BeforeTest(groups = { "sanity", "smoke", "regression" })
	public void mainPrecondition() throws Exception {
		prop = new Properties();
		FileInputStream input = new FileInputStream(
				"C:\\Users\\Nagasesha Reddy\\eclipse-workspace\\mercuryTools\\src\\main\\java\\config.properties");
		prop.load(input);
		System.setProperty("webdriver.chrome.driver",prop.getProperty("chromeDriverPath"));
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	@Test(priority = 0, groups = { "sanity", "smoke", "regression" })
	public void logIn() throws Exception {
		String userName = prop.getProperty("userLogInId");
		if (userName.length() >= 5 && userName.length() <= 50) {
			driver.findElement(By.id("identifierId")).sendKeys(userName);
		} else {
			System.out.println("your user-name shouid be between 5 to 50 charecters");
		}

		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);

		String userPass = prop.getProperty("userPassword");

		if (userPass.length() >= 5 && userPass.length() <= 15) {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			// driver.findElement(By.xpath("//*[text()='Enter your
			// password']")).sendKeys(userPass);
			element.sendKeys(userPass);
		} else {
			System.out.println("your password should be between 5 to 15 charecters");
		}
		driver.findElement(By.id("passwordNext")).click();

		String button = driver.findElement(By.xpath("//*[text()='Compose']")).getText();
		System.out.println(button);
		String expected = "Compose";
		// Assert.assertEquals(expected, button);
		if (button.equalsIgnoreCase(expected)) {
			System.out.println("actual and expected is matched");
		} else {
			System.out.println("actual and expected is not  matched");

		}
	}

	@Test(priority = 1, groups = { "smoke", "regression" })
	public void composeMail() {

		driver.findElement(By.xpath("//*[text()='Compose']")).click();

		driver.findElement(By.name("to")).sendKeys(prop.getProperty("sendToMail"));

		driver.findElement(By.name("subjectbox")).sendKeys(prop.getProperty("sub"));

		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys(prop.getProperty("msg") + "\n"
				+ prop.getProperty("main") + "\n\n" + prop.getProperty("regards") + "\n" + prop.getProperty("name"
						));

	}

	@Test(priority = 2, groups = { "regression" })
	public void uplosdResume() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.MINUTES);
		// driver.findElement(By.id("attachCV")).click();
		driver.findElement(By.xpath("//*[@class='btC']/child::td[4]/child::div/div[1]/div")).click();
		robot = new Robot();
		robot.setAutoDelay(3000);
		StringSelection stringselection = new StringSelection(prop.getProperty("attachmentPath"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.setAutoDelay(3000);
		driver.findElement(By.xpath("//*[text()='Send']")).click();
		
		String mailStatus = driver.findElement(By.xpath("//*[text()='Message sent.']")).getText();
		String actualMailStatus = "Message sent.";
		if (mailStatus.equalsIgnoreCase(actualMailStatus)) {
			System.out.println("Message sent.");
		}
	}

}
