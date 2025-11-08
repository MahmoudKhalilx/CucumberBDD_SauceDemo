package com.saucedemo.pages;

import com.saucedemo.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_OverviewPage extends P00_BasePage {

    private final By itemTotalElement = By.cssSelector(".summary_subtotal_label");
    private final By finishButton = By.id("finish");

    public P05_OverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnOverviewPage() {
        Utility.waitForUrlContains(driver, "/checkout-step-two.html", 10);
        return driver.getCurrentUrl().contains("/checkout-step-two.html");
    }

    public double getItemTotal() {
        String text = Utility.getText(driver, itemTotalElement);
        String value = text.replaceAll("[^0-9.]", "");
        return Double.parseDouble(value);
    }

    public void clickFinishButton() {
        Utility.clickingOnElement(driver, finishButton);
    }

    public String getItemsTotalBeforeTax() {
        String text = Utility.getText(driver, itemTotalElement);
        return text.split("\\$")[1];
    }
}
