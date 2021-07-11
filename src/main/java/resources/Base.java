package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils; //this import is required for screenshot. for this to work, 
//we need to make sure we have added the maven repository dependency apache commons io 
//and make sure eclipse builds automatically
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	/*
	 * if we are running the test in parallel, it is not possible to have the driver in static because the new copy
	 * will not be shared between the test. However, to avoid this we can locally generate the driver object
	 * and assign base driver object to it.
	 * when running test in a sequence, it is better to have the driver object in static, because then there is
	 * no memory allocation for each driver in the memory.
	 */
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//resources//data.properties");

		prop.load(fis);

		/*
		 * in jenkins, there is an option where user can select which browser they want
		 * the test run. for that we need to tweak the code a little bit and tell the
		 * code instead of getting the browserName from .properties file, get it from
		 * the system. And system will have that information by using the following mvn
		 * command: mvn test -Dbrowser=chrome or whichever browser. that means we have
		 * to cancel the .properties file browser information pull request and again get
		 * it from the System
		 */
		String browserName = System.getProperty("browser"); //this code is to run with mvn test -Dbrowser="broswerName"
		// String browserName = prop.getProperty("browser");
//		String browserName = "chromeheadless";

		/*
		 * here we are trying to find out the type of the browser we are going to use.
		 */
		if (browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//main//java//resources//chromedriver");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless"))
				options.addArguments("headless");
//			options.setHeadless(true);
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "//src//main//java//resources//geckodriver");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "//src//main//java//resources//Windows8.1-KB2990999-x64.msu");
			driver = new InternetExplorerDriver();

		}

		// set implicit wait - general wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
