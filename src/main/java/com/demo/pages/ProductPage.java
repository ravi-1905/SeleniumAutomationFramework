/**
Ravi Kumar
WebAutomation
*/
package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.Verification;

public class ProductPage extends BasePage {

	Verification verify;

	public ProductPage(WebDriver driver) {
		super(driver);
		verify = new Verification(driver);
	}

	String addToCart = "//div[contains(text(),'%s')]/parent::a/parent::div/following-sibling::div/button";
	By productCountInCart = By.xpath("//div[@id='shopping_cart_container']/a/span");

	public int getProductCount() {
		int productCount;
		if (waitVisibility(productCountInCart).isDisplayed()) {
			productCount = Integer.valueOf(getText(productCountInCart));
		} else {
			productCount = 0;
		}

		return productCount;
	}

	public void addProductToCart(String sProductName) {
//		int productCountBefore = getProductCount();
		click(By.xpath(String.format(addToCart, sProductName)));

		boolean isProductAddedToCart = 1 == getProductCount();

		verify.verify(isProductAddedToCart, sProductName + " is added to cart", sProductName + " is not added to cart",
				sProductName);
	}

}
