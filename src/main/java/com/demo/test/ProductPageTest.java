/**
Ravi Kumar
WebAutomation
*/
package com.demo.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.pages.LoginPage;
import com.demo.pages.ProductPage;

public class ProductPageTest extends BaseTest{

	ProductPage productPage;
	LoginPage loginPage;
	private Logger log = LogManager.getLogger(ProductPageTest.class.getName());
	
	@BeforeMethod
	public void classLevelSetup() throws IOException {
		driver = getDriver();
		driver.get("https://www.saucedemo.com/v1/");
		productPage = new ProductPage(driver);
		loginPage = new LoginPage(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		log.info("Browser closed");
	}
	
	@Test
	public void test_addProductToCart() {
		loginPage.loginWithValidCredentials("standard_user", "secret_sauce");
		productPage.addProductToCart("Sauce Labs Backpack");
	}
}
