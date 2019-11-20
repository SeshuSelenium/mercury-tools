package com.mercury.registrer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryFlightFinderPage {

	@FindBy(xpath ="//*[contains(@value,'roundtrip')]") public WebElement redioButtonRoundTrip;
	
	@FindBy(xpath = "//*[contains(@value,'oneway')]") public WebElement redioButtonOneWay;
	
	@FindBy(name="passCount") public WebElement passingersDropDown;
	
	@FindBy(name ="fromPort") public WebElement departingDropDown;
	
	@FindBy(xpath = "fromMonth") public WebElement departingMonth;
	
	@FindBy(name="fromDay") public WebElement gepartingDate;
	
	@FindBy(name = "toPort") public WebElement arrivalDropDown;
	
	@FindBy(name="toMonth") public WebElement arreivalMonth;
	
	@FindBy(name="toDay") public WebElement arreivalDay;
	
	@FindBy(xpath = "//*[contains(@value,'First')]") public WebElement redioButtonForFirstClass;
	
	@FindBy(xpath = "//*[contains(text(),'Economy class ')]") public WebElement redioButtonForEconomyClass;
	
	@FindBy(xpath = "//*[contains(@value,'Business')]") public WebElement redioButtonFoeBusinesClass;
	
	@FindBy(xpath = "//*[contains(@name,'findFlights')]") public WebElement continueButton;
	
	@FindBy(xpath = "//*[@name='airline']") public WebElement airlinesDropDown;
	
	public MercuryFlightFinderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void roundTripRadioButton() {
		redioButtonRoundTrip.click();
	}
	
	public void oneWayTripRadioButton() {
		redioButtonOneWay.click();
	}
	
	
	
	

}
