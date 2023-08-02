package ru.tatneft.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public abstract class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
