package com.mercury.registrer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MercuryRegisterPage {
	public static WebDriver driver;
	public static Select s;
	
	@FindBy(name = "firstName") public WebElement firstName;
	
	@FindBy(name = "lastName") public WebElement lastName;
	
	@FindBy(name = "phone") public WebElement phone;
	
	@FindBy(id = "userName") public WebElement referenceMailId;
	
	@FindBy(name="address1") public WebElement address1;
	
	@FindBy(name="address2") public WebElement Address2;
	
	@FindBy(name="city") public WebElement city;
	
	@FindBy(name="state") public WebElement state;
	
	@FindBy(name="postalCode") public WebElement postalcode;
	
	@FindBy(name="country") public WebElement  dropDownForCountry;
	
	@FindBy(id="email") public WebElement mercuryMail;
	
	@FindBy(name="password") public WebElement password;
	
	@FindBy(name="confirmPassword") public WebElement conformPassword;
	
	@FindBy(name="register") public WebElement registerButton;
	
	public MercuryRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void firstNma(String firstname) {
		firstName.sendKeys(firstname);
	}
	
	public void lastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	
	public void phoneNumber(String mobile) {
		phone.sendKeys(mobile);
	}
	
	public void referanceMail(String refMail) {
		referenceMailId.sendKeys(refMail);
	}
	
	public void address1(String adres1) {
		address1.sendKeys(adres1);
	}
	
	public void address2(String addres2) {
		Address2.sendKeys(addres2);
	}
	
	public void cityName(String cityName) {
		city.sendKeys(cityName);
	}
	
	public void stateName(String statename) {
		state.sendKeys(statename);
		
	}
	
	public void postalCode(String postalCode) {
		postalcode.sendKeys(postalCode);
	}
	
	public void conuntryName() {
		
		Select country = new Select(dropDownForCountry);
		
		country.selectByVisibleText("INDIA");
		
	}
	
	public void mail(String mail) {
		mercuryMail.sendKeys(mail);
	}
	
	public void password(String pass) {
		password.sendKeys(pass);
	}
	
	public void conformationPassword(String con_pass) {
		conformPassword.sendKeys(con_pass);
	}
	
	public void clickRegisterbutton() {
		registerButton.click();
	}
	
	
	
}
