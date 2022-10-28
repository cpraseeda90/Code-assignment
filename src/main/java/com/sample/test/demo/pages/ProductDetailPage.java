package com.sample.test.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage {
	
	@FindBy(xpath="//span[@id='productTitle']")
	WebElement title;
	
	@FindBy(xpath="//*[@id='feature-bullets']/ul/li[2]/span")
	WebElement features;
	
	
	public ProductDetailPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle(){
		return title.getText();
	}
	
	public String getFeatures(){
		return features.getText();
	}

}
