package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBasic {

    protected final AppManager appman = new AppManager();

    @BeforeMethod
    public void setUp() throws Exception {
        appman.init();
    }

    @AfterMethod
    public void tearDown() {
        appman.stop();
    }

    public AppManager getAppman() {
        return appman;
    }
}
