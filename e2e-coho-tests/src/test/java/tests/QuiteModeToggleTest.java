package Tests;

import Pages.*;
import Tests.AbstractBaseTests.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "classpath:SmartWatchSettingsTest",
        plugin = {"pretty"}
)

public class QuiteModeToggleTest extends TestBase {

    private WelcomePage welcomePage;
    private IntroductionPage introPage;
    private GetStartedPage getStartedPage;
    private SignInPage signInPage;
    private DeviceDashboardPage deviceDashboardPage;
    private ManageDevicesPage manageDevicePage;
    private  CareSmartWatchSettingsPage careSmartWatchSettingsPage;


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
        introPage = welcomePage.NavigateToIntroductionPage();
        getStartedPage=introPage.NavigateToGetStartedPage();
        signInPage=getStartedPage.NavigateToSignInPage();
        deviceDashboardPage=signInPage.login("olexandr.kara@gmail.com","Verizon91@");
        manageDevicePage=deviceDashboardPage.NavigateToManageDevicesPage();
        careSmartWatchSettingsPage=manageDevicePage.NavigateToCareSmartWatchSettingsPage();
        Assert.assertTrue(careSmartWatchSettingsPage.toggleQuiteMode());
    }
}
