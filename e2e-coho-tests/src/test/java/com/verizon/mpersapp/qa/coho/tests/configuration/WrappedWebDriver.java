package com.verizon.mpersapp.qa.coho.tests.configuration;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WrappedWebDriver  {
    private AppiumDriver driver;

    public AppiumDriver getWrappedDriver() {
        return driver;
    }

    public WrappedWebDriver(AppiumDriver driver) {
        this.driver = driver;
    }

    public void quit() {
        driver.quit();
    }
}
