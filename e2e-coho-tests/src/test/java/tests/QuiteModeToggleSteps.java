package tests;

import pages.*;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import org.testng.Assert;
import tests.AbstractBaseTests.TestBase;

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "classpath:SmartWatchSettingsTest",
        plugin = {"pretty"}
)

public class QuiteModeToggleSteps extends TestBase {

    private WelcomePage welcomePage;
    private IntroductionPage introPage;
    private GetStartedPage getStartedPage;
    private SignInPage signInPage;
    private DeviceDashboardPage deviceDashboardPage;
    private ManageDevicesPage manageDevicePage;
    private CareSmartWatchSettingsPage careSmartWatchSettingsPage;


    public String getName() {
        return "Quite Mode Toggle Test";
    }

    @Given("^I navigate to the Care Smart Watch Settings Page")
    public void setUpPage() {
        welcomePage = new WelcomePage(driver);
    }

    @Given("^Enable Quite Mode$")
    public void loginSuccess() throws InterruptedException {
        Thread.sleep(5000);
        introPage = welcomePage.navigateToIntroductionPage();
        getStartedPage = introPage.navigateToGetStartedPage();
        signInPage = getStartedPage.navigateToSignInPage();
        deviceDashboardPage = signInPage.login("olexandr.kara@gmail.com", "Verizon91@");
        manageDevicePage = deviceDashboardPage.navigateToManageDevicesPage();
        careSmartWatchSettingsPage = manageDevicePage.navigateToCareSmartWatchSettingsPage();
        Assert.assertTrue(careSmartWatchSettingsPage.toggleQuiteMode());
    }
}
