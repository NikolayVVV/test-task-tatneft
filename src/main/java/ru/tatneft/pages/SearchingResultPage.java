package ru.tatneft.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SearchingResultPage extends BasePage {
    @FindBy(xpath = "//h3[text()='Вход в личный кабинет']")
    private WebElement privateCabinetTatneft;

    public SearchingResultPage(WebDriver driver) {
        super(driver);
    }
}