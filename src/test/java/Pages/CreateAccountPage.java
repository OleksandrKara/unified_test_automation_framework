package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CreateAccountPage extends BasePage {

    protected CreateAccountPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Example: John or Mary']")
    private MobileElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='XXX.XXX.XXXX']")
    private MobileElement mobileNumberField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your email address']")
    private MobileElement emailField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your password']")
    private MobileElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter your password again']")
    private MobileElement confirmPasswordField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup")
    private MobileElement createAccountButton;

    public void createAccount(String userName, String mobileNum, String email, String password) throws InterruptedException {
        usernameField.sendKeys(userName);
        mobileNumberField.sendKeys(mobileNum);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
        createAccountButton.click();
    }
}
