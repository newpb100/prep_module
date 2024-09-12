import org.junit.jupiter.api.Test;
import ru.asv.sandbox.ui.form.SearchForm;
import ru.asv.sandbox.ui.page.MailMainPage;



public class MailSearchTest {


    //@Inject

    @Test
    public void openMailRu() throws InterruptedException {

        MailMainPage mailPage = new MailMainPage();
        mailPage.openSite();

        SearchForm sf = mailPage.getSearchForm();
        //sf.sendData("selenide");

        Thread.sleep(10000);
    }

}
