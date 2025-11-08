package com.saucedemo.pages;

import com.saucedemo.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P02_ProductsPage extends P00_BasePage {

    private final By productItems = By.xpath("//div[@class='inventory_item']");
    private final By priceLabel   = By.className("inventory_item_price");
    private final By addToCartBtn = By.cssSelector("button[id^='add-to-cart']");
    private final By cartButton   = By.cssSelector(".shopping_cart_link");

    public P02_ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnProductsPage() {
        return driver.getCurrentUrl().contains("/inventory.html");
    }

    private List<WebElement> getAllProducts() {
        return driver.findElements(productItems);
    }

    public void addMostExpensiveProducts(int count) {
        getAllProducts().stream()
                .sorted((a, b) -> getPrice(b).compareTo(getPrice(a)))
                .limit(count)
                .forEach(this::addToCart);
    }

    private Double getPrice(WebElement product) {
        String priceText = product.findElement(priceLabel).getText();
        return Double.parseDouble(priceText.replace("$", ""));
    }

    private void addToCart(WebElement product) {
        Utility.clickingOnElement(driver,addToCartBtn);
    }

    public void clickCartButton() {
        Utility.clickingOnElement(driver,cartButton);
    }
}
