package com.amazonprimepack.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonprimepack.TestAddToCart;
import com.amazonprimepack.util.LoggerUtil;

public class LoginPage {
	private static Logger logger;
	private Actions action;
	@FindBy(id = "ap_email")
	WebElement appEmail;

	@FindBy(id = "ap_password")
	WebElement appPassword;

	@FindBy(id = "signInSubmit")
	WebElement signInSubmit;

	@FindBy(id = "WLHUC_viewlist")
	WebElement viewList;

	public LoginPage(WebDriver driver, Actions action, Logger logger) {
		this.action = action;
		this.logger = logger;
		PageFactory.initElements(driver, this);
	}

	public void performLogin(String userName, String password) {
		appEmail.sendKeys(userName);
		appPassword.sendKeys(password);
		logger.info("Calling the Logging Method");
		signInSubmit.click();
		logger.info("Calling the ViewList Method");
		viewList.click();
	}
}
