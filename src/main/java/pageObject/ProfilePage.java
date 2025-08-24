package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public static final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final String INFO_TEXT = "В этом разделе вы можете изменить свои персональные данные";

    //Кнопка выход
    private final By exitButton = By.xpath("//button[text() ='Выход']");

    //Кнопка конструктор
    private final By constructorButton = By.xpath("//p[text() ='Конструктор']");

    //текст в углу
    private final By infoTextLocator = By.xpath("//p[text() ='" + INFO_TEXT + "']");

    //Кнопка лого
    private final By logoButton = By.className("AppHeader_header__logo__2D0X2");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //метод для нажатия на кнопку выход
    public void clickExitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(exitButton));
        WebElement exitBtn = driver.findElement(exitButton);
        exitBtn.click();
    }

    public String getInfoText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(infoTextLocator));
        WebElement infoTxt = driver.findElement(infoTextLocator);
        return infoTxt.getText();
    }

    //метод для нажатия на кнопку конструктор
    public void clickConstructorButton() {
        wait.until(ExpectedConditions.elementToBeClickable(constructorButton));
        WebElement constructorBtn = driver.findElement(constructorButton);
        constructorBtn.click();
    }

    //метод для нажатия на кнопку лого
    public void clickLogoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoButton));
        WebElement logoBtn = driver.findElement(logoButton);
        logoBtn.click();
    }
}