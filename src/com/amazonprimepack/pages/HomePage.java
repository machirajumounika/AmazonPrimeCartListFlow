package com.amazonprimepack.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonprimepack.TestAddToCart;
import com.amazonprimepack.util.LoggerUtil;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	private WebDriver driver;
	private static Logger logger;
	private Actions actions;
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitButton;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement wishListButton;
	
	public HomePage(WebDriver driver,Actions action,Logger logger) {
		this.actions=action;
		this.driver=driver;
		this.driver=driver;
		this.logger=logger;
		PageFactory.initElements(driver, this);
	}
	
	public String getSearchTextBox() {
		logger.info("Calling Get SearchTextBox method");
		return wishListButton.getTagName();
	}

	public void testSearchTextBox(String text) throws Exception {
		logger.info("Calling SearchTextBox method ");
		wishListButton.sendKeys(text);
		submitButton.click();
	}

	public void testPerformSlowness() {
		logger.info("Calling Test Perfrom Method");
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();
	}

	public void testPageDown() {
		logger.info("Calling Test PageDown");
		Action sendPagedown = actions.sendKeys(Keys.PAGE_DOWN).build();
		sendPagedown.perform();
		logger.info("Calling Test SendPageDown");
		
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
