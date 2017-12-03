package com.pflb.learning.tests;

import com.pflb.learning.pages.YandexMainPage;
import com.pflb.learning.pages.YandexMarketPage;
import com.pflb.learning.utils.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Title;


import java.util.NoSuchElementException;

@Title("Go to Market Page")
public class YandexPageTest {
    YandexMainPage yandexMainPage;
    YandexMarketPage yandexMarketPage;

    /**
     * Переход на вкладку Ноутбуки в разделе Маркет
     */
    @Test
    @DisplayName("Go to Market Page")
    //@Step("Type {yandexMainPage.market}}")
    @Step("Click link 'Маркет'")
    @Severity(SeverityLevel.NORMAL)
    public void successGoToNotebooks() throws Exception {
        yandexMainPage = new YandexMainPage();
        //yandexMainPage.goToMarket();
        try {
            yandexMarketPage = yandexMainPage.goToMarket();
        } catch (NullPointerException e) {
            System.out.println("Экзмепляр класса,который вызывает метод не проинициализирован");
        } catch (NoSuchElementException e) {
            System.out.println("Элмент с заданным селектором на странице не найден");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass //Аннотация Junit. Говорит, что метод должен запускаться каждый раз после всех тестов
    public static void tearDown() {
        DriverManager.getDriver().quit();
    }
}
