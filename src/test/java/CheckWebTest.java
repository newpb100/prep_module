import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;


public class CheckWebTest {
    private List<String> sites;

    @Test
    public void AssertLists(){
        sites = new ArrayList<>();
        int a=2;

        // check bit shift
        int b=(a << 1);

        Sample.logger.info("shifted value of a = " + b);
        System.out.println("shifted value of a = " + b);

        sites.add("google.com");
        sites.add("yandex.ru");
        sites.add("mail.ru");

        //assertj
        assertThat(sites)
                .isNotEmpty()
                .hasSize(3)
                .doesNotHaveDuplicates()
                .contains("yandex.ru")
                .doesNotContain("yahoo.com");
    }

    @Test
    @Story("Trying to run selenide and open url")
    @Description("Correct url should be open in browser")
    public void RunSelenide(){
        // selenide
        open("http://google.com");
        Selenide.sleep(3000);
    }

    @Test
    public void UseJackson(){
        Sample sm1 = new Sample("test string",1);
        sm1.useJacksonToCreateObj();
    }
}
