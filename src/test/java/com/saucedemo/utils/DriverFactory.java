package com.saucedemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    static ChromeOptions options;

    public Properties config = new Properties();
    public FileInputStream fis;

    public static WebDriver getDriver() {

        if (driverThreadLocal.get() == null) {

            String browser = System.getProperty("browser", ConfigReader.getProperty("browser")).toLowerCase();
            String headlessValue = System.getProperty("headless", ConfigReader.getProperty("headless"));
            boolean isHeadless = Boolean.parseBoolean(headlessValue);

            WebDriver driver;

            switch (browser) {

                case "firefox":

                    FirefoxOptions fOptions = new FirefoxOptions();

                    if (isHeadless) {
                        fOptions.addArguments("--headless");
                        fOptions.addArguments("--width=1920");
                        fOptions.addArguments("--height=1080");
                    } else {
                        fOptions.addArguments("--width=1920");
                        fOptions.addArguments("--height=1080");
                    }

                    fOptions.addArguments("--disable-notifications");
                    fOptions.addArguments("--disable-popup-blocking");
                    fOptions.addArguments("--disable-save-password-bubble");

                    driver = new FirefoxDriver(fOptions);
                    break;

                default:

                    Map<String, Object> prefs = new HashMap<>();
                    prefs.put("profile.password_manager_leak_detection", false);
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);

                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", prefs);

                    options.addArguments("--disable-save-password-bubble");
                    options.addArguments("--disable-features=PasswordLeakDetection");
                    options.addArguments("--incognito");

                    if (isHeadless) {
                        options.addArguments("--headless=new");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--window-size=1920,1080");
                    }

                    driver = new ChromeDriver(options);
            }

            driverThreadLocal.set(driver);

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
