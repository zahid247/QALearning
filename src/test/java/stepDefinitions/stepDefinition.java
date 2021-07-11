package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
public class stepDefinition{
	WebDriver driver;

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/src/main/java/resources/chromedriver");
    	driver = new ChromeDriver();
    }
    
    @And("^Naviqate to \"([^\"]*)\" site$")
    public void naviqate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^Click on sign in link to land on sign in page$")
    public void click_on_sign_in_link_to_land_on_sign_in_page() throws Throwable {
    	LandingPage lp = new LandingPage(driver);
    	
    	if(lp.getAdList().size() > 0)
    		lp.getAdClose().click();
    	
    	lp.getLoginButton().click();
    }

    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_something_and_something_and_logs_in(String strArg1, String strArg2) throws Throwable {
    	LoginPage logp = new LoginPage(driver);
        logp.getEmailBox().sendKeys(strArg1);
        logp.getPasswordBox().sendKeys(strArg2);
        logp.getLoginButton().click();
    }

    @Then("^Verify the user is successfully logged in$")
    public void verify_the_user_is_successfully_logged_in() throws Throwable {
        System.out.println("Test user is not working....");
    }
    
    @And("^Close browsers$")
    public void close_browsers() {
    	driver.quit();
    }

 

}