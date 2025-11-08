package com.saucedemo.pages;

import com.saucedemo.utils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class P01_LoginPage extends P00_BasePage {

    private final By usernameInput = By.xpath("//input[@id='user-name']");
    private final By passwordInput = By.xpath("//input[@id='password']");
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");


    public P01_LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        Utility.sendData(driver, usernameInput, username);
    }

    public void enterPassword(String password) {
        Utility.sendData(driver, passwordInput, password);
    }

    public void clickLoginButton() {
        Utility.clickingOnElement(driver, loginButton);
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
        return Utility.getText(driver, errorMessage);
    }
}