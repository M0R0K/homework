package pages.components;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TableComponent {

    private static SelenideElement table = $(".table-responsive");

    public static void checkResult(String key, String value) {
        table.$(byText(key)).parent()
                .shouldHave(text(value));

    }
}
