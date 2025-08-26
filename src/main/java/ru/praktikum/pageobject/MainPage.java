package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String MAIN_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String ORDER_BUTTON_TEXT = "Оформить заказ";
    public static final String BUN_FLUORESCENT = "Флюоресцентная булка R2-D3";
    public static final String SAUCE_SPICY = "Соус Spicy-X";
    public static final String FILLING_MEAT = "Мясо бессмертных моллюсков Protostomia";

    // Кнопка личный кабинет
    private final By accHeaderButton = By.xpath("//p[text() ='Личный Кабинет']");

    // Кнопка войти в аккаунт
    private final By accButton = By.xpath("//button[text() ='Войти в аккаунт']");

    // Кнопка оформить заказ
    private final By orderButton = By.xpath("//button[text() ='" + ORDER_BUTTON_TEXT + "']");

    // Кнопка булки
    private final By bunButton = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Булки']]");

    // Кнопка Соусы
    private final By sauceButton = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Соусы']]");

    // Кнопка Начинки
    private final By fillingButton = By.xpath("//div[contains(@class, 'tab_tab__1SPyG') and .//span[text()='Начинки']]");

    private final String ACTIVE_SECTION = "tab_tab_type_current__2BEPc";

    // Начинка Мясо бессмертных моллюсков Protostomia
    private final By fillingMeat = By.xpath(".//p[text() ='" + FILLING_MEAT + "']");

    // Соус Соус Spicy-X
    private final By sauceSpicy = By.xpath(".//p[text() ='" + SAUCE_SPICY + "']");

    // Булка Флюоресцентная булка R2-D3
    private final By bunFluorescent = By.xpath(".//p[text() ='" + BUN_FLUORESCENT + "']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Step("Нажать на кнопку 'Личный Кабинет' в заголовке")
    public void clickAccHeaderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(accHeaderButton));
        WebElement accHeaderBtn = driver.findElement(accHeaderButton);
        accHeaderBtn.click();
    }

    @Step("Нажать на кнопку 'Войти в аккаунт'")
    public void clickAccButton() {
        wait.until(ExpectedConditions.elementToBeClickable(accButton));
        WebElement accBtn = driver.findElement(accButton);
        accBtn.click();
    }

    @Step("Нажать на кнопку раздела 'Булки'")
    public void clickBunButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(bunButton));
        WebElement bunBtn = driver.findElement(bunButton);
        bunBtn.click();


    }

    @Step("Нажать на кнопку раздела 'Соусы'")
    public void clickSauceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sauceButton));
        WebElement sauceBtn = driver.findElement(sauceButton);
        sauceBtn.click();
    }

    @Step("Нажать на кнопку раздела 'Начинки'")
    public void clickFillingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(fillingButton));
        WebElement fillingBtn = driver.findElement(fillingButton);
        fillingBtn.click();
    }

    @Step("Получить текст кнопки 'Оформить заказ'")
    public String getTextOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        WebElement OrderBtn = driver.findElement(orderButton);
        return OrderBtn.getText();
    }

    @Step("Получить текст булки")
    public String getTextBun() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunFluorescent));
        WebElement bunTxt = driver.findElement(bunFluorescent);
        return bunTxt.getText();
    }

    @Step("Получить текст начинки")
    public String getTextFilling() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillingMeat));
        WebElement fillingTxt = driver.findElement(fillingMeat);
        return fillingTxt.getText();
    }

    @Step("Получить текст соуса")
    public String getTextSauce() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauceSpicy));
        WebElement sauceTxt = driver.findElement(sauceSpicy);
        return sauceTxt.getText();
    }

    @Step("Получить текущий URL")
    public String getTextActualUrl() {
        wait.until(ExpectedConditions.urlContains(MAIN_URL));
        return driver.getCurrentUrl();
    }

    @Step("Проверить, что раздел 'Булки' активен")
    public boolean isBunSectionActive() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunButton));
        WebElement bunElement = driver.findElement(bunButton);
        return bunElement.getAttribute("class").contains(ACTIVE_SECTION);
    }

    @Step("Проверить, что раздел 'Соусы' активен")
    public boolean isSauceSectionActive() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauceButton));
        WebElement sauceElement = driver.findElement(sauceButton);
        return sauceElement.getAttribute("class").contains(ACTIVE_SECTION);
    }

    @Step("Проверить, что раздел 'Начинки' активен")
    public boolean isFillingSectionActive() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillingButton));
        WebElement fillingElement = driver.findElement(fillingButton);
        return fillingElement.getAttribute("class").contains(ACTIVE_SECTION);
    }
}