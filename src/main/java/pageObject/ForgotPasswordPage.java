package pageObject;

import data.UserData;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Увеличил таймаут
    }

    //метод для нажатия на кнопку Восстановить
    public void clickRecoverButton() {
        wait.until(ExpectedConditions.elementToBeClickable(recoverButton));
        WebElement recoverBtn = driver.findElement(recoverButton);
        recoverBtn.click();
    }

    //метод для нажатия на кнопку войти (исправленный)
    public void clickLoginButton() {
        // Ждем исчезновения модального окна, если оно есть
        wait.until(ExpectedConditions.invisibilityOfElementLocated(modalOverlay));

        // Ждем кликабельности кнопки
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        WebElement loginBtn = driver.findElement(loginButton);
        loginBtn.click();
    }

    // Альтернативный метод с JavaScript кликом
    public void clickLoginButtonWithJS() {
        WebElement loginBtn = driver.findElement(loginButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
    }

    // Метод с попыткой обычного клика, а если не получается - JS клик
    public void clickLoginButtonSafe() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(loginButton));
            WebElement loginBtn = driver.findElement(loginButton);
            loginBtn.click();
        } catch (Exception e) {
            // Если обычный клик не сработал, используем JS клик
            WebElement loginBtn = driver.findElement(loginButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
        }
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(emailInput);
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    //Метод для заполнения email и нажатие кнопки восстановить
    public void inputEmailAndClickRecover(UserData userData) {
        enterEmail(userData.getEmail());
        clickRecoverButton();
    }
}