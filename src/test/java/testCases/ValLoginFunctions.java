package testCases;

import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class ValLoginFunctions extends Base {// inheritance

	// we need to declare the WebDriver here because when wrapping every class as a
	// test
	// we start running the tests paralelly and because of that we cannot initialize
	// the driver
	// object multiple times at the same time. Thus we need to create public
	// WebDriver for this class
	public WebDriver driver;

	// this line of the code is initializing the logger and needs to be done in each
	// class
	public static Logger log = LogManager.getLogger(Base.class);

	@BeforeTest
	public void initDriver() throws IOException {
		driver = initializeDriver();
		log.info("Driver has been initialized!");
	}

	@BeforeMethod
	public void init() {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the url!");
	}

	@AfterTest
	public void exit() {
		driver.quit();
	}

	/*
	 * this dataProvider annotation sees how many columns there are in the getData
	 * method and automatically sends them together row many times.
	 * 
	 * we have to capture them sent data with that many objects
	 */
	@Test(dataProvider = "getData")
	public void DemoTest(String username, String password, String text) throws InterruptedException, IOException {

		LandingPage lp = new LandingPage(driver);

//		WebDriverWait w = new WebDriverWait(driver, Long.parseLong(prop.getProperty("sec5")));
//		w.until(ExpectedConditions.visibilityOf(lp.getAdClose())).click();

		LoginPage logp = lp.getLogin();

		logp.getEmailBox().sendKeys(username);
		logp.getPasswordBox().sendKeys(password);
		logp.getLoginButton().click();
		log.info(text);

		ForgotPassword fp = logp.getForgotPassword();
		fp.getEmail().sendKeys("xxxxxxx");
		fp.getsendMeInstructionsl().click();
	}

	@DataProvider
	public Object[][] getData() {

		/*
		 * rows stand for how many different data types test should run (rows is the
		 * first square brackets)
		 * 
		 * columns stand for how many values per each test
		 */
		Object[][] data = new Object[2][3];

		data[0][0] = "azer@azer.com";
		data[0][1] = "password";
		data[0][2] = "unathorized";

		data[1][0] = "valid@email.com";
		data[1][1] = "ValidPassword";
		data[1][2] = "authorized";

		return data;
	}

}
