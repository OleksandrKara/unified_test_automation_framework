package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GetStartedPage extends BasePage {

    protected GetStartedPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.view.ViewGroup[1]")
    private MobileElement signInButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index=2]")
    private MobileElement createAccountButton;

    public SignInPage navigateToSignInPage() {
        signInButton.click();
        return new SignInPage(driver);
    }

    public CreateAccountOptionsPage navigateToCreateAccountOptionsPage() {
        createAccountButton.click();
        return new CreateAccountOptionsPage(driver);
    }
}
