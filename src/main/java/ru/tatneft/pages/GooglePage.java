package ru.tatneft.pages;

import lombok.SneakyThrows;
import org.openqa.selenium.*;


public class GooglePage extends BasePage {
    private final WebElement searchField;

    @SneakyThrows
    public GooglePage(WebDriver driver) {
        super(driver);
        driver.navigate().to("http://www.google.com/");


        if (searchFieldIsDisplayed(By.name("q"))) {
            searchField = driver.findElement(By.name("q"));
        } else {
            throw new NoSuchElementException("не нашли элемент searchField");
        }
    }

    public SearchingResultPage searchByPhraseAndClickEnter(String phrase) {
        searchField.click();
        searchField.sendKeys(phrase);
        searchField.sendKeys(Keys.RETURN);
        return new SearchingResultPage(driver);
    }

    @SneakyThrows
    public boolean searchFieldIsDisplayed(By by) {
        for (int i = 0; i < 10; i++) {
            if (driver.findElement(by).isDisplayed()) return true;
            Thread.sleep(1000);
        }
        return false;
    }
}