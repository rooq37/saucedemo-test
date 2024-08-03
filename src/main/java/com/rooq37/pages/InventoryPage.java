package com.rooq37.pages;

import com.rooq37.utils.WaitingUtils;
import org.openqa.selenium.By;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.xpath("//div[@class='app_logo']");

    public String getPageTitle() {
        return WaitingUtils.waitUntilElementIsVisible(pageTitle).getText();
    }

}
