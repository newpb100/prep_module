package ru.asv.sandbox.ui.form;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchForm {

    //private final SelenideElement searchField = $x("/html/body/form/div[1]/ul");

    //private final SelenideElement searchField = $x("#text");


    //driver.findElement(By.name("text")).click();
    //driver.findElement(By.name("text")).clear();
    ///driver.findElement(By.name("text")).sendKeys("sdfsdfsdfsfsdfsdfsdfsdfsdfsdfsdfsff");


    public void sendData(String data){
        //searchField.sendKeys(data);
        //$("#text").sendKeys(data);
        //$(".text").sendKeys(data);
        //$(By.name("text")).sendKeys(data);
        //By bb = By.name("text");
        //SelenideElement se = bb;
        $(By.name("text")).pressEnter();
        //find("text") sendKeys(data);
    }

}
