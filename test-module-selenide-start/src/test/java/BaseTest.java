import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


abstract public class BaseTest {

    public void setUp(){

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize =  "1920x1080";
        Configuration.headless = false;
    }


    @BeforeAll
    public void init(){

        setUp();
    }

    @AfterAll
    public void tearDown(){

        Selenide.closeWebDriver();
    }

}
