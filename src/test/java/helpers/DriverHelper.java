package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.ConfigHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class DriverHelper {
    public static void configureDriver() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

        Configuration.baseUrl = ConfigHelper.getWebUrl();
        Configuration.startMaximized = true;

        if (ConfigHelper.isRemoteWebDriver()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            ChromeOptions chromeOptions = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("intl.accept_languages", "ru");
            chromeOptions.setExperimentalOption("prefs", prefs);
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

            Configuration.browserCapabilities = capabilities;
            Configuration.remote = ConfigHelper.getWebRemoteDriver();
        }
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid", "");
    }

    public static String getConsoleLogs() {
        return String.join("\n", Selenide.getWebDriverLogs(BROWSER));
    }
}
