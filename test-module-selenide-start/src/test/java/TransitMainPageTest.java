import org.junit.Test;

public class TransitMainPageTest extends BaseTest {

    private final static String BASE_URL = "http://172.29.253.70:8081/";


    @Test
    public void openTransitMainPage() throws InterruptedException {

        // step 1 - logOn - перенести

        TransitMainPage tmp = new TransitMainPage();
        tmp.openSite(BASE_URL);

        Thread.sleep(5000);

    }

}
