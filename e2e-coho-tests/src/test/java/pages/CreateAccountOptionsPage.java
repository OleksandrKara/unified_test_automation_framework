package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateAccountOptionsPage extends BasePage {

    protected CreateAccountOptionsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup[1]")
    private MobileElement createAccountUsingEmailAddressButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@index=1]")
    private MobileElement createAccountUsingGoogleButton;

    public CreateAccountPage NavigateToCreateAccountPage(){
        createAccountUsingEmailAddressButton.click();
        return new CreateAccountPage(driver);
    }

}
