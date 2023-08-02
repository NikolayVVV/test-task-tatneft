package ru.tatneft;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.tatneft.pages.GooglePage;
import ru.tatneft.pages.SearchingResultPage;
import ru.tatneft.pages.TatneftPage;
import org.junit.jupiter.api.Assertions;


public class AuthorizationTest {


    @Test
    public void shouldLogIntoTatneft() throws InterruptedException {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("http://www.google.com/");

        GooglePage googlePage = new GooglePage(driver);
        googlePage.searchByPhraseAndClickEnter("tatneft личный кабинет");

        SearchingResultPage searchingResultPage = new SearchingResultPage(driver);
        searchingResultPage.getPrivateCabinetTatneft().click();

        TatneftPage tatneftPage = new TatneftPage(driver);
        tatneftPage.getDemo().click();
        tatneftPage.inputLoginAndPassword("demo", "demo");
        Assertions.assertEquals("Константин Константинович", tatneftPage.getUser_name().getText());
        driver.quit();


    }
}
