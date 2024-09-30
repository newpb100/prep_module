package ru.asv.sandbox.ui.form;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
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
        //$(By.name("text")).pressEnter();
        //find("text") sendKeys(data);


        //$(By.xpath("/html/body/form/input[1]")).shouldBe(visible);

        //$(By.name("text")).should(exist);

        $(By.xpath ("/html/body/main/div[2]/div[2]/div[1]/div/div/div[1]/button")).should(exist);
        $(By.xpath ("/html/body/main/div[2]/div[2]/div[1]/div/div/div[1]/button")).click();

        System.out.println("exxist!");

        $(By.xpath("//*[@id=\"grid\"]/div[2]/div[3]/div/div[1]/div/form/iframe")).should(exist);
        //$(By.xpath("//*[@id=\"grid\"]/div[2]/div[3]/div/div[1]/div/form/iframe")).sendKeys("111111");


        System.out.println("exxist 2!");




        //body > form > input.arrow__input.mini-suggest__input


        //$(By.name("text")).shouldBe(exist);



        ///html/body/form/input[1]
          //      /html/body/form

        //body > form > input.arrow__input.mini-suggest__input
    }

}
