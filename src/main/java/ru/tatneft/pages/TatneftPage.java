package ru.tatneft.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lombok.Getter;

@Getter
public class TatneftPage extends BasePage {

    @FindBy(xpath = "//a[text()=' Демо ']")
    private WebElement demo;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement login_field;

    @FindBy(xpath = "//input[@name='slqpassword']")
    private WebElement password_field;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit_field;

    @FindBy(xpath = "//a[text() = 'Константин Константинович']")
    private WebElement user_name;





    public TatneftPage(WebDriver driver) {
        super(driver);
    }


    public TatneftPage inputLoginAndPassword(String login, String password) {
        login_field.sendKeys(login);
        password_field.sendKeys(password);
        submit_field.sendKeys(Keys.RETURN);
        return new TatneftPage(driver);
    }


}
