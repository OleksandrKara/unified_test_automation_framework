package tests;

import pages.*;
import tests.AbstractBaseTests.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "classpath:SmartWatchSettingsTest",
        plugin = {"pretty"}
)

public class AdjustVolumeSteps extends TestBase {

    private WelcomePage welcomePage;
    private IntroductionPage introPage;
    private GetStartedPage getStartedPage;
    private SignInPage signInPage;
    private DeviceDashboardPage deviceDashboardPage;
    private ManageDevicesPage manageDevicePage;
    private CareSmartWatchSettingsPage careSmartWatchSettingsPage;

    public String getName() {
        return "Adjust Volume Test";
    }

    @Given("^I navigate to the Care Smart Watch Settings Page etc")
    public void setUpPage() {
        welcomePage = new WelcomePage(driver);
    }

    @Given("^Increase the volume$")
    public void loginSuccess() throws InterruptedException {
        Thread.sleep(5000);
        introPage = welcomePage.navigateToIntroductionPage();
        getStartedPage = introPage.navigateToGetStartedPage();
        signInPage = getStartedPage.navigateToSignInPage();
        deviceDashboardPage = signInPage.login("olexandr.kara@gmail.com", "Verizon91@");
        manageDevicePage = deviceDashboardPage.navigateToManageDevicesPage();
        careSmartWatchSettingsPage = manageDevicePage.navigateToCareSmartWatchSettingsPage();
        careSmartWatchSettingsPage.adjustVolume();
    }
}
