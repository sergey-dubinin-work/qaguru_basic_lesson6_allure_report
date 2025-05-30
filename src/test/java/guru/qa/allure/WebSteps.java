package guru.qa.allure;

import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Поиск репозитория {repository}")
    public void searchForRepository(String repository){
        $(".search-input-container").click();
        $("#query-builder-test").setValue(repository).submit();
    }

    @Step("Переходим в репозиторий {repository}")
    public void openRepositoryPage(String repository){
        $(byLinkText(repository)).click();
    }

    @Step("Открываем tab Issues")
    public void openIssueTab(){
        $$("a").find(text("Issues")).click();
    }

    @Step("Проверяем наличие Issue с номером {number}")
    public void shouldSeeIssueWithNumber(int number){
        $(withText("#" + number)).shouldBe(visible, Duration.ofSeconds(5));
    }
}
