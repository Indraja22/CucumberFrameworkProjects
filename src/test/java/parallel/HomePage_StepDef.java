package parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Home_Page;
import pages.Login_Page;

public class HomePage_StepDef {
	
	WebDriver driver = DriverFactory.getDriver();
	Login_Page loginPage = new Login_Page(driver);
	Home_Page homePage;
	
	
	
	@Given("User logins to the PRODUCT STORE")
	public void user_logins_to_the_product_store(DataTable dataTable) {
		driver.get("https://www.demoblaze.com/");
	    List<Map<String, String>> credList = dataTable.asMaps();
	    String userName = credList.get(0).get("username");
	    String passWord = credList.get(0).get("password");
	    homePage = loginPage.doLogin(userName, passWord);
	    
	}
	
	@Then("Product categories section is visible to the user")
	public void product_categories_section_is_visible_to_the_user() {
		System.out.println("Product Categories is displayed : "+homePage.categoriesSection());
	}

	@Then("The product categories count should be {int}")
	public void the_product_categories_count_should_be(int prodCatCount) {
	  int categoryCount =   homePage.getProdCatCount();
	 // Assert.assertEquals(prodCatCount, categoryCount);
	  Assert.assertTrue(categoryCount == prodCatCount);
	}

}
