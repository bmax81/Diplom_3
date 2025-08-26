package pageobject;

import data.UserData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ForgotPasswordPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String FORGOT_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Кнопка восстановить
    private final By recoverButton = By.xpath("//button[text() ='Восстановить']");

    //Кнопка войти
    private final By loginButton = By.xpath("//a[text() ='Войти']");

    //Поле для ввода email
    private final By emailInput = By.xpath("//input[@type ='text']");

    // Модальное окно, которое перекрывает кнопку
    private final By modalOverlay = By.xpath("//div[contains(@class, 'Modal_modal_overlay__x2ZCr')]");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Нажать на кнопку 'Восстановить'")
    public void clickRecoverButton() {
        wait.until(ExpectedConditions.elementToBeClickable(recoverButton));
        WebElement recoverBtn = driver.findElement(recoverButton);
        recoverBtn.click();
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickLoginButton() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(modalOverlay));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    @Step("Ввести email: {email}")
    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(emailInput);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    @Step("Заполнить email и нажать кнопку 'Восстановить'")
    public void inputEmailAndClickRecover(UserData userData) {
        enterEmail(userData.getEmail());
        clickRecoverButton();
    }

    @Step("Проверить, что открыта страница восстановления пароля")
    public boolean isForgotPasswordPageOpen() {
        return driver.getCurrentUrl().equals(FORGOT_URL);
    }

    @Step("Ожидание загрузки страницы восстановления пароля")
    public void waitForForgotPasswordPageLoaded() {
        wait.until(ExpectedConditions.urlToBe(FORGOT_URL));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
    }
}