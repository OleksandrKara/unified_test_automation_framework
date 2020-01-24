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

package tests;

import pages.*;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;


import tests.AbstractBaseTests.TestBase;

/**
 * Tests for a login page
 */


@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "classpath:LoginTest",
        plugin = {"pretty"}
)
public class LoginTest extends TestBase {
    private static final String LOGIN_SUCCESS_MESSAGE = "You are logged on as admin";
    private static final String LOGIN_FAIL_MESSAGE = "You gave me the wrong username and password";
    private static final String CORRECT_USER_NAME = "admin";
    private static final String CORRECT_PASSWORD = "password";
    private static final String FAIL_USER_NAME = "Wrong User";
    private static final String FAIL_PASSWORD = "12345";
    private static final String BAD_TEXT_ENTRY_MSG = "Username sent to text field incorrectly";

    private WelcomePage welcomePage;
    private IntroductionPage introPage;
    private GetStartedPage getStartedPage;
    private SignInPage signInPage;

    @Override
    public String getName() {
        return "Login Page";
    }

    /**
     * Creates a login
     */
    @Given("^I navigate to the login page$")
    public void setUpPage() {
        welcomePage = new WelcomePage(driver);
    }

    /**
     * Tests logging in with valid credentials by verifying if the login message is correct
     */
    @Given("^username is correct$")
    public void loginSuccess() throws InterruptedException {
        Thread.sleep(5000);
        introPage = welcomePage.NavigateToIntroductionPage();
        getStartedPage=introPage.NavigateToGetStartedPage();
        signInPage=getStartedPage.NavigateToSignInPage();
        signInPage.login("olexandr.kara@gmail.com","Verizon91@");
    }
}
