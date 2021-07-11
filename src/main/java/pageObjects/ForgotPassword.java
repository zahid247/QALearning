package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	
	private WebDriver driver;
	
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // without this statement, the elements will not be found when called
	}
	
	private By email = By.cssSelector("#user_email");
	private By sendMeInstructions = By.cssSelector("input[type='submit']");
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getsendMeInstructionsl() {
		return driver.findElement(sendMeInstructions);
	}

}
