package ru.stqa.pft.addressbook.Tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
//это класс посредник
public class TestBase { //изчезает extends после делегирования

    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    //и создается ссылка (переменная app) на новый объект ApplicationManager
    //для доступа к другим классам
    //static для доступа фреймворка для все классов

    @BeforeSuite //анотация для запуска всего набора тестов
        public void setUp() throws Exception {
        app.init(); //создан новый метод
    }

    @AfterSuite
    public void tearDown() {
        app.stop(); //создан новый метод
    }
    }
