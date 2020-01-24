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

package com.verizon.mpersapp.qa.coho.tests.pages;


import com.verizon.mpersapp.qa.coho.tests.configuration.WebDriverHelper;
import com.verizon.mpersapp.qa.coho.tests.configuration.WrappedWebDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

/**
 * A base for all the pages within the suite
 */
public abstract class BasePage {
    @Autowired
    @Lazy
    protected WebDriverHelper wdHelper;

    @Autowired
    @Lazy
    protected WrappedWebDriver driver;
}
