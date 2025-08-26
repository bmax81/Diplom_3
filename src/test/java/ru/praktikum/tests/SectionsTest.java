package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

public class SectionsTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода к разделу Начинки")
    @Description("Проверка активации раздела Начинки через CSS класс")
    public void testFillingSection() {
        clickFillingButton();
        checkFillingSectionActive();
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    @Description("Проверка активации раздела Соусы через CSS класс")
    public void testSauceSection() {
        clickSauceButton();
        checkSauceSectionActive();
    }

    @Test
    @DisplayName("Проверка перехода к разделу Булки")
    @Description("Проверка активации раздела Булки через CSS класс")
    public void testBunSection() {
        // Переходим в другой раздел и возвращаемся к булкам
        clickFillingButton();
        checkFillingSectionActive();
        clickBunButton();
        checkBunSectionActive();
    }

    @Step("Нажать на кнопку раздела 'Начинки'")
    private void clickFillingButton() {
        mainPage.clickFillingButton();
    }

    @Step("Нажать на кнопку раздела 'Соусы'")
    private void clickSauceButton() {
        mainPage.clickSauceButton();
    }

    @Step("Нажать на кнопку раздела 'Булки'")
    private void clickBunButton() {
        mainPage.clickBunButton();
    }

    @Step("Проверить, что раздел 'Начинки' активен")
    private void checkFillingSectionActive() {
        boolean isFillingActive = mainPage.isFillingSectionActive();
        Assertions.assertTrue(isFillingActive, "Раздел Начинки должен быть активным");
    }

    @Step("Проверить, что раздел 'Соусы' активен")
    private void checkSauceSectionActive() {
        boolean isSauceActive = mainPage.isSauceSectionActive();
        Assertions.assertTrue(isSauceActive, "Раздел Соусы должен быть активным");
    }

    @Step("Проверить, что раздел 'Булки' активен")
    private void checkBunSectionActive() {
        boolean isBunActive = mainPage.isBunSectionActive();
        Assertions.assertTrue(isBunActive, "Раздел Булки должен быть активным");
    }
}