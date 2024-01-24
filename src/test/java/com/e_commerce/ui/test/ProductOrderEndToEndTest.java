package com.e_commerce.ui.test;

import java.util.List;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.e_commerce.ui.core.BaseTestPage;
import com.e_commerce.ui.page.CheckoutDetailsPage;
import com.e_commerce.ui.page.DashboardPage;
import com.e_commerce.ui.page.OrderConfirmationPage;
import com.e_commerce.ui.page.ProductDetailsPage;
import com.e_commerce.ui.page.ProductsCartPage;
import com.e_commerce.ui.page.SearchResultPage;
import com.e_commerce.ui.utility.Config;
import com.e_commerce.ui.utility.TestDataGenerator;

public class ProductOrderEndToEndTest extends BaseTestPage {

	OrderConfirmationPage orderConfirmationPage;
	DashboardPage dashboardPage = new DashboardPage();
	SearchResultPage searchResultPage = new SearchResultPage();
	ProductDetailsPage productDetailsPage = new ProductDetailsPage();
	ProductsCartPage productsCartPage = new ProductsCartPage();
	CheckoutDetailsPage checkoutDetailsPage = new CheckoutDetailsPage();
	
	String product = Config.getProductName();
	List<String> billingAddressDetails = TestDataGenerator.generateBillingAddressDetails();
	
	@Test(description="Validate Item Order, end to end scenario")
	public void orderProduct() {
		
		getTestLogger().log(Status.PASS, "User navigates to nop-commerce home page");
		getDriver().get(Config.getUrl());
		
		getTestLogger().log(Status.PASS, "User searches for a product and navigate to product details page");
		dashboardPage.searchProduct(product).clickSearch();
		
		getTestLogger().log(Status.PASS, "User navigates to product details page");
		searchResultPage.clickProductName(product);
		
		getTestLogger().log(Status.PASS, "User adds item to the cart");
		String price = productDetailsPage.captureProductPrice(product);
		productDetailsPage.clickAddToCart(product);
		
		getTestLogger().log(Status.PASS, "Validate product successfully added to the cart");
		productDetailsPage.clickShoppingCart();
		productsCartPage.validateProductAdditionToCart(product, price);
		
		getTestLogger().log(Status.PASS, "User accept terms of service and navigates to checkout details page");
		productsCartPage.acceptTermsOfService().clickCheckout().clickCheckoutAsGuest();
		
		getTestLogger().log(Status.PASS, "User submits checkout details and places order");
		orderConfirmationPage = checkoutDetailsPage.submitBillingAddressDetails(billingAddressDetails).clickContinue().clickShippingMethodContinueButton()
		.clickPaymentMethodContinueButton().clickPaymentInfoContinueButton().clickConfirmOrderContinueButton();
		
		getTestLogger().log(Status.PASS, "Validate order placed successfully");
		orderConfirmationPage.validateOrderPlacedSuccessfully();
	}
	
}
