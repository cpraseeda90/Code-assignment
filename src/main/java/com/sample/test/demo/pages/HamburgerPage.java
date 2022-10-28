package com.sample.test.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HamburgerPage {
	
	WebDriver driver;

	String hamMenu = "//a[@class='hmenu-item']/div[text()='{1}']";

	String submenu = "//a[@class='hmenu-item' and text()='{1}']";
	public HamburgerPage(WebDriver driver){
		this.driver = driver;
	}
	
	public HamburgerPage selectMenu(String value){
		driver.findElement(By.xpath(hamMenu.replace("{1}", value))).click();
		return new HamburgerPage(driver);
	}

	public void submenu(String value){
		driver.findElement(By.xpath(submenu.replace("{1}", value))).click();
	}
}
