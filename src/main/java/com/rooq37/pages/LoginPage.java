package com.rooq37.pages;

import com.rooq37.utils.WaitingUtils;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private final By pageTitle = By.xpath("//div[@class='login_logo']");
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessageContainer = By.xpath("//div[@class='error-message-container error']/h3");

    public void open() {
        getDriver().get(PAGE_URL);
    }

    public String getPageTitle() {
        return WaitingUtils.waitUntilElementIsVisible(pageTitle).getText();
    }

    public void enterUsername(String username) {
        WaitingUtils.waitUntilElementIsVisible(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitingUtils.waitUntilElementIsVisible(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        WaitingUtils.waitUntilElementIsVisible(loginButton).click();
    }

    public String getErrorMessage() {
        return WaitingUtils.waitUntilElementIsVisible(errorMessageContainer).getText();
    }

}
