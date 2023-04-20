package com.ams.mod2.selenium.appmanager;

import org.openqa.selenium.WebDriver;

public class SettingsHelper extends HelperBase {

    public SettingsHelper(WebDriver driver) {
        super(driver);
    }

    public void openSettings(String field_name_rus) throws InterruptedException {
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

}
