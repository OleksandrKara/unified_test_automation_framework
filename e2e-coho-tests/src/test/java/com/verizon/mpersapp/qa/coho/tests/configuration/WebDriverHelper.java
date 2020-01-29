package com.verizon.mpersapp.qa.coho.tests.configuration;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("CoreWebdriverHelper")
@Lazy
@Slf4j
public class WebDriverHelper {
    @Autowired
    @Lazy
    @Qualifier("CoreDriver")
    private WrappedWebDriver driver;

    public void quit() {
        driver.quit();
    }

    /**
     * Tries three times to send text to element properly.
     *
     * Note: This method was needed because Appium sometimes sends text to textboxes incorrectly.
     *
     * @param input String to be sent
     * @param element WebElement to receive text, cannot be a secure text field.
     * @param appendNewLine true to append a new line character to incoming string when sending to element, else false
     *
     * @return true if keys were successfully sent, otherwise false.
     */
    public boolean sendKeysToElement(String input, WebElement element, boolean appendNewLine) throws InterruptedException {
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;

        do {
            element.clear();
            Thread.sleep(WaitConfig.KEYBOARD_ANIMATION_DELAY);

            if (appendNewLine) {
                element.sendKeys(input + "\n");
            } else {
                element.sendKeys(input);
            }

            Thread.sleep(WaitConfig.XML_REFRESH_DELAY);
        } while (!element.getText().contains(input) && ++attempts < MAX_ATTEMPTS);

        return element.getText().contains(input);
    }

    public void resetApp() {
        driver.getWrappedDriver().resetApp();
    }
}
