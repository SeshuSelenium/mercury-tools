package com.realAnalist.cwcot;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

public class Logind_and_use {
	static String releaseModel = "78e15a30cb5ec3306753cdecbe1e68cd463b64f2f8607b88a2940a96d47fbd01";
	public static Select s;
	public static void getStringValue() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		LocalDateTime now = LocalDateTime.now();
		String stringdata = dtf.format(now);
		releaseModel = releaseModel+stringdata;
	}

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nagasesha Reddy\\eclipse-workspace\\RealAnalist\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		driver.get("https://rauat.modeloncloud.com/umg-admin/login");
		driver.findElement(By.name("j_username")).sendKeys("sysadmin");
		driver.findElement(By.name("j_password")).sendKeys("Welcome1");
		driver.findElement(By.xpath("//*[@class='login button']/child::a/input")).click();
//		try {
//			driver.navigate().refresh();	
//		}catch (Exception e) {
//			driver.navigate().refresh();
//		}
		driver.navigate().refresh();
		
		//WebElement tenent =driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-user']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='col-md-2'])[1]/child::button")));
		System.out.println("apply");
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@class='dropdown notifications-menu']/a/i")).click();	// tenent
		
		
		System.out.println("close");
		driver.findElement(By.xpath("//*[@class='menu']/child::li[8]")).click();		// for REIS
		//driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//*[text()='Yes']")).click();  // popup
		//driver.findElement(By.xpath("//*[text()='No']")).click();  //popup
		Thread.sleep(30000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='col-md-2'])[1]/child::button")));
		Thread.sleep(10000);
		driver.findElement(By.id("hm_lft_sdbar_Models")).click();	//models
		Thread.sleep(5000);
		driver.findElement(By.id("hm_lp_smp")).click();		// add
		//driver.findElement(By.id("hm_lp_vview")).click();		//manage / modify
//		String expect = driver.findElement(By.xpath("//div[@class='ag-row ag-row-even ag-row-level-0 ag-row-selected']//*[text()='PUBLISHED']")).getText();
//		String atual = "PUBLISHED";
//		if(expect.equalsIgnoreCase(atual)) {
//			System.out.println(atual);
//		}
		Thread.sleep(30000);
//		driver.findElement(By.xpath("//div[@class='ag-row ag-row-even ag-row-level-0 ag-row-selected']//*[text()='Automation']")).click();
		driver.findElement(By.id("createNewVersionTab")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("modelName_fv_sel")).click();
		driver.findElement(By.xpath("(//*[@id='modelName_fv_sel'])[1]/child::option[2]")).click();
		Thread.sleep(30000);
		driver.findElement(By.id("minorVer_hv")).click();
		Thread.sleep(30000);
		driver.findElement(By.id("majorVersions_hv")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@id='majorVersions_hv'])[1]/child::option[2]")).click();
//		driver.findElement(By.id("version_desc_fv")).sendKeys("autoTest");
		driver.findElement(By.xpath("(//*[@tooltip='Upload Document'])[1]")).click();
		Robot robot = new Robot();
		robot.setAutoDelay(3000);
		StringSelection stringselection = new StringSelection(
				"C:\\Users\\Nagasesha Reddy\\Desktop\\testRealAnalyse.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.setAutoDelay(3000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		
		System.out.println("success");
		
//		s = new Select(driver.findElement(By.id("pr_lng")));
	//	Thread.sleep(10000);
		//driver.findElement(By.id("clr_btn")).click();
		
		
		
	}

}
