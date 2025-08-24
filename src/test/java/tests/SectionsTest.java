package tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObject.MainPage;

public class SectionsTest extends BaseTest {
    @Test
    @DisplayName("Проверка перехода к разделу Начинки")
    @Description("Base test for section")
    public void testFillingSection() {
        mainPage.clickFillingButton();
        actualResult = mainPage.getTextFilling();
        Assertions.assertEquals(MainPage.FILLING_MEAT, actualResult);
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    @Description("Base test for section")
    public void testSauceSection() {
        mainPage.clickSauceButton();
        actualResult = mainPage.getTextSauce();
        Assertions.assertEquals(MainPage.SAUCE_SPICY, actualResult);
    }

    @Test
    @DisplayName("Проверка перехода к разделу Булки")
    @Description("Base test for section")
    public void testBunSection() {
        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        actualResult = mainPage.getTextBun();
        Assertions.assertEquals(MainPage.BUN_FLUORESCENT, actualResult);
    }
}