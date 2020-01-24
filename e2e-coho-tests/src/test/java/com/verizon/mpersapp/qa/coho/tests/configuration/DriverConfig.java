package com.verizon.mpersapp.qa.coho.tests.configuration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Configuration("CoreWebDriver")
@Slf4j
public class DriverConfig {

    @Bean(destroyMethod = "quit", name = "CoreDriver")
    @Lazy
    public WrappedWebDriver webDriver() throws IOException {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);

        //Use a empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Set the DesiredCapabilities capabilities only for local development
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appPackage", "com.quintech.mpers");
        capabilities.setCapability("appActivity", "host.exp.exponent.MainActivity");
        capabilities.setCapability("udid", "4e51414832313498");
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        return new WrappedWebDriver(driver);
    }
}
