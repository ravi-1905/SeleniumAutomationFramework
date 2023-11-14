package com.demo.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.pages.LoginPage;

public class LoginPageTest extends BaseTest {

	LoginPage loginPage;

	private Logger log = LogManager.getLogger(ProductPageTest.class.getName());

	@BeforeMethod
	public void classLevelSetup() throws IOException {
		driver = getDriver();
		driver.get("https://www.saucedemo.com/v1/");
		loginPage = new LoginPage(driver);
	}

	@AfterMethod
	public void teardown() {
		driver.close();
		log.info("Browser closed");
	}

	@Test(priority = 0)
	public void test_loginWithValidUserNameAndPassword() {
		loginPage.loginWithValidCredentials("standard_user", "secret_sauce");

	}
	
	@Test(priority = 1)
	public void test_loginWithInvalidUserNameAndValidPassword() {
		loginPage.loginWithInValidCredentials("invalidusername", "secret_sauce");

	}
	
	@Test(priority = 2)
	public void test_loginWithValidUserNameAndInvalidPassword() {
		loginPage.loginWithInValidCredentials("standard_user", "invalidpassword");

	}
	
	@Test(priority = 3)
	public void test_loginWithInalidUserNameAndInvalidPassword() {
		loginPage.loginWithInValidCredentials("invalidusername", "invalidpassword");

	}
	
	
}
