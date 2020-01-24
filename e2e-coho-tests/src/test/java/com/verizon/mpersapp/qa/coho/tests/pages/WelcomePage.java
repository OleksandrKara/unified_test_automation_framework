package com.verizon.mpersapp.qa.coho.tests.pages;

import com.verizon.mpersapp.qa.coho.tests.configuration.PageObject;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Value;

@PageObject
public class WelcomePage extends BasePage {
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
    private MobileElement NextButton;

    public void NavigateToIntroductionPage() {
        NextButton.click();
    }
}
