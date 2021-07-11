package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	// this line of the code is initializing the logger and needs to be done in each
	// class
	public static Logger log = LogManager.getLogger(Base.class);
	public WebDriver driver;
	private LandingPage lp;

	@BeforeTest
	public void init() throws IOException {
		driver = initializeDriver();

		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public void exit() {
		driver.quit();
	}

	@Test
	public void checkText() throws IOException, InterruptedException {

		lp = new LandingPage(driver);

//		WebDriverWait w = new WebDriverWait(driver, Long.parseLong(prop.getProperty("sec5")));
//		w.until(ExpectedConditions.visibilityOf(lp.getAdClose())).click();

		AssertJUnit.assertEquals(lp.getFeatCours().getText(), "FEATURED COURSES");
		log.info("Successfully tested the title!");

	}
	
	@Test
	public void checkSubTitle() {
		lp = new LandingPage(driver);
		AssertJUnit.assertEquals(lp.getSubTitle().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}

}
