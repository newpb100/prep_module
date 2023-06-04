package com.ams.mod2.selenium.appmanager;

import com.ams.mod2.selenium.dto.BorderParam;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SettingsHelper extends HelperBase {

    private By by;

    public SettingsHelper(WebDriver driver) {
        super(driver);
    }

    public void openSettingsOfFieldByName(String field_name_rus) throws InterruptedException {
        int treeIndex = 0;
        // open settings
        click("/html/body/app-root/div/app-extraction-project-outlet/div/div/div[1]");
        // open field
        switch (field_name_rus) {
            case "Валынтойское":
                treeIndex = 1;
                break;
            case "Воргенское":
                treeIndex = 2;
                break;
            default:
                treeIndex = 1;
        }

        Thread.sleep(5000);
        click("/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/app-objects-tree/div/div[2]/itsk-tree/itsk-tree-host/itsk-tree-item[" + treeIndex + "]");
        Thread.sleep(3000);
    }

    public void openProject(String monthAndYearRus) {
        click("(.//*[normalize-space(text()) and normalize-space(.)='Ошибки'])[1]/following::button[1]");
        click("(.//*[normalize-space(text()) and normalize-space(.)='Проекты'])[1]/following::*[name()='svg'][2]");
        click("(.//*[normalize-space(text()) and normalize-space(.)='" + monthAndYearRus + "'])[1]/following::span[1]");
        click("(.//*[normalize-space(text()) and normalize-space(.)='Отмена'])[1]/following::button[1]");
    }

    public void openSectionDostrely() throws InterruptedException {
        // open section
        click("/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/div/div/div[2]/itsk-tabs/div[2]/div/itsk-grid/itsk-grid-body/div/div[7]/div/div/itsk-grid-expand");
        Thread.sleep(2000);
    }

    public void moveToOptions() throws InterruptedException  {
        click("//span[@id='calcOptions']/span");
        Thread.sleep(2000);
    }

    public void openOptionsDostrely() throws InterruptedException {
        click("(.//*[normalize-space(text()) and normalize-space(.)='ОПТ (10)'])[1]/following::*[name()='svg'][1]");
        Thread.sleep(2000);
    }

    public void checkBorderParams() {
        String[][] xpathBordersArr = {
                {"150", "Минимальное Рпл, Атм", "/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/div/div/div[2]/itsk-tabs/div[2]/div/itsk-grid/itsk-grid-body/div/div[9]/itsk-grid-cell[4]/itsk-default-cell/span"},
                {"51", "Максимальный остановочный дебит, т/сут", "/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/div/div/div[2]/itsk-tabs/div[2]/div/itsk-grid/itsk-grid-body/div/div[10]/itsk-grid-cell[4]/itsk-default-cell/span"}
        };

        for (int i = 0; i < xpathBordersArr.length; i++) {
            by = new By.ByXPath(xpathBordersArr[i][2]);
            if (isElementPresent(by)){
                System.out.println("border element found ; value = " + driver.findElement(by).getText());
                Assert.assertTrue("Border element "+ xpathBordersArr[i][1] + " not equal to default value", (driver.findElement(by).getText()).equals(xpathBordersArr[i][0]));
            }else{
                System.out.println("no such border element!");
            }

        }

    }

    public void checkBorderParamsList() {
        List<BorderParam> listBP = fillBorderParamList();

        for (BorderParam bp: listBP) {
            by = new By.ByXPath(bp.getXpath());
            if (isElementPresent(by)) {
                System.out.println("border element found ; value = " + driver.findElement(by).getText());
                Assert.assertTrue("Border element "+ bp.getBorderName() + " not equal to default value", (driver.findElement(by)).getText().equals(bp.getBorder()));
            } else {
                System.out.println("no such border element!");
            }
        }
    }

    private List<BorderParam> fillBorderParamList() {
        List<BorderParam> listBP = new ArrayList<BorderParam>();
        listBP.add(new BorderParam("150", "Минимальное Рпл, Атм", "/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/div/div/div[2]/itsk-tabs/div[2]/div/itsk-grid/itsk-grid-body/div/div[9]/itsk-grid-cell[4]/itsk-default-cell/span"));
        listBP.add(new BorderParam("50", "Максимальный остановочный дебит, т/сут", "/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/div/div/div[2]/itsk-tabs/div[2]/div/itsk-grid/itsk-grid-body/div/div[10]/itsk-grid-cell[4]/itsk-default-cell/span"));
        listBP.add(new BorderParam("53", "С-буква", "xpath3"));
        listBP.add(new BorderParam("54", "Р-буква", "xpath4"));
        listBP.add(new BorderParam("55", "Т-буква", "xpath5"));
        return listBP;
    }

    // for educational purposes, no business value
    public void compareBorderParamsList() {
        List<BorderParam> listBP_1 = fillBorderParamList();
        List<BorderParam> listBP_2 = fillBorderParamList();
        System.out.println(listBP_1.toString());
        System.out.println(listBP_2.toString());
        Assert.assertEquals("Objects are NOT equal", listBP_1, listBP_2);
    }


    // for educational purposes, no business value
    public void compareListsAfterChanges(){
        List<BorderParam> ls1 = fillBorderParamList();
        //System.out.println("ls1 = " + ls1.toString());
        for(BorderParam bp: ls1){
            System.out.print(bp.getBorder() + ":" + bp.getBorderName() + " ; ");
        }
        // полностью модифицируем 2-й элемент , чтобы проверить, будет ли от этого изменение порядка элементов в списке, т.е. изменятся ли индексы элементов
        ls1.get(2).setBorder("63");
        ls1.get(2).setXpath("//sf/sdf/sf/sf/sdf/sd/fsdf/sdf/s/df/sdf/sd/f/sdf/sd/f/sdf/sd/f/sdf/sd/fsd/fs/df");
        ls1.get(2).setBorderName("Новое название для бордер элемента с индексом 2");
        // еще немного 3-й элемент
        ls1.get(3).setXpath("//gdfg/df/g/dfg/d/fg//dfg/d/fg///j/t/yjmy/t/m/tym/ty/m/t////tyuty/u/ty/ut/yu/ty/u/ty/ut/yu/t");
        // при печати видно, что порядок не меняется
        //System.out.println("ls1 = " + ls1.toString());
        System.out.println();
        for(BorderParam bp: ls1){
            System.out.print(bp.getBorder() + ":" + bp.getBorderName() + " ; ");
        }
    }


    // for educational purposes, no business value
    public void checkNavigationLinks() throws InterruptedException {
        by = new By.ByClassName("nav-link");
        List<WebElement> navListBefore = driver.findElements(by);
        int beforeNavLinksCount = navListBefore.size();

        System.out.println("beforeNavLinksCount = " + beforeNavLinksCount);

        /*                  */
        /*  some logic here */
        /*                  */

        List<WebElement> navListAfter = driver.findElements(by);
        List<WebElement> navListAfter2 = new ArrayList<WebElement>();
        int afterNavLinksCount = navListAfter.size();
        System.out.println("afterNavLinksCount = " + afterNavLinksCount);

        /*
        by = new By.ByClassName("nav-link123123");
        int noSuchElemsCount = (driver.findElements(by)).size();  // findElements - особенность - он просто ждет неявное ожидание и потом не выкидывает эксепшн, а возвращает пустой список
        System.out.println("noSuchElemsCount = = " + noSuchElemsCount);
        */

        Assert.assertTrue("Amount of nav links at start of test NOT equal to amount at the end of the test", beforeNavLinksCount == afterNavLinksCount);

        Assert.assertEquals("Objects are NOT equal", navListBefore, navListAfter);
        // Assert.assertEquals("Objects are NOT equal", navListBefore, navListAfter2);  <- test fail

        //check all nav tabs with click
        for (int i = 0; i < navListAfter.size(); i++) {
            navListAfter.get(i).click();

            Thread.sleep(1000);
        }
    }


}
