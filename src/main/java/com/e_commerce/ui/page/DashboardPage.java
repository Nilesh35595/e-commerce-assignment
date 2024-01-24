package com.e_commerce.ui.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.e_commerce.ui.core.BaseTestPage;

public class DashboardPage extends BaseTestPage{

	private By getSearchBox() {
		return By.xpath("//input[@id='small-searchterms']");
	}
	
	private By getSearchButton() {
		return By.xpath("//button[@type='submit']");
	}
	
	public DashboardPage searchProduct(String productName) {
		LOGGER.info("Searching "+ productName);
		setValue(productName, getSearchBox());
	    return this;
	}
	
	public SearchResultPage clickSearch() {
		LOGGER.info("Clicking search button");
		shortWait();
		click(getSearchButton());
		return new SearchResultPage();
	}
}
