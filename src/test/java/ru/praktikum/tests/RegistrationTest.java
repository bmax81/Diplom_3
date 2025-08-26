package tests;

import pageobject.LoginPage;
import pageobject.RegistrationPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static api.AuthAPI.loginUser;
import static org.apache.http.HttpStatus.SC_OK;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Check of registration") // имя теста
    @Description("Base test for registration")
    public void testRegistration() {
        shouldDeleteUser = true;
        driver.get(RegistrationPage.REGISTER_URL);
        registrationPage.inputNameEmailPasswordAndClickLogin(userData);
        loginUser(userData)
                .then()
                .statusCode(SC_OK);
        actualUrl = loginPage.getTextActualUrl();
        Assertions.assertEquals(LoginPage.LOGIN_URL, actualUrl);
    }

    @Test
    @DisplayName("Check registration with short password") // имя теста
    @Description("Negative test for registration")
    public void testRegistrationWithShortPassword() {
        driver.get(RegistrationPage.REGISTER_URL);
        registrationPage.inputNameEmailPasswordAndClickLogin(userDataWithShortPassword);
        actualResult = registrationPage.getErrorPasswordText();
        Assertions.assertEquals(registrationPage.ERROR_PASSWORD_TEXT, actualResult);
    }
}