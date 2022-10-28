package com.sample.test.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

	WebDriver driver;
	
	@FindBy(id="nav-hamburger-menu")
	WebElement hamburger;

	@FindBy(id="twotabsearchtextbox")
	WebElement search;

	@FindBy(id = "nav-search-submit-button")
	WebElement submit;

	@FindBy(css = "span[class='a-button-text a-declarative']")
	WebElement filter;

	@FindBy(xpath = "//div[@class='a-section']/div[@class='sg-row']//a[@class='a-link-normal s-no-outline']")
	List<WebElement> products;

	String selectFilter= "//a[text()='Price: High to Low']";

	String brand = "//span[text()='{1}']/preceding-sibling::div//input";
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickhamburger(){
		hamburger.click();
	}

	public HomePage entertextinSearch(String text){
		search.sendKeys(text);
		submit.click();
		return new HomePage(driver);
	}

	public HomePage selectBrand(String text){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(brand.replace("{1}", text))));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(brand.replace("{1}", text))));
		return new HomePage(driver);
	}

	public HomePage selectFilter() throws InterruptedException {
		filter.click();
		driver.findElement(By.xpath(selectFilter)).click();
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	public ProductDetailPage selectProduct(int index){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(products.get(index)));
		products.get(index).click();
		return new ProductDetailPage(driver);
	}

}
