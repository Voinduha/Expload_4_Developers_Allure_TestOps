package tests;

import io.qameta.allure.Feature;
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

@Tag("web")
@Feature("Documentation")
public class DocumentationPageTest extends TestBase {
    @Test
    @DisplayName("Enter Documentation Page")
    void mainDocPage() {

        open("");

        $("#header-white-1").shouldHave(text("Getting started")).click();
    }

    @Test
    @DisplayName("Page should Be Opened From DirectPage")
    void shouldBeOpenedFromDirectPage() {
        step("Open main page", () ->
                open(""));

        step("Documentation page should be opened", () ->
                $(byText("Documentation")).click());

        step("Overview main page should be opened ", () ->
                $("h1").shouldHave(text("Overview")).click());
    }

    @Test
    @DisplayName("ConsoleLog Should Not Have any Errors")
    void consoleLogShouldNotHaveErrors() {
        open("/documentation");
        String consoleLogs = getConsoleLogs();
        assertThat(consoleLogs, not(containsString("SEVERE")));
    }
}