package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.cssSelector;

public class TestForm {

        @Test
        void shouldSubmitRequest() {
                open("http://localhost:9999");
                SelenideElement form = $("[action]");
                form.$(cssSelector("[data-test-id=name] input")).sendKeys("Джек Лондон");
                form.$(cssSelector("[data-test-id=phone] input")).sendKeys("+79132435680");
                form.$(cssSelector("[data-test-id=agreement]")).click();
                form.$(cssSelector("[role=button]")).click();
                $("[data-test-id=order-success]").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
        }
}