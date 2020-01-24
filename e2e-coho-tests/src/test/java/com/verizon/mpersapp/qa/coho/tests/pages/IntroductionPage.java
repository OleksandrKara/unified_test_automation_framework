package com.verizon.mpersapp.qa.coho.tests.pages;

import com.verizon.mpersapp.qa.coho.tests.configuration.PageObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

@PageObject
public class IntroductionPage extends BasePage{
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup")
    private MobileElement NextButton;

    public void NavigateToGetStartedPage() {
        NextButton.click();
    }
}
