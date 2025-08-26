package tests;

import browser.DriverFactory;
import data.UserData;
import pageobject.*;
import io.restassured.RestAssured;
import net.datafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static api.AuthAPI.*;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;

public class BaseTest {
    Faker faker = new Faker();
    String name = faker.name().firstName();
    String email = name + "053" + "@test.ru";
    String password = faker.regexify("[A-Za-z0-9]{10}");
    String shortPassword = faker.regexify("[A-Za-z0-9]{5}");

    WebDriver driver;
    MainPage mainPage;
    RegistrationPage registrationPage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;
    ProfilePage profilePage;
    UserData userData = new UserData(email, password, name);
    UserData userDataWithShortPassword = new UserData(email, shortPassword, name);
    String accessToken;
    boolean shouldDeleteUser = false;
    String actualResult;
    String actualUrl;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.getWebDriver();
        driver.manage().window().maximize();
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";

        // создали объекты классов страниц
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
        loginPage = new LoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        profilePage = new ProfilePage(driver);

        // Открываем главную страницу один раз для всех тестов
        driver.get(MainPage.MAIN_URL);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (shouldDeleteUser && accessToken != null) {
            try {
                deleteUser(accessToken)
                        .then()
                        .statusCode(SC_ACCEPTED);
            } catch (Exception e) {
                System.err.println("Ошибка при удалении пользователя: " + e.getMessage());
            }
        }
    }
}