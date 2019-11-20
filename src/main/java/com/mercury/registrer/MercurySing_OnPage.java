package com.mercury.registrer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MercurySing_OnPage {
	
	@FindBy(xpath = "//*[contains(text(),'SIGN-')]") public WebElement sing_on;
	
	@FindBy(name="userName") public WebElement logINuserName;
	
	@FindBy(name="password") public WebElement logINpassword;
	
	@FindBy(name="login") public WebElement logINbutton;
	
	
	
}
