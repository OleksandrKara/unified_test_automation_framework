package com.verizon.mpersapp.qa.coho.tests.configuration;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Initialization of page object.
 * Classes marked annotation {@link PageObject}
 * will be initialized with WebDriver as page objects
 */
@Component("CorePO")
public class PageObjectBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    @Lazy
    private WrappedWebDriver driver;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(PageObject.class)) {
            //PageFactory.initElements(driver, bean);
            PageFactory.initElements(new AppiumFieldDecorator(driver.getWrappedDriver(), 50, TimeUnit.SECONDS), bean);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
