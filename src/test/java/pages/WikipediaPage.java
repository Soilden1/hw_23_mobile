package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class WikipediaPage {

    private final SelenideElement errorMessage = $(id("org.wikipedia.alpha:id/view_wiki_error_text")),
            errorButton = $(id("org.wikipedia.alpha:id/view_wiki_error_button"));

    @Step("Проверить сообщение об ошибке")
    public WikipediaPage checkErrorMessage(String expectedErrorMessage) {
        errorMessage.shouldHave(text(expectedErrorMessage));
        return this;
    }

    @Step("Проверить наличие кнопки ошибки")
    public WikipediaPage checkErrorButton(String errorButtonName) {
        errorButton.shouldHave(text(errorButtonName));
        return this;
    }
}
