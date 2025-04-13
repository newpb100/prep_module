package org.tests;

//import com.google.common.collect.*;
import com.google.common.collect.ImmutableMap;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.pages.BasePage;
import org.pages.LoginPage;
import org.utils.BasePageFactory;
import org.utils.BrowserManager;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import static org.config.ConfigurationManager.config;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

// Вопрос : допустимо ли использовать PER_CLASS с абстрактными классами?
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;
    protected LoginPage loginPage;
    private boolean needVideo;


    // Данный колбэк будет вызван до метода @AfterEach
    @RegisterExtension
    AfterTestExecutionCallback callback =
            context -> {
                Optional<Throwable> exception = context.getExecutionException();
                if (exception.isPresent()) {
                    needVideo = true;
                    captureScreenshotOnFailure();
                }
            };

    @AfterEach
    public void attach() {
        // Вызывается до условия If т.к. пока контекст не закрыт тест считается НЕ завершенным (в доке про это специально указано)
        browserContext.close();

        if (config().video() && needVideo) {
            captureVideo();
        }
        needVideo = false;
    }

    @BeforeEach
    public void createContext() {
        if (config().video()) {
            browserContext = browser.newContext(new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get(config().baseTestVideoPath())));
        } else {
            browserContext = browser.newContext();
        }
        page = browserContext.newPage();
        loginPage = createInstance(LoginPage.class);
    }


    @Attachment(value = "Test Video", type = "video/webm")
    @SneakyThrows
    private byte[] captureVideo() {
        return Files.readAllBytes(page.video().path());
    }

    @Attachment(value = "Failed Test Case Screenshot", type = "image/png")
    private byte[] captureScreenshotOnFailure(){
        return page.screenshot();
    }

    protected <T extends BasePage> T createInstance(Class<T> basePage) {
        return BasePageFactory.createInstance(page, basePage);
    }

    @BeforeAll
    public void initBrowser() {
        playwright = Playwright.create();
        browser = BrowserManager.getBrowser(playwright);

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Platform", System.getProperty("os.name"))
                        .put("Version", System.getProperty("os.version"))
                        .put("Browser", config().browser().toUpperCase())
                        .put("Context URL", config().baseUrl())
                        .build(),
                config().allureResultsDir() + "/");
    }

    @AfterAll
    public void close() {
        browser.close();
        playwright.close();
    }
}