package guru.qa.allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 68;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testPullRequestSearchWithLambdaSteps(){

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Поиск репозитория " + REPOSITORY, () -> {
            $(".search-input-container").click();
            $("#query-builder-test").setValue(REPOSITORY).submit();
        });

        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(byLinkText(REPOSITORY)).click();
        });

        step("Открываем tab Issues", () -> {
            $$("a").find(text("Issues")).click();
        });

        step("Проверяем наличие Issue с номером " + NUMBER, () -> {
            $(withText("#" + NUMBER)).shouldBe(visible, Duration.ofSeconds(5));
        });

    }

    @Test
    public void annotatedStepsTest(){
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(NUMBER);
    }


}
