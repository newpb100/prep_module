package com.ams.mod2.selenium.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsHelper {
    private WebDriver driver;

    public SettingsHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openSettings(String field_name_rus) throws InterruptedException {
        int treeIndex = 0;
        // open settings
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/div/div/div[1]")).click();
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
        driver.findElement(By.xpath("/html/body/app-root/div/app-extraction-project-outlet/app-expertise-conditions/div[1]/div[1]/div[1]/app-objects-tree/div/div[2]/itsk-tree/itsk-tree-host/itsk-tree-item[" + treeIndex + "]")).click();
        Thread.sleep(3000);
    }

    public void openProject(String monthAndYearRus) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ошибки'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Проекты'])[1]/following::*[name()='svg'][2]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='" + monthAndYearRus +"'])[1]/following::span[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отмена'])[1]/following::button[1]")).click();
    }
}
