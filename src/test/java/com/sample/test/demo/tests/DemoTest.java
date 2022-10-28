package com.sample.test.demo.tests;

import static org.testng.Assert.assertFalse;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.pages.ProductDetailPage;
import com.sample.test.demo.pages.HamburgerPage;
import com.sample.test.demo.pages.HomePage;

public class DemoTest extends TestBase {
	
	HomePage home = null;
	HamburgerPage ham = null;
	ProductDetailPage product= null;

    @Test(dataProvider = "data", priority = 1)
    public void amazonMonitorTest(Hashtable<String, String> data) throws InterruptedException {
        
        home = new HomePage(driver);
        home.clickhamburger();
        
        ham = new HamburgerPage(driver);

        ham.selectMenu(data.get("Menu")).submenu(data.get("SubMenu"));

        home = new HomePage(driver);
        product = home.entertextinSearch(data.get("Brand"))
                .selectBrand(data.get("Brand"))
                .selectFilter()
                .selectProduct(1);


        System.out.println(product.getTitle());
        System.out.println(product.getFeatures());
//        book.enterName(data.get("Name")).enterAddress(data.get("Address")).enterCity(data.get("City")).enterstate(data.get("State"))
//        .enterzipCode(data.get("Zipcode")).selectCardType(data.get("CardType")).enterCreditCardNumber(data.get("CreditCardNumber"))
//        .enterCreditCardMonth(data.get("CreditCardMonth")).enterCreditCardYear(data.get("CreditCardYear"))
//        .enterNameOnCard(data.get("NameOnCard")).clickPurchaseFlight();
    }
    
}
