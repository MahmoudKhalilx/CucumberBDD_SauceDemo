package com.saucedemo.pages;

import com.saucedemo.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_CompletePage extends P00_BasePage {

    private final By thankYouMessage = By.cssSelector(".complete-header");
    private final By dispatchMessage = By.cssSelector(".complete-text");

    public P06_CompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCompletePage() {
        return driver.getCurrentUrl().contains("/checkout-complete.html");
    }

    public String getThankYouMessage() {
        return Utility.getText(driver, thankYouMessage);
    }

    public String getDispatchMessage() {
        return Utility.getText(driver, dispatchMessage);
    }
}
