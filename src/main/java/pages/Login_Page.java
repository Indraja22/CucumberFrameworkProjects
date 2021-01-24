package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {

	private WebDriver driver;
	// By Locators
	private By logIn = By.cssSelector("a[id='login2']");
	private By userName = By.cssSelector("input[id='loginusername']");
	private By password = By.cssSelector("input[id='loginpassword']");
	private By logInBtn = By.xpath("//button[contains(text(),'Log in')]");
	private By welcomeMessage = By.xpath("//a[contains(text(),'Welcome')]");

	// Constructors of the page class
	public Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	// page action methods
	public void clickLoginLink() {
		driver.findElement(logIn).click();
	}

	public void enterUserName(String username) throws InterruptedException {

		WebElement enterUserName = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(userName));
		enterUserName.sendKeys(username);
	}

	public void enterPassword(String passwd) {

		WebElement enterPassword = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(password));
		enterPassword.sendKeys(passwd);

	}

	public void clickLoginBtn() throws InterruptedException {
		WebElement loginBtn = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(logInBtn));
		loginBtn.click();
	}

	public String getLoginPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public String getWelcomeMessage() {

		WebElement welcmMsg = new WebDriverWait(driver, 10)
				.until(ExpectedConditions.presenceOfElementLocated(welcomeMessage));
		String getWlcmMsg = welcmMsg.getText();
		return getWlcmMsg;
	}

	public Home_Page doLogin(String un, String pwd) {
		driver.findElement(logIn).click();
		WebElement enterUserName = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(userName));
		enterUserName.sendKeys(un);

		WebElement enterPassword = new WebDriverWait(driver, 20)
				.until(ExpectedConditions.elementToBeClickable(password));
		enterPassword.sendKeys(pwd);

		WebElement loginBtn = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(logInBtn));
		loginBtn.click();
		
		return new Home_Page(driver);

	}

}
