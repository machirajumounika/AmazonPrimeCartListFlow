package com.amazonprimepack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebElements {
	
	public WebElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(className="s-image")
	private WebElement clickOnImage;
	
	@FindBy(id="add-to-wishlist-button-submit")
	private WebElement wishListButton;
	
	@FindBy(partialLinkText="Create a List")
	private WebElement createAList;
	
	@FindBy(xpath="//*[@id='WLNEW_create']/span/span/input")
	private WebElement create;
	
	@FindBy(partialLinkText="Your List")
	private WebElement navLinkAccountList;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
	private WebElement accounts;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchTextBox;
	
	@FindBy(id = "ap_email")
	private WebElement appEmail;

	@FindBy(id = "ap_password")
	private WebElement appPassword;

	@FindBy(id = "signInSubmit")
	private WebElement signInSubmit;

	@FindBy(id = "WLHUC_viewlist")
	private WebElement viewList;

	/**
	 * @return the clickOnImage
	 */
	public WebElement getClickOnImage() {
		return clickOnImage;
	}

	/**
	 * @return the wishListButton
	 */
	public WebElement getWishListButton() {
		return wishListButton;
	}

	/**
	 * @return the createAList
	 */
	public WebElement getCreateAList() {
		return createAList;
	}

	/**
	 * @return the create
	 */
	public WebElement getCreate() {
		return create;
	}

	/**
	 * @return the navLinkAccountList
	 */
	public WebElement getNavLinkAccountList() {
		return navLinkAccountList;
	}

	/**
	 * @return the accounts
	 */
	public WebElement getAccounts() {
		return accounts;
	}

	/**
	 * @return the submitButton
	 */
	public WebElement getSubmitButton() {
		return submitButton;
	}

	/**
	 * @return the searchTextBox
	 */
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	/**
	 * @return the appEmail
	 */
	public WebElement getAppEmail() {
		return appEmail;
	}

	/**
	 * @return the appPassword
	 */
	public WebElement getAppPassword() {
		return appPassword;
	}

	/**
	 * @return the signInSubmit
	 */
	public WebElement getSignInSubmit() {
		return signInSubmit;
	}

	/**
	 * @return the viewList
	 */
	public WebElement getViewList() {
		return viewList;
	}
}
