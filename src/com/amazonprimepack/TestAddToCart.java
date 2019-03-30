package com.amazonprimepack;

import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;

import com.amazonprimepack.pages.AddToListPage;
import com.amazonprimepack.pages.HomePage;
import com.amazonprimepack.pages.LoginPage;
import com.amazonprimepack.util.LoggerUtil;

public class TestAddToCart {

	protected static WebDriver driver;
	private AddToListPage addToList;
	protected Actions actions;

	private HomePage homePage;
	private LoginPage loginPage;
	private static Logger logger = LoggerUtil.getLoggerUtil();
	private static String DRIVER = "webdriver.chrome.driver";
	private static final String DIVER_LOCATION = "C:\\Users\\Owner\\Desktop\\SELENIUM  FILES\\Exe files\\chromedriver.exe";
	private FileAppender fh;

	public TestAddToCart() {
		try {
			logger.info("Logging in to Amazon");
			System.setProperty(DRIVER, DIVER_LOCATION);
			driver = new ChromeDriver();
			driver.get("http://www.amazon.com");
			driver.manage().window().maximize();
			logger.info("Logging in to Amazon");
			this.actions = new Actions(driver);
			this.test_Home_Page();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test_Home_Page() throws Exception {
		addToList = new AddToListPage(driver, actions, logger);
		homePage = new HomePage(driver, actions, logger);
		loginPage = new LoginPage(driver, actions, logger);
		homePage.testSearchTextBox("mobile phone");
		Thread.sleep(6000);
		logger.info("Testing the PageDown Functionality ");
		homePage.testPageDown();

		addToList.clickOnImage();

		addToList.saveToWatchList();
		Thread.sleep(5000);

		loginPage.performLogin("mmounika92@gmail.com", "Qweasdzxc87");
		Assert.assertTrue(addToList.getCreatList().contains("Create a List"));
		addToList.createList();

		Thread.sleep(5000);
		addToList.mouseHover();
		addToList.clickOnYourOrders();
		Thread.sleep(5000);
		driver.close();

	}
}
