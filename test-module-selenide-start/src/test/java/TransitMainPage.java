import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 *  Главная страница транзитного решения ЦРМС (new front , old croc-based backed)
 */
public class TransitMainPage {

    private final SelenideElement userName = $x("/html/body/div/div/div/div/div/div/div[2]/div/div/input");

    public void clickOnUserName(){

        userName.click();
    }


    public void openSite(String url){

        Selenide.open(url);
    }



}
