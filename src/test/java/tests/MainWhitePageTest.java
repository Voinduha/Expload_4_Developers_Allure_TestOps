package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("web")
public class MainWhitePageTest extends TestBase {

    @Test
    @DisplayName("Header should have Text \"SDK COMPONENTS\"")
    void mainHomePage() {

        open("");
        $("#home-1").shouldHave(text("SDK COMPONENTS"));

    }

    @Test
    @DisplayName("Page blocks should be loaded")
    void blocksLoadedTest() {

        open("");
        $("#header-white-1").shouldBe(visible);
        $("#home-1").shouldBe(visible);
        $("#home-2").shouldBe(visible);
        $("#home-3").shouldBe(visible);
        $("#home-4").shouldBe(visible);
        $("#header-white-2").shouldBe(visible);
    }

    @Test
    @DisplayName("Page should change language")
    void changeLanguageTest() {
        step("Open main page", () ->
                open(""));

        step("Change language on the page", () ->
                $("#header").shouldHave(text("Ru")).click());

        step("Verify successful switched", () ->
        $("#header-white-1 h1").shouldHave(text("A PLATFORM FOR THE DEVELOPMENT AND DISTRIBUTION OF OPEN-ECONOMY GAMES")));
    }
}
