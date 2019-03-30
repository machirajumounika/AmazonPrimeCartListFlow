package com.amazonprimepack;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.amazonprimepack.pages.AddToListPage;
import com.amazonprimepack.pages.HomePage;
import com.amazonprimepack.pages.LoginPage;
import com.amazonprimepack.util.LoggerUtil;

public class TestAmazonCartList {

	private static WebDriver driver;
	private AddToListPage addToList;
	private Actions actions;

	private HomePage homePage;
	private LoginPage loginPage;
	private static final Logger logger = LoggerUtil.getLoggerUtil();
	private static final String DRIVER = "webdriver.chrome.driver";
	private static final String DIVER_LOCATION = "C:\\Users\\Owner\\Desktop\\SELENIUM  FILES\\Exe files\\chromedriver.exe";
	private static final String LOGINID = "mmounika92@gmail.com";
	private static final String PASSWORD = "Qweasdzxc87";
	
	public void start() {
		try {
			logger.info("Redirect to Amazon Website");
			System.setProperty(DRIVER, DIVER_LOCATION);
			driver = new ChromeDriver();
			driver.get("http://www.amazon.com");
			driver.manage().window().maximize();
			logger.info("Maximizing the Screen");
			actions = new Actions(driver);
			homePage = new HomePage(driver, actions, logger);
			loginPage = new LoginPage(driver, actions, logger);
			addToList = new AddToListPage(driver, actions, logger);
			test_Home_Page();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void test_Home_Page() throws Exception {
		
		homePage.testSearchTextBox("mobile phone");
		Thread.sleep(6000);
		logger.info("Testing the PageDown Functionality ");
		homePage.testPageDown();

		addToList.clickOnImage();

		addToList.saveToWatchList();
		Thread.sleep(5000);

		loginPage.performLogin(LOGINID, PASSWORD);
		Assert.assertTrue(addToList.getCreatList().contains("Create a List"));
		addToList.createList();

		Thread.sleep(5000);
		addToList.mouseHoveronaccountsandlists();
		addToList.yourlists();
		Thread.sleep(5000);
		logger.info("End of the execution");
		driver.close();

	}
}
