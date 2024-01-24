package com.e_commerce.ui.page;

import java.util.List;

import org.openqa.selenium.By;

import com.e_commerce.ui.core.BaseTestPage;

public class CheckoutDetailsPage extends BaseTestPage {

	private By getFirstNameInput() {
		return By.xpath("//input[@name='BillingNewAddress.FirstName']");
	}
	
	private By getLastNameInput(){
		return By.xpath("//input[@name='BillingNewAddress.LastName']");
	}
	
	private By getEmailInput(){
		return By.xpath("//input[@name='BillingNewAddress.Email']");
	}
	
	private By getCountryDropdown() {
		return By.xpath("//select[@id='BillingNewAddress_CountryId']");
	}
	
	private By getCityInput(){
		return By.xpath("//input[@name='BillingNewAddress.City']");
	}
	
	private By getAddressInput(){
		return By.xpath("//input[@name='BillingNewAddress.Address1']");
	}
	
	private By getZipCodeInput(){
		return By.xpath("//input[@name='BillingNewAddress.ZipPostalCode']");	
	}
	
	private By getPhoneNumberInput(){
		return By.xpath("//input[@name='BillingNewAddress.PhoneNumber']");	
	}
	
	private By getContinueButton() {
		return By.xpath("//li[@id='opc-billing']//button[@name='save']");
	}
	
	private By getShippingMethodContinueButton() {
		return By.xpath("//li[@id='opc-shipping_method']//button");
	}
	
	private By getPaymentMethodContinueButton() {
		return By.xpath("//li[@id='opc-payment_method']//button");
	}
	
	private By getPaymentInfoContinueButton() {
		return By.xpath("//li[@id='opc-payment_info']//button");
	}
	
	private By getConfirmOrderContinueButton() {
		return By.xpath("//li[@id='opc-confirm_order']//button");
	}
	
	public OrderConfirmationPage clickConfirmOrderContinueButton() {
		LOGGER.info("Clicking confirm order continue button");
		click(getConfirmOrderContinueButton());
		return new OrderConfirmationPage();
	}
	
	public CheckoutDetailsPage clickPaymentInfoContinueButton() {
		LOGGER.info("Clicking payment info continue button");
		click(getPaymentInfoContinueButton());
		return this;
	}
	
	public CheckoutDetailsPage clickPaymentMethodContinueButton() {
		LOGGER.info("Clicking Payment Method continue button");
		click(getPaymentMethodContinueButton());
		return this;
	}
	
	public CheckoutDetailsPage clickShippingMethodContinueButton() {
		LOGGER.info("Clicking Shipping Method continue button");
		click(getShippingMethodContinueButton());
		return this;
	}
	
	public CheckoutDetailsPage submitBillingAddressDetails(List<String> addressDetails) {
		LOGGER.info("Submitting billing address details");
		setValue(addressDetails.get(0), getFirstNameInput());
		setValue(addressDetails.get(1), getLastNameInput());
		setValue(addressDetails.get(2).toLowerCase(), getEmailInput());
		selectDropdownValue(getCountryDropdown(), addressDetails.get(3));
		setValue(addressDetails.get(4), getCityInput());
		setValue(addressDetails.get(5), getAddressInput());
		setValue(addressDetails.get(6), getZipCodeInput());
		setValue(addressDetails.get(7), getPhoneNumberInput());
		return this;
	}
	
	public CheckoutDetailsPage clickContinue() {
		LOGGER.info("Clicking Contnue button");
		click(getContinueButton());
		return this;
	}
}
