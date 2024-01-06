package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SearchPage;
import pages.WikipediaPage;

public class SearchTest extends TestBase {

    private final SearchPage searchPage = new SearchPage();
    private final WikipediaPage wikipediaPage = new WikipediaPage();

    @Test
    @DisplayName("Поиск работает и показывает результирующий список")
    void successfulSearchTest() {
        searchPage.searchButtonClick()
                .enterQuery("Appium")
                .clickOnLineSearch("Appium")
                .checkNotNull();
    }

    @Test
    @DisplayName("Проверить отображение сообщения об ошибке на странице википедии")
    void checkErrorMessageTest() {
        searchPage.searchButtonClick()
                .enterQuery("Appium")
                .clickOnLineSearch("Appium")
                .checkNotNull();

        wikipediaPage.checkErrorMessage("An error occurred")
                .checkErrorButton("GO BACK");
    }
}
