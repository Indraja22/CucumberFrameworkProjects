package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
	
	WebDriver driver;
	private List<WebElement> prodCategories;
	//Constructor
	public Home_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	//By locators
	private By categoriesProduct = By.id("itemc");
	private By categoriesSection = By.id("cat");
	
	private List<WebElement> getProductCategories() {
		  return prodCategories = driver.findElements(categoriesProduct);	
	}
	
	public int getProdCatCount() {
		  List<WebElement> prod_cats = getProductCategories();
		  int prodCat_cnt = prod_cats.size();
		  System.out.println(prodCat_cnt + " Categories are displayed.");
		  return prodCat_cnt;
	}
	
	/*
	 * public String categoriesSection() { String text; for(int i
	 * =0;i<prodCategories.size();i++) {
	 * 
	 * } }
	 */
	
	public boolean categoriesSection() {
		 boolean areCategoriesDisplayed = driver.findElement(categoriesSection).isDisplayed();
		 return areCategoriesDisplayed;
	}
	
	

}
