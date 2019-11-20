package mercuryTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mercury.excelData.ExcelDataValidation;
import com.mercury.registrer.MercuryRegisterPage;

public class MercuryToolsValidation {

	String welcome_massege =  "Thank you for registering You may now";
	public String sheetName = "registerPage";
	public static WebDriver driver;
	public ExcelDataValidation excellData;
	public static String excelFilePath = "E:\\merurytoursInputData\\mercury.xlsx";
	public MercuryToolsValidation mercury;
//	public MercuryToolsValidation(String sheetName) {
//		this.sheetName=sheetName;
//	}
	
	@BeforeTest
	public void precondition() {
		System.setProperty("webdriver.chrome.driver", "E:\\Drivers\\chromedriver75\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		//mercury = new MercuryToolsValidation("registerPage");
		
	}
	@Test
	public void registerPage() throws IOException {
		excellData = new ExcelDataValidation();
		excellData.ExcelData(excelFilePath);
		
		MercuryRegisterPage register = new MercuryRegisterPage(driver);
		String firstName = excellData.getStringExcelData(sheetName, 1, 2);
		register.firstNma(firstName);
		String lastName = excellData.getStringExcelData(sheetName, 2, 2);
		register.lastName(lastName);
		long mobile = (long)excellData.getIntegerExcelData(sheetName, 3, 2);
		//long l = mobile;
		String mob = Long.toString(mobile);
		register.phoneNumber(mob);
		String referenceMail = excellData.getStringExcelData(sheetName, 4, 2);
		register.referanceMail(referenceMail);
		String address1 = excellData.getStringExcelData(sheetName, 5, 2);
		register.address1(address1);
		String address2 = excellData.getStringExcelData(sheetName, 6, 2);
		register.address2(address2);
		String city = excellData.getStringExcelData(sheetName, 7, 2);
		register.cityName(city);
		String state = excellData.getStringExcelData(sheetName, 8, 2);
		register.stateName(state); 
		long postalCode =(long) excellData.getIntegerExcelData(sheetName, 9, 2);
		System.out.println(postalCode);
		String postal = Long.toString(postalCode);
		register.postalCode(postal);
//		register.conuntryName();
//		Select dropdown = new Select(driver.findElement(By.name("country")));
//		List<WebElement> coun = dropdown.getOptions();
		register.conuntryName();
		
//		WebElement country = driver.findElement(By.name("country"));
//		Select s = new Select(country);
//		s.selectByVisibleText("INDIA");
		String mail = excellData.getStringExcelData(sheetName, 11, 2);
		register.mail(mail);
		String password = excellData.getStringExcelData(sheetName, 12, 2);
		register.password(password);
		String conformPassword = excellData.getStringExcelData(sheetName, 13, 2);
		register.conformationPassword(conformPassword);
		register.clickRegisterbutton();
		String expectedResult = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
		String actualResult = driver.findElement(By.xpath("//*[contains(text(),'Thank you for registering.')]")).getText();
		System.out.println(welcome_massege);
		if(expectedResult.equalsIgnoreCase(actualResult)) {
			System.out.println("expected result and atual result matched. # TC_UI_001 passed");
			
		}
		
	
	}
	@AfterTest
	public void PostCondition() {
		//driver.close();
	}
}
