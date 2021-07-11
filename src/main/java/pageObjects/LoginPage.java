package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // without this statement, the elements will not be found when called
	}
	
	//encapsulation, making objects private and methods that accesses them public
	private By email = By.cssSelector("#user_email");
	private By password = By.cssSelector("#user_password");
	private By login = By.cssSelector("input[name='commit']");
	private By forgotPassword = By.cssSelector("a[href='password/new/index.php']");
	
	public WebElement getEmailBox() {
		return driver.findElement(email);
	}
	
	public WebElement getPasswordBox() {
		return driver.findElement(password);
	}

	public WebElement getLoginButton() {
		return driver.findElement(login);
	}
	
	public ForgotPassword getForgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}
	
}
