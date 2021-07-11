package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavBar extends Base {
	// this line of the code is initializing the logger and needs to be done in each
	// class
	public static Logger log = LogManager.getLogger(Base.class);
	public WebDriver driver;

	@BeforeTest
	public void init() throws IOException {
		driver = initializeDriver();

		driver.get(prop.getProperty("url"));
		
		log.info("We have accessed the website...");
	}

	@AfterTest
	public void exit() {
		driver.quit();
	}

	@Test
	public void checkNavBar() throws IOException, InterruptedException {

		LandingPage lp = new LandingPage(driver);

//		WebDriverWait w = new WebDriverWait(driver, Long.parseLong(prop.getProperty("sec5")));
//		w.until(ExpectedConditions.visibilityOf(lp.getAdClose())).click();

		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("The navigation bar is displayed!");

	}

}
