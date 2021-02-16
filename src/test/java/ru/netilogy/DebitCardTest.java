package ru.netilogy;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DebitCardTest {
    @Test
    void shouldDebitCard() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Кузнецова Анастасия");
        $("[data-test-id=phone] input").setValue("+79658596936");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }


}


