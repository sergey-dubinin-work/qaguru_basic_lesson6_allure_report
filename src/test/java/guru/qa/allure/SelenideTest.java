package guru.qa.allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testPullRequestSearch(){

        open("https://github.com/");

        $(".search-input-container").click();
        $("#query-builder-test").setValue("eroshenkoam/allure-example").submit();
        $(byLinkText("eroshenkoam/allure-example")).click();

        $$("a").find(text("Issues")).click();

        $(withText("#91")).shouldBe(visible, Duration.ofSeconds(5));

    }

}
