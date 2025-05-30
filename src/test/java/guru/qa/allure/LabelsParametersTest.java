package guru.qa.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

public class LabelsParametersTest {

    @Test
    public void testParameters(){
        Allure.parameter("Регион", "Москва");
        Allure.parameter("Область", "Московская");
        Allure.parameter("Улица", "Маросейка");

    }

}
