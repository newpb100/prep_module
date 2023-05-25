package com.ams.mod2.selenium.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.fail;

public class ApplicationManager {
    private SessionHelper sessionHelper;
    private SettingsHelper settingsHelper;

    WebDriver driver;
    String browserType;

    JavascriptExecutor js;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    public ApplicationManager(String browserType) {
        this.browserType = browserType;
    }

    public void init() {
        if  (browserType.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        }else if (browserType.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        }else if (browserType.equals(BrowserType.EDGE)) {
            System.setProperty("webdriver.edge.driver", "C://work//bin//drivers//msedgedriver.exe");
            // почему-то для эджа, несмотря на то, что драйвер находится также как и другие в области видимости системной переменной
            // нужно еще и явно прописывать через System.setProperty
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();

        sessionHelper = new SessionHelper(driver);
        settingsHelper = new SettingsHelper(driver);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        /* неявное ожидание до 60 секунд, если элемент появится, то ожидание прекратится и код продолжится,
        *  однако, обратная сторона, это конструкции вида:
        *       Assert.assertFalse(By.name("locator_name"));
        *  мы знаем, что такого элемента НЕТ и хотим в этом удостовериться через условие FALSE,
        *  в этом случае, мы будем здесь зависать на эти самые 60 сек, потому что драйвер будет ждать, что элемент появится
        * */

        js = (JavascriptExecutor) driver;
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public SettingsHelper getSettingsHelper() {
        return settingsHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
