package com.amazonprimepack.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazonprimepack.util.LoggerUtil;

public class LoginPage {
	private static Logger logger;
	private Actions action;
	private WebElements webElements;
	public LoginPage(WebDriver driver, Actions action, Logger logger) {
		this.action = action;
		this.logger = logger;
		webElements=new WebElements(driver);
		PageFactory.initElements(driver, this);
	}

	public void performLogin(String userName, String password) {
		webElements.getAppEmail().sendKeys(userName);
		webElements.getAppPassword().sendKeys(password);
		logger.info("Calling the Logging Method");
		webElements.getSignInSubmit().click();
		logger.info("Calling the ViewList Method");
	    webElements.getViewList().click();
	}
}
