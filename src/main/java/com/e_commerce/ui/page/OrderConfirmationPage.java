package com.e_commerce.ui.page;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.e_commerce.ui.core.BaseTestPage;

public class OrderConfirmationPage extends BaseTestPage {

	private By getOrderConfirmationMessage() {
		return By.xpath("//div[@class='section order-completed']");
	}
	
	public OrderConfirmationPage validateOrderPlacedSuccessfully() {
		LOGGER.info("Validating order placed successfully");
		Assert.assertTrue(isElementPresent(getOrderConfirmationMessage()));
		return this;
	}
	
}
