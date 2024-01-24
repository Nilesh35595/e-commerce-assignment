package com.e_commerce.ui.page;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.e_commerce.ui.core.BaseTestPage;

public class ProductsCartPage extends BaseTestPage {
	
	private By getCartProduct(String productName, String price) {
		return By.xpath("//a[contains(text(),'"+productName+"')]//ancestor::td//following-sibling::td[@class='unit-price']//span[contains(text(),'"+price+"')]");
	}
	
	private By getTermsOfServiceCheckbox() {
		return By.xpath("//input[@name='termsofservice' and @type='checkbox']");
	}
	
	private By getCheckoutButton() {
		return By.xpath("//button[@id='checkout']");
	}
	
	private By getCheckoutAsGuestButton() {
		return By.xpath("//button[contains(text(),'Checkout as Guest')]");
	}
	
	public CheckoutDetailsPage clickCheckoutAsGuest() {
		LOGGER.info("Clicking Checkout As Guest");
		click(getCheckoutAsGuestButton());
		return new CheckoutDetailsPage();
	}
	
	public ProductsCartPage clickCheckout() {
		LOGGER.info("Clicking Checkout button");
		click(getCheckoutButton());
		return this;
	}
	
	public ProductsCartPage acceptTermsOfService() {
		LOGGER.info("Clicking service terms checkbox");
		click(getTermsOfServiceCheckbox());
		return this;
	}
	
	public ProductsCartPage validateProductAdditionToCart(String product, String price) {
		LOGGER.info("Validate product added successfully to the cart");
		waitUntilElementIsVisible(getCartProduct(product, price));
		Assert.assertTrue(isElementPresent(getCartProduct(product, price)), "Failed to add product to the cart");
		return this;
	}
}
