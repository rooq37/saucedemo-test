import com.rooq37.pages.BasePage;
import com.rooq37.pages.InventoryPage;
import com.rooq37.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {

    private static final String CORRECT_PASSWORD = "secret_sauce";

    private final LoginPage loginPage = new LoginPage();
    private final InventoryPage inventoryPage = new InventoryPage();

    @AfterClass
    public void afterClass() {
        BasePage.quitDriver();
    }

    @Test
    public void standardUserLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword(CORRECT_PASSWORD);
        loginPage.clickLoginButton();
        assertThat(inventoryPage.getPageTitle()).isEqualTo("Swag Labs");
    }

    @Test
    public void lockedOutUserLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword(CORRECT_PASSWORD);
        loginPage.clickLoginButton();
        assertThat(loginPage.getErrorMessage()).isEqualTo("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void problemUserLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("problem_user");
        loginPage.enterPassword(CORRECT_PASSWORD);
        loginPage.clickLoginButton();
        assertThat(inventoryPage.getPageTitle()).isEqualTo("Swag Labs");
    }

    @Test
    public void performanceGlitchUserLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("performance_glitch_user");
        loginPage.enterPassword(CORRECT_PASSWORD);
        loginPage.clickLoginButton();
        assertThat(inventoryPage.getPageTitle()).isEqualTo("Swag Labs");
    }

    @Test
    public void errorUserLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("error_user");
        loginPage.enterPassword(CORRECT_PASSWORD);
        loginPage.clickLoginButton();
        assertThat(inventoryPage.getPageTitle()).isEqualTo("Swag Labs");
    }

    @Test
    public void visualUserLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("visual_user");
        loginPage.enterPassword(CORRECT_PASSWORD);
        loginPage.clickLoginButton();
        assertThat(inventoryPage.getPageTitle()).isEqualTo("Swag Labs");
    }

    @Test
    public void nonExistentUserLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("non_existent_user");
        loginPage.enterPassword(CORRECT_PASSWORD);
        loginPage.clickLoginButton();
        assertThat(loginPage.getErrorMessage()).isEqualTo("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void standardUserWrongPasswordLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("wrongpassword123");
        loginPage.clickLoginButton();
        assertThat(loginPage.getErrorMessage()).isEqualTo("Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void emptyUsernameEmptyPasswordLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        assertThat(loginPage.getErrorMessage()).isEqualTo("Epic sadface: Username is required");
    }

    @Test
    public void standardUserEmptyPasswordLoginTest() {
        loginPage.open();
        assertThat(loginPage.getPageTitle()).isEqualTo("Swag Labs");

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        assertThat(loginPage.getErrorMessage()).isEqualTo("Epic sadface: Password is required");
    }

}
