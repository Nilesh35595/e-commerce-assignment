package com.e_commerce.ui.page;

import org.openqa.selenium.By;

import com.e_commerce.ui.core.BaseTestPage;

public class ProductDetailsPage extends BaseTestPage {
	

	private By getAddToCartButton(String productName) {
		return By.xpath("//h1[text()='"+productName+"']//ancestor::div[@class='overview']//button[contains(@id,'add-to-cart-button')]");
	}
	
	private By getShoppingCart() {
		return By.xpath("//span[contains(text(),'Shopping cart')]");
	}
	
	private By getNotificationCloseButton() {
		return By.xpath("//span[@title='Close']");
	}
	
	private By getProductPrice(String productName) {
		return By.xpath("//h1[contains(text(),'"+productName+"')]//ancestor::div//div[@class='product-price']//span");
	}
	
	public String captureProductPrice(String productName) {
		LOGGER.info("Capturing product price");
		return getText(getProductPrice(productName));
	}
	
	public ProductDetailsPage clickClose() {
		LOGGER.info("Closing notification");
		click(getNotificationCloseButton());
		return this;
	}
	
	public ProductDetailsPage clickAddToCart(String produtctName) {
		LOGGER.info("Clicking Add To Cart button");
		click(getAddToCartButton(produtctName));
		return this;
	}
	
	public ProductsCartPage clickShoppingCart() {
		LOGGER.info("Clicking Shipping Cart");
		click(getShoppingCart());
		return new ProductsCartPage(); 
	}
}
