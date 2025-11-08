package com.saucedemo.pages;

import com.saucedemo.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_CheckoutPage extends P00_BasePage {

    private final By firstNameInput  = By.id("first-name");
    private final By lastNameInput   = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton  = By.id("continue");

    public P04_CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCheckoutPage() {
        return driver.getCurrentUrl().contains("/checkout-step-one.html");
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        Utility.sendData(driver, firstNameInput,  firstName);
        Utility.sendData(driver, lastNameInput,   lastName);
        Utility.sendData(driver, postalCodeInput, postalCode);
    }

    public void clickContinueButton() {
        Utility.clickingOnElement(driver, continueButton);
    }
}
