package com.verizon.mpersapp.qa.coho.tests.configuration;

import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

@Slf4j
public class CucumberHooks {
    @Autowired
    @Qualifier("CoreWebdriverHelper")
    @Lazy
    WebDriverHelper wdHelper;

    @Before
    public void beforeScenario() {
        log.info("Before Scenario!");
    }

    /**
     * Always remember to quit
     */
    @After
    public void tearDownAppium() {
        wdHelper.quit();
    }


    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
     */
    @After
    public void restartApp() {
        wdHelper.resetApp();
    }
}
