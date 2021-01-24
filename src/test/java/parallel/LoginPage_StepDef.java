package parallel;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login_Page;

public class LoginPage_StepDef {
	
	private WebDriver driver = DriverFactory.getDriver();
	private static String title=null;
	private Login_Page loginPage = new Login_Page(driver);

	@Given("User has launched the application")
	public void user_has_launched_the_application() {
		driver.get("https://www.demoblaze.com/");
	}

	@Given("User is on the home page")
	public void user_is_on_the_home_page() {
		title  = loginPage.getLoginPageTitle();
		System.out.println(title + " is the page title.");
		
	}

	@When("User enters his username {string} and password {string}")
	public void user_enters_his_username_and_password(String username, String password) throws InterruptedException {
		loginPage.clickLoginLink();
	    loginPage.enterUserName(username);
	    loginPage.enterPassword(password);
	    loginPage.clickLoginBtn();
	    Thread.sleep(6000);
	}

	@Then("Verify if the home page displays message Welcome {string}")
	public void verify_if_the_home_page_displays_message_welcome(String username) {
		String wlcmMsg = loginPage.getWelcomeMessage();
	    Assert.assertEquals(wlcmMsg,"Welcome "+username);
	}


}
