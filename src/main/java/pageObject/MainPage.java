package pageObject;

import org.openqa.selenium.By;
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

    //Кнопка личный кабинет
    private final By accHeaderButton = By.xpath("//p[text() ='Личный Кабинет']");

    //Кнопка войти в аккаунт
    private final By accButton = By.xpath("//button[text() ='Войти в аккаунт']");

    //Кнопка оформить заказ
    private final By orderButton = By.xpath("//button[text() ='" + ORDER_BUTTON_TEXT + "']");

    //Кнопка булки
    private final By bunButton = By.xpath("//span[text() ='Булки']");

    //Кнопка Соусы
    private final By sauceButton = By.xpath("//span[text() ='Соусы']");

    //Кнопка Начинки
    private final By fillingButton = By.xpath("//span[text() ='Начинки']");

    //Начинка Мясо бессмертных моллюсков Protostomia
    private final By fillingMeat = By.xpath(".//p[text() ='" + FILLING_MEAT + "']");

    //Соус Соус Spicy-X
    private final By sauceSpicy = By.xpath(".//p[text() ='" + SAUCE_SPICY + "']");

    //Булка Флюоресцентная булка R2-D3
    private final By bunFluorescent = By.xpath(".//p[text() ='" + BUN_FLUORESCENT + "']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //метод для нажатия на кнопку Личный Кабинет
    public void clickAccHeaderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(accHeaderButton));
        WebElement accHeaderBtn = driver.findElement(accHeaderButton);
        accHeaderBtn.click();
    }

    //метод для нажатия на кнопку Личный Кабинет
    public void clickAccButton() {
        wait.until(ExpectedConditions.elementToBeClickable(accButton));
        WebElement accBtn = driver.findElement(accButton);
        accBtn.click();
    }

    //метод для нажатия на кнопку булки
    public void clickBunButton() {
        wait.until(ExpectedConditions.elementToBeClickable(bunButton));
        WebElement bunBtn = driver.findElement(bunButton);
        bunBtn.click();
    }

    //метод для нажатия на кнопку соусы
    public void clickSauceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sauceButton));
        WebElement sauceBtn = driver.findElement(sauceButton);
        sauceBtn.click();
    }

    //метод для нажатия на кнопку начинки
    public void clickFillingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(fillingButton));
        WebElement fillingBtn = driver.findElement(fillingButton);
        fillingBtn.click();
    }

    //метод для получения текста с кнопки Оформить заказ
    public String getTextOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        WebElement OrderBtn = driver.findElement(orderButton);
        return OrderBtn.getText();
    }

    public String getTextBun() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bunFluorescent));
        WebElement bunTxt = driver.findElement(bunFluorescent);
        return bunTxt.getText();
    }

    public String getTextFilling() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillingMeat));
        WebElement fillingTxt = driver.findElement(fillingMeat);
        return fillingTxt.getText();
    }

    public String getTextSauce() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauceSpicy));
        WebElement sauceTxt = driver.findElement(sauceSpicy);
        return sauceTxt.getText();
    }

    public String getTextActualUrl() {
        wait.until(ExpectedConditions.urlContains(MAIN_URL));
        return driver.getCurrentUrl();
    }
}