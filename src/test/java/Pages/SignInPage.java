package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignInPage extends BasePage {

    private static final int KEYBOARD_ANIMATION_DELAY = 1000;

    protected SignInPage(AppiumDriver driver) {
        super(driver);
    }


    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")
    private MobileElement usernameField;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")
    private MobileElement passwordField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[6]/android.view.ViewGroup[1]/android.widget.TextView")
    private MobileElement signInButton;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView")
    private MobileElement forgotEmailAddressLink;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[5]/android.widget.TextView")
    private MobileElement forgotMobileNumberLink;


    public DeviceDashboardPage login(String username, String password) throws InterruptedException {
        boolean usernameStatus = sendKeysToElement(username, usernameField, false);
        passwordField.click();
        Thread.sleep(KEYBOARD_ANIMATION_DELAY);
        passwordField.sendKeys(password);
        driver.hideKeyboard();
        signInButton.click();
        return new DeviceDashboardPage(driver);
    }

    public CreateAccountOptionsPage NavigateToForgotEmailAddressPage(){
        forgotEmailAddressLink.click();
        return new CreateAccountOptionsPage(driver);
    }

    public CreateAccountOptionsPage NavigateToForgotMobileNumberPage(){
        forgotMobileNumberLink.click();
        return new CreateAccountOptionsPage(driver);
    }

}
