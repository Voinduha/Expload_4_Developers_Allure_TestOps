package tests;

import allure.JiraIssue;
import allure.JiraIssues;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DriverHelper.getConsoleLogs;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsNot.not;


@Owner("DanVu")
@Tag("web")
@JiraIssues({@JiraIssue("QC3-35")})
@Feature("Documentation")
public class DocumentationPageTest extends TestBase {
    @Test
    @DisplayName("Enter Documentation Page")
    void mainDocPage() {
        open("");

        $("#header-white-1").shouldHave(text("Getting started")).click();
    }

    @Test
    @DisplayName("Page should be opened from direct page")
    void shouldBeOpenedFromDirectPage() {
        step("Open main page", () ->
                open(""));

        step("Documentation page should be opened", () ->
                $(byText("Документация")).click());

        step("Overview main page should be opened ", () ->
                $("h1").shouldHave(text("Overview")).click());
    }

    @Test
    @AllureId("2167")
    @DisplayName("Page should not be opened from direct page")
    void shouldNotBeOpenedFromDirectPage() {
        step("Open main page", () ->
                open(""));

        step("Documentation page should not be opened", () ->
                $(byText("Overview")).click());

        step("Overview main page should not be opened ", () ->
                $("h1").shouldHave(text("Documentation")).click());
    }

    @Test
    @DisplayName("ConsoleLog should not have any errors")
    void consoleLogShouldNotHaveErrors() {
        step("Open documentation page", () -> open("/documentation"));

        step("Page should not have any errors (SEVERE) in console", () -> {
            String consoleLogs = getConsoleLogs();
            assertThat(consoleLogs, not(containsString("SEVERE")));
        });
    }
}