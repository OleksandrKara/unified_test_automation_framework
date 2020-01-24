package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CareSmartWatchSettingsPage extends BasePage {

    protected CareSmartWatchSettingsPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[11]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]")
    private MobileElement volumeSeekBar;


    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[8]/android.view.ViewGroup")
    private MobileElement quiteModeToggle;

    public void adjustVolume() throws InterruptedException {
        Thread.sleep(6000);

       int startX= volumeSeekBar.getLocation().getX();
       //int end = volumeSeekBar.getSize().getWidth();
        int moveToXDirectionAt = 20 + startX;
        int yAxis = volumeSeekBar.getLocation().getY();
       System.out.println(startX);
        //System.out.println(end);
        System.out.println(yAxis);
        TouchAction act=new TouchAction(driver);
        act.longPress(startX,yAxis).moveTo(moveToXDirectionAt,yAxis).release().perform();

        Thread.sleep(50000);
    }


    public boolean toggleQuiteMode() throws InterruptedException {

          quiteModeToggle.click();
        Thread.sleep(5000);

        return quiteModeToggle.isEnabled();
    }


}
