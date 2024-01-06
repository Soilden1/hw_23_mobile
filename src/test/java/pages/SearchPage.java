package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {

    private final SelenideElement searchButton = $(accessibilityId("Search Wikipedia")),
            searchInput = $(id("org.wikipedia.alpha:id/search_src_text")),
            searchLine = $(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Нажать на кнопку поиска")
    public SearchPage searchButtonClick() {
        searchButton.click();
        return this;
    }

    @Step("Ввести поисковый запрос")
    public SearchPage enterQuery(String query) {
        searchInput.sendKeys(query);
        return this;
    }

    @Step("Кликнуть на строку поиска с введенным запросом")
    public SearchPage clickOnLineSearch(String query) {
        searchLine.shouldHave(text(query)).click();
        return this;
    }

    @Step("Результирующий список не пуст")
    public SearchPage checkNotNull() {
        $$(id("org.wikipedia.alpha:id/page_list_item_title")).shouldHave(sizeGreaterThan(0));
        return this;
    }
}
