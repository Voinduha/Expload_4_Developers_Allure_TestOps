package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromFile;

@Tag("web")
@Feature("Downloading")
public class DownloadFileTest {

    @Test
    @DisplayName("Download readme file from GitHub")
    void pravdaDownloadReadMeTest() throws IOException {
        Configuration.downloadsFolder = "downloads";

        open("https://github.com/expload/pravda/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent;
        fileContent = readTextFromFile(downloadedFile);
        assertThat(fileContent, containsString("Pravda is a general purpose blockchain with PoA consensus"));
    }
}
