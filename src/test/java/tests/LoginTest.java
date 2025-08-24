package tests;

import pageObject.ForgotPasswordPage;
import pageObject.MainPage;
import pageObject.RegistrationPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static API.AuthAPI.registerUser;
import static org.apache.http.HttpStatus.SC_OK;

public class LoginTest extends BaseTest {
    @BeforeEach
    void setUp() {
        super.setUp();
        registerUser(userData)
                .then()
                .statusCode(SC_OK);
    }

    @Test
    @DisplayName("Check login для кнопки войти в аккаунт") // имя теста
    @Description("Base test for login")
    public void testLoginForAccHeaderButton() {
        shouldDeleteUser = true;
        driver.get(MainPage.MAIN_URL);
        mainPage.clickAccHeaderButton();

        loginPage.inputEmailPasswordAndClickLogin(userData);

        actualResult = mainPage.getTextOrderButton();
        Assertions.assertEquals(MainPage.ORDER_BUTTON_TEXT, actualResult);
        actualUrl = mainPage.getTextActualUrl();
        Assertions.assertEquals(MainPage.MAIN_URL, actualUrl);
    }

    @Test
    @DisplayName("Check login для кнопки войти в аккаунт") // имя теста
    @Description("Base test for login")
    public void testLoginForAccButton() {
        shouldDeleteUser = true;
        driver.get(MainPage.MAIN_URL);
        mainPage.clickAccButton();

        loginPage.inputEmailPasswordAndClickLogin(userData);

        actualResult = mainPage.getTextOrderButton();
        Assertions.assertEquals(MainPage.ORDER_BUTTON_TEXT, actualResult);
        actualUrl = mainPage.getTextActualUrl();
        Assertions.assertEquals(MainPage.MAIN_URL, actualUrl);
    }

    @Test
    @DisplayName("Check login для кнопки войти в аккаунт") // имя теста
    @Description("Base test for login")
    public void testForRegisterPageLoginButton() {
        shouldDeleteUser = true;
        driver.get(RegistrationPage.REGISTER_URL);
        registrationPage.clickLoginButton();

        loginPage.inputEmailPasswordAndClickLogin(userData);

        actualResult = mainPage.getTextOrderButton();
        Assertions.assertEquals(MainPage.ORDER_BUTTON_TEXT, actualResult);
        actualUrl = mainPage.getTextActualUrl();
        Assertions.assertEquals(MainPage.MAIN_URL, actualUrl);
    }

    @Test
    @DisplayName("Check login для кнопки войти в аккаунт") // имя теста
    @Description("Base test for login")
    public void testForForgotPageLoginButton() {
        shouldDeleteUser = true;
        driver.get(ForgotPasswordPage.FORGOT_URL);
        forgotPasswordPage.clickLoginButton();

        loginPage.inputEmailPasswordAndClickLogin(userData);

        actualResult = mainPage.getTextOrderButton();
        Assertions.assertEquals(MainPage.ORDER_BUTTON_TEXT, actualResult);
        actualUrl = mainPage.getTextActualUrl();
        Assertions.assertEquals(MainPage.MAIN_URL, actualUrl);
    }

    public static Stream<Arguments> loginButtonProvider() {
        return Stream.of(
                // Реализуй тестовые данные
                Arguments.of("header"), Arguments.of("main"), Arguments.of("register"), Arguments.of("forgot"));
    }
}