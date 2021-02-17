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
        $("[data-test-id=order-success]")
                .shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldIncorrectFillingDebitCard() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("wert fddfdr");
        $("[data-test-id=phone] input").setValue("+79658596936");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".input_type_text .input__sub")
                .shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void  shouldGetErrorMessageIfNameEmpty() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("");
        $("[data-test-id=phone] input").setValue("+79658596936");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".input_type_text .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldGetErrorMessageIfPhoneInvalid() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Кузнецова Анастасия");
        $("[data-test-id=phone] input").setValue("+796585969367");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".input_type_tel .input__sub")
                .shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldGetErrorMessageIfDontClickAgreement() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Кузнецова Анастасия");
        $("[data-test-id=phone] input").setValue("+79658596936");
        $(".button").click();
        $(".input_type_tel .input__sub")
                .shouldHave(exactText("На указанный номер моб. тел. будет отправлен смс-код для подтверждения заявки на карту." +
                        " Проверьте, что номер ваш и введен корректно."));
    }
    @Test
    void shouldGetErrorMessageIfIfPhoneEmpty() {
        open("http://localhost:9999/");
        $("[data-test-id=name] input").setValue("Кузнецова Анастасия");
        $("[data-test-id=phone] input").setValue("");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $(".input_type_tel .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

}


