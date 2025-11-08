package com.saucedemo.pages;


import com.saucedemo.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class P03_CartPage extends P00_BasePage {

    private final By cartItems = By.cssSelector(".cart_item");
    private final By checkoutButton = By.id("checkout");

    public P03_CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains("/cart.html");
    }

    public int getNumberOfCartItems() {
        List<?> items = driver.findElements(cartItems);
        return items.size();
    }

    public void clickCheckoutButton() {
        Utility.clickingOnElement(driver, checkoutButton);
    }
}
