package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	private WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); // without this statement, the elements will not be found when called

	}

	private By signin = By.cssSelector("a[href*='sign_in']");
	private By featuredCourses = By.xpath("//section[@id='content']//div[@class='container']//div[@class='text-center']//h2");
	private By navBar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	private By ad = By.cssSelector("div[class*='sumome-react-wysiwyg-component']");
	private By adClose = By.cssSelector("div[class*='sumome-react-wysiwyg-close-button']");
	private By ads = By.xpath("//button[text()='NO THANKS']");
	private By subTitle = By.cssSelector("div#myCarousel div div div div div h3");

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		return new LoginPage(driver);
	}
	
	public WebElement getLoginButton() {
		return driver.findElement(signin);
	}
	
	public WebElement getFeatCours() {
		return driver.findElement(featuredCourses);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getAd() {
		return driver.findElement(ad);
	}
	
	public List<WebElement> getAdList() {
		return driver.findElements(ads);
	}
	
	public WebElement getAdClose() {
		return driver.findElement(adClose);
	}

	public WebElement getSubTitle() {
		return driver.findElement(subTitle);
	}

	
}
