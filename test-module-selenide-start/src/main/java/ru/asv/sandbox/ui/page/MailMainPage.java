package ru.asv.sandbox.ui.page;

import com.codeborne.selenide.Selenide;
import ru.asv.sandbox.ui.form.SearchForm;

public class MailMainPage {

    private final static String BASE_URL = "https://mail.ru/";

    public SearchForm getSearchForm(){
        return new SearchForm();
    }

    public void openSite(){
        Selenide.open(BASE_URL);
    }
}
