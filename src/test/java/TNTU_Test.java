import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TNTU_Test {

    @BeforeAll
    static void beforeAll() {
        Configuration.screenshots = true;
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "screenshots";
    }

    @Test
    public void testContactMe() {
        open("https://www.google.com");
        $(Selectors.byName("q")).setValue("TNTU").pressEnter();

        $(By.xpath("//a[@href='http://tntu.edu.ua/']"))
                .waitUntil(Condition.visible, 10000)
                .click();

        $(By.xpath("//a[@href='http://dl.tntu.edu.ua/']"))
                .click();

        $(By.xpath("//*[@id='logo-site-logo']"))
                .shouldBe(Condition.visible, Condition.text("Електронне навчання в ТНТУ"));
        Selenide.screenshot("logo");
    }
}
