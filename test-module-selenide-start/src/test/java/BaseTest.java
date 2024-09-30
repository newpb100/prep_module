import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_METHOD)
abstract public class BaseTest {

    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize =  "1920x1080";
        Configuration.headless = false;
    }


    @BeforeAll
    public static void init(){

        setUp();
    }

    @AfterAll
    public static void tearDown(){

        Selenide.closeWebDriver();
    }

}
