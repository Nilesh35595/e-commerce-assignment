package com.e_commerce.ui.page;

import org.openqa.selenium.By;

import com.e_commerce.ui.core.BaseTestPage;

public class SearchResultPage extends BaseTestPage {

	private By getProductNameLink(String productName) {
		return By.xpath("//div[@class='item-grid']//a[contains(text(),'"+productName+"')]");
	}
	
	public ProductDetailsPage clickProductName(String productName) {
		LOGGER.info("Clicking product name");
		click(getProductNameLink(productName));
		return new ProductDetailsPage();
	}
	
}
