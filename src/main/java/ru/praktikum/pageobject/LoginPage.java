package pageobject;

import data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String LOGIN_URL = "https://stellarburgers.nomoreparties.site/login";

    //Кнопка войти
    private final By loginButton = By.xpath("//button[contains(text(), 'Войти')]");

    //Кнопка зарегистрироваться
    private final By registrationButton = By.xpath("//a[text() ='Зарегистрироваться']");

    //Кнопка восстановить пароль
    private final By forgotButton = By.xpath("//a[text() ='Восстановить пароль']");

    //Поле для ввода email
    private final By emailInput = By.xpath("//input[@type ='text']");

    //Поле для ввода password
    private final By passwordInput = By.xpath("//input[@type ='password']");

    //Заголовок вход
    private final By headerText = By.xpath("//h2[text()='Вход']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //метод для нажатия на кнопку Зарегистрироваться
    public void clickRegistrationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        WebElement registerBtn = driver.findElement(registrationButton);
        registerBtn.click();
    }

    //метод для нажатия на кнопку Восстановить пароль
    public void clickForgotButton() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotButton));
        WebElement forgotBtn = driver.findElement(forgotButton);
        forgotBtn.click();
    }

    //Метод для заполнения email
    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(emailInput);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    //Метод для заполнения password
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(passwordInput);
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    //метод для нажатия на кнопку войти
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    //Метод для заполнения email password и нажатие кнопки войти
    public void inputEmailPasswordAndClickLogin(UserData userData) {
        enterEmail(userData.getEmail());
        enterPassword(userData.getPassword());
        clickLoginButton();
    }

    public String getCurrentUrl() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerText));
        return driver.getCurrentUrl();
    }

    public String getTextActualUrl() {
        wait.until(ExpectedConditions.urlContains(LOGIN_URL));
        return driver.getCurrentUrl();
    }
}