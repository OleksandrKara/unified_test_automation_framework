/*
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.verizon.mpersapp.qa.coho.tests.stepDefs;

import com.verizon.mpersapp.qa.coho.tests.configuration.AppConfig;
import com.verizon.mpersapp.qa.coho.tests.configuration.WrappedWebDriver;
import com.verizon.mpersapp.qa.coho.tests.pages.GetStartedPage;
import com.verizon.mpersapp.qa.coho.tests.pages.IntroductionPage;
import com.verizon.mpersapp.qa.coho.tests.pages.SignInPage;
import com.verizon.mpersapp.qa.coho.tests.pages.WelcomePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import java.net.MalformedURLException;

/**
 * An abstract base for all of the Android tests within this package
 *
 * Responsible for setting up the Appium test Driver
 */
@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext
@Slf4j
/*
By default DirtiesContext makes one WebDriver per one test scenario
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD) - to run single WebDriver session for all tests
 */
public class BaseStepsDefs {
    /**
     * This method runs before any other method.
     *
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to Device Farm's appium server.
     *
     * We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Device Farm creates custom settings at the server level. Setting your own DesiredCapabilities
     * will result in unexpected results and failures.
     *
     * @throws MalformedURLException An exception that occurs when the URL is wrong
     */
    /*@Before
    public void setUpAppium() throws MalformedURLException {

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

        driver = new AndroidDriver<>(url, capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    }
*/




    @Value("${mobile.app.username}")
    public String login;

    @Value("${mobile.app.password}")
    public String password;

    @Autowired
    @Lazy
    WelcomePage welcomePage;
    @Autowired
    @Lazy
    private IntroductionPage introPage;
    @Autowired
    @Lazy
    private GetStartedPage getStartedPage;
    @Autowired
    @Lazy
    private SignInPage signInPage;

    private static final String LOGIN_SUCCESS_MESSAGE = "You are logged on as admin";
    private static final String LOGIN_FAIL_MESSAGE = "You gave me the wrong username and password";
    private static final String CORRECT_USER_NAME = "admin";
    private static final String CORRECT_PASSWORD = "password";
    private static final String FAIL_USER_NAME = "Wrong User";
    private static final String FAIL_PASSWORD = "12345";
    private static final String BAD_TEXT_ENTRY_MSG = "Username sent to text field incorrectly";


    //@Override
    public String getName() {
        return "Login Page";
    }

    /**
     * Creates a login
     */
    @Given("^I navigate to the login page$")
    public void setUpPage() {
        log.info("I navigate to the login page");
    }

    /**
     * Tests logging in with valid credentials by verifying if the login message is correct
     */
    @Given("^username is correct$")
    public void loginSuccess() throws InterruptedException {
        Thread.sleep(5000);
        welcomePage.NavigateToIntroductionPage();
        introPage.NavigateToGetStartedPage();
        getStartedPage.NavigateToSignInPage();
        signInPage.login(login,password);
    }
}
