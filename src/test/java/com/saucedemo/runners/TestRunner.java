package com.saucedemo.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.saucedemo.steps"},
        tags =
        "@login or @Regression or " +
        "@Smoke")
public class TestRunner extends AbstractTestNGCucumberTests {
    static {
        System.setProperty("cucumber.plugin",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm");
    }



    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {

    return super.scenarios();
    }
}
