package com.amazonprimepack.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazonprimepack.TestAddToCart;
import com.amazonprimepack.util.LoggerUtil;

public class AddToListPage{
	
	@FindBy(className="s-image")
	WebElement clickOnImage;
	
	@FindBy(id="add-to-wishlist-button-submit")
	WebElement wishListButton;
	
	@FindBy(partialLinkText="Create a List")
	WebElement createAList;
	
	@FindBy(xpath="//*[@id='WLNEW_create']/span/span/input")
	WebElement create;
	
	@FindBy(partialLinkText="Your List")
	WebElement navLinkAccountList;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
	WebElement accounts;
	
	private static Logger logger;
	private Actions actions;
	
	public AddToListPage(WebDriver driver,Actions actions,Logger logger){
		this.actions=actions;
		this.logger=logger;
		logger.info("Calling AddToList");
		PageFactory.initElements(driver, this);
	}
	
	public String getWish() {
		logger.info("Calling Get WishList");
		return wishListButton.getText();
	}
	
	
	public String getCreatList() {
		logger.info("Calling Create List");
		return createAList.getText();
	}
	


	public void clickOnImage() {
		logger.info("Calling ClickOnImage");
		clickOnImage.click();
	}

	public void saveToWatchList() {
		logger.info("Calling SaveToWatchList");
		Action sendPagedown1 = actions.sendKeys(Keys.PAGE_DOWN).build();
		sendPagedown1.perform();
		wishListButton.click();
	}

	public void createList() throws InterruptedException {
		logger.info("Calling CreateList");
		createAList.click();
		Thread.sleep(2000);
		create.click();
		Thread.sleep(1000);
	}
	
	public void mouseHover() throws InterruptedException {
		logger.info("Calling MouseHover");
		Thread.sleep(500);
		actions.moveToElement(accounts).build().perform();
		Thread.sleep(500);
	}
	
	public void clickOnYourOrders() throws InterruptedException {
		logger.info("Calling Click On Your Orders");
		Thread.sleep(500);
		navLinkAccountList.click();
		actions.moveToElement(navLinkAccountList).build().perform();
		Thread.sleep(500);
	}
}
