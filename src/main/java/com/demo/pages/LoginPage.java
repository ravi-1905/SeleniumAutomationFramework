/**
Ravi Kumar
WebAutomation
*/
package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.Verification;

public class LoginPage extends BasePage {
	
	Verification verification;
	public LoginPage(WebDriver driver) {
		super(driver);
		verification = new Verification(driver);
	}

	/** Home page Web Elements **/
	By userName = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='login-button']");
	By productTitle = By.xpath("//div[contains(text(),'Products')]");
	By loginErrorText = By.xpath("//h3[contains(.,'Username and password do not match any user in this service')]");
	
	
	/** Home page Methods **/
	public LoginPage loginWithValidCredentials(String sUserName, String sPassword) {
		sendKeys(userName, sUserName);
		sendKeys(password, sPassword);
		click(loginBtn);
		boolean isProductDisplayed = waitVisibility(productTitle).isDisplayed();
		verification.verify(isProductDisplayed, "Login successful",  "Login Failed", "Login");
		return new LoginPage(driver);
	}
	
	public LoginPage loginWithInValidCredentials(String sUserName, String sPassword) {
		sendKeys(userName, sUserName);
		sendKeys(password, sPassword);
		click(loginBtn);
		boolean isPErrorTextDisplayed = waitVisibility(loginErrorText).isDisplayed();
		verification.verify(isPErrorTextDisplayed, "Login is Unsucessfull",  "Login successful", "Login Unsuccessful");
		return new LoginPage(driver);
	}
	
}
