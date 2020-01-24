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
import com.verizon.mpersapp.qa.coho.tests.pages.GetStartedPage;
import com.verizon.mpersapp.qa.coho.tests.pages.IntroductionPage;
import com.verizon.mpersapp.qa.coho.tests.pages.SignInPage;
import com.verizon.mpersapp.qa.coho.tests.pages.WelcomePage;
import cucumber.api.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

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
    @Value("${mobile.app.username}")
    public String login;

    @Value("${mobile.app.password}")
    public String password;

    @Autowired
    @Lazy
    private WelcomePage welcomePage;
    @Autowired
    @Lazy
    private IntroductionPage introPage;
    @Autowired
    @Lazy
    private GetStartedPage getStartedPage;
    @Autowired
    @Lazy
    private SignInPage signInPage;

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
