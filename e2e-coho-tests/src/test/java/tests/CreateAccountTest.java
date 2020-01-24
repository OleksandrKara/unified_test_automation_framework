package Tests;

import Pages.*;
import Tests.AbstractBaseTests.TestBase;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;

@CucumberOptions(
        strict = true,
        monochrome = true,
        features = "classpath:CreateAccountTest",
        plugin = {"pretty"}
)
public class CreateAccountTest extends TestBase {
    private WelcomePage welcomePage;
    private IntroductionPage introPage;
    private GetStartedPage getStartedPage;
    private CreateAccountOptionsPage createAccountOptionsPage;
    private CreateAccountPage createAccountPage;

    public String getName() {
        return "Create Account Test";
    }

    @Given("^I navigate to the Create Account page$")
    public void setUpPage() {
        welcomePage = new WelcomePage(driver);
    }


    @Given("^All valid input values$")
    public void createAccountSuccess() throws InterruptedException {
        Thread.sleep(5000);
        introPage = welcomePage.NavigateToIntroductionPage();
        getStartedPage=introPage.NavigateToGetStartedPage();
        createAccountOptionsPage=getStartedPage.NavigateToCreateAccountOptionsPage();
        createAccountPage=createAccountOptionsPage.NavigateToCreateAccountPage();
        createAccountPage.createAccount("Test", "8134038630", "saikrishna.goli@verizon.com", "Verizon19@");
    }
}
