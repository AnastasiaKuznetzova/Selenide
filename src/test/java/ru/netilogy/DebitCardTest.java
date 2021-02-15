package ru.netilogy;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DebitCardTest {
    @Test
    void shouldDebitCard(){
        open("http"://localhost:9999");
        SelenideElement from = $("[data-test-id=debitCard-from]");
        from



    }

}
