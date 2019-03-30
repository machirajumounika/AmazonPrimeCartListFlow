package com.amazonprimepack.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	private WebDriver driver;
	private static Logger logger;
	private Actions actions;
	private WebElements webElements;
	
	public HomePage(WebDriver driver,Actions action,Logger logger) {
		this.actions=action;
		this.driver=driver;
		this.driver=driver;
		this.logger=logger;
		webElements=new WebElements(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getSearchTextBox() {
		logger.info("Entering the text in search bar");
		return webElements.getSearchTextBox().getTagName();
	}

	public void testSearchTextBox(String text) throws Exception {
		logger.info("After entering the text in search bar");
		webElements.getSearchTextBox().sendKeys(text);
		webElements.getSubmitButton().click();
	}

	public void testPerformSlowness() {
		logger.info("Opening Product Page");
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();
	}

	public void testPageDown() {
		logger.info("Scrolling PageDown");
		Action sendPagedown = actions.sendKeys(Keys.PAGE_DOWN).build();
		sendPagedown.perform();
		
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
