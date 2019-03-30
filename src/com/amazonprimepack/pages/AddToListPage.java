package com.amazonprimepack.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public class AddToListPage{

	private static Logger logger;
	private Actions actions;
	private WebElements webElements;
	
	public AddToListPage(WebDriver driver,Actions actions,Logger logger){
		this.actions=actions;
		this.logger=logger;
		webElements=new WebElements(driver);
		logger.info("Calling AddToList");
		PageFactory.initElements(driver, this);
	}
	
	public String getWishListName() {
		logger.info("Click On Add to List");
		return webElements.getWishListButton().getText();
	}
	
	
	public String getCreatList() {
		logger.info("Select Create List");
		return webElements.getCreateAList().getText();
	}
	
	public void clickOnImage() {
		logger.info("ClickOnImage");
		webElements.getClickOnImage().click();
	}

	public void saveToWatchList() {
		logger.info("Calling SaveToWatchList");
		Action sendPagedown1 = actions.sendKeys(Keys.PAGE_DOWN).build();
		sendPagedown1.perform();
		webElements.getWishListButton().click();
	}

	public void createList() throws InterruptedException {
		logger.info("Calling CreateList");
		webElements.getCreateAList().click();
		Thread.sleep(2000);
		webElements.getCreate().click();
		Thread.sleep(1000);
	}
	
	public void mouseHoveronaccountsandlists() throws InterruptedException {
		logger.info("MouseHover on Accounts and Lists");
		Thread.sleep(500);
		actions.moveToElement(webElements.getAccounts()).build().perform();
		Thread.sleep(500);
	}
	
	public void yourlists() throws InterruptedException {
		logger.info("Selected Products gets displayed");
		Thread.sleep(500);
		webElements.getNavLinkAccountList().click();
		actions.moveToElement(webElements.getNavLinkAccountList()).build().perform();
		Thread.sleep(500);
	}
}
