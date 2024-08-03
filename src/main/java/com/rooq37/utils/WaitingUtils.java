package com.rooq37.utils;

import com.rooq37.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitingUtils {

    private static final Duration DEFAULT_DURATION = Duration.ofSeconds(20);

    public static WebElement waitUntilElementIsVisible(By selector) {
        WebDriverWait webDriverWait = new WebDriverWait(BasePage.getDriver(), DEFAULT_DURATION);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

}
