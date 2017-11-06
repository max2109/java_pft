package ru.stqa.pft.addressbook.Tests;

        import org.testng.annotations.AfterMethod;
        import org.testng.annotations.AfterSuite;
        import org.testng.annotations.BeforeMethod;
        import org.testng.annotations.BeforeSuite;
        import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
        import org.openqa.selenium.remote.BrowserType;

public class TestBase { //изчезает extends после делегирования

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    //и создается ссылка на новый объект ApplicationManager

    @BeforeSuite
    public void setUp() throws Exception {
        app.init(); //создан новый метод
    }

    @AfterSuite
    public void tearDown() {
        app.stop(); //создан новый метод
    }
    }
