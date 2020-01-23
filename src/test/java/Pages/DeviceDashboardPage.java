package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DeviceDashboardPage extends BasePage {

    protected DeviceDashboardPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[9]/android.view.ViewGroup[4]/android.view.ViewGroup")
    private MobileElement careSmartWatchTab;


    public ManageDevicesPage NavigateToManageDevicesPage() {
        careSmartWatchTab.click();
        return new ManageDevicesPage(driver);
    }

}
