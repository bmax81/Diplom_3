package tests;

import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProfilePage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static API.AuthAPI.registerUser;
import static org.apache.http.HttpStatus.SC_OK;

public class ProfileTest extends BaseTest {
    @BeforeEach
    void setUp() {
        super.setUp();
        registerUser(userData)
                .then()
                .statusCode(SC_OK);
        driver.get(LoginPage.LOGIN_URL);
        loginPage.inputEmailPasswordAndClickLogin(userData);
        mainPage.clickAccHeaderButton();
    }

    @Test
    @DisplayName("Проверка перехода в личный кабинет") // имя теста
    @Description("Base test for profile")
    public void testMainToProfile() {
        shouldDeleteUser = true;
        actualResult = profilePage.getInfoText();
        Assertions.assertEquals(ProfilePage.INFO_TEXT, actualResult);
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»") // имя теста
    @Description("Base test for profile")
    public void testProfileToConstructorClickConstructor() {
        shouldDeleteUser = true;
        profilePage.clickConstructorButton();
        actualResult = mainPage.getTextOrderButton();
        Assertions.assertEquals(MainPage.ORDER_BUTTON_TEXT, actualResult);
    }

    @Test
    @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»") // имя теста
    @Description("Base test for profile")
    public void testProfileToConstructorClickLogo() {
        shouldDeleteUser = true;
        profilePage.clickLogoButton();
        actualResult = mainPage.getTextOrderButton();
        Assertions.assertEquals(MainPage.ORDER_BUTTON_TEXT, actualResult);
    }

    @Test
    @DisplayName("Проверка выхода из личного кабинета") // имя теста
    @Description("Base test for profile")
    public void testProfileExit() {
        shouldDeleteUser = true;
        profilePage.clickExitButton();
        actualResult = loginPage.getCurrentUrl();
        Assertions.assertEquals(LoginPage.LOGIN_URL, actualResult);
    }
}