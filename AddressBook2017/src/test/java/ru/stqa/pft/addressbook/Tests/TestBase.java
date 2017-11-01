package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;


public class TestBase { //изчезает extends после делегирования

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    //и создается ссылка на новый объект ApplicationManager


    @BeforeMethod
    public void setUp() throws Exception {
        app.init(); //создан новый метод
    }

    @AfterMethod
    public void tearDown() {
        app.stop(); //создан новый метод
    }

    public ApplicationManager getApp() {
        return app;
    }
}
