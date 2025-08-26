package pageobject;

import data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String REGISTER_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final String ERROR_PASSWORD_TEXT = "Некорректный пароль";

    //Кнопка зарегистрироваться
    private final By registrationButton = By.xpath("//button[text() ='Зарегистрироваться']");

    //Кнопка войти
    private final By loginButton = By.xpath("//a[text() ='Войти']");

    //Поле для ввода name
    private final By nameInput = By.xpath("//label[contains(., 'Имя')]/following-sibling::input[@type='text']");

    //Поле для ввода email
    private final By emailInput = By.xpath("//label[contains(., 'Email')]/following-sibling::input[@type='text']");

    //Поле для ввода password
    private final By passwordInput = By.xpath("//input[@type ='password']");

    //Ошибка некорректный пароль
    private final By errorPassword = By.xpath("//p[text() ='" + ERROR_PASSWORD_TEXT + "']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //метод для нажатия на кнопку войти
    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    //Метод для заполнения name
    public void enterName(String name) {
        WebElement nameField = driver.findElement(nameInput);
        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.clear();
        nameField.sendKeys(name);
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

    //метод для нажатия на кнопку зарегистрироваться
    public void clickRegistrationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registrationButton));
        WebElement registerBtn = driver.findElement(registrationButton);
        registerBtn.click();
    }

    //Метод для заполнения name email password и нажатие кнопки зарегистрироваться
    public void inputNameEmailPasswordAndClickLogin(UserData userData) {
        enterName(userData.getName());
        enterEmail(userData.getEmail());
        enterPassword(userData.getPassword());
        clickRegistrationButton();
    }

    public String getErrorPasswordText() {
        WebElement errorPass = driver.findElement(errorPassword);
        wait.until(ExpectedConditions.visibilityOf(errorPass));
        return errorPass.getText();
    }
}