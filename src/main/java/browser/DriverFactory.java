package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    static String browserEnv = System.getenv("BROWSER");
    public static Browser browser = browserEnv == null ? Browser.CHROME : Browser.valueOf(browserEnv.toUpperCase());

    public static WebDriver getWebDriver() {
        return getWebDriver(browser);
    }

    public static WebDriver getWebDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case YANDEX: {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\holod\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(options);
            }
            default:
                throw new RuntimeException("Unknown browser: " + browser);
        }
    }
}