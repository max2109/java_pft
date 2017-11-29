package ru.stqa.pft.addressbook.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import java.lang.reflect.Method;
import java.util.Arrays;

//это класс посредник
public class TestBase { //изчезает extends после делегирования

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    //и создается ссылка (переменная app) на новый объект ApplicationManager
    //для доступа к другим классам
    //static для доступа фреймворка для все классов

    @BeforeSuite //анотация для запуска всего набора тестов
        public void setUp() throws Exception {
        app.init(); //создан новый метод
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop(); //создан новый метод
    }


    @BeforeMethod
    public void logTestStart(Method m, Object[] p) {
        logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method m) {
        logger.info("Stop test " + m.getName());
    }

}