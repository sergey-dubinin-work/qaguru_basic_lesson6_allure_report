package guru.qa.allure;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testAllureLabels1(){
        Allure.label("owner", "dubinin.s");
        Allure.feature("Issue");
        Allure.story("Создание Issue для авторизованного пользователя");
        Allure.label("severity", SeverityLevel.BLOCKER.value());
        Allure.link("GitHub", "https://github.com/sergey-dubinin-work/");
    }

    @Test
    @Owner("dubinin.s")
    @Epic("SomeEpic")
    @Feature("Issue")
    @Story("Создание Issue")
    @DisplayName("Создание Issue для авторизованного пользователя")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://github.com/sergey-dubinin-work/")
    @TmsLink("AB-125")
    @Issue("CD-456")
    public void testAllureLabels2(){

    }

}
