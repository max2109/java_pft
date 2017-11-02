package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
    FirefoxDriver wd;

    private SessHelper sessHelper;
    private NavHelepr navHelepr;
    private Helper helper;


    protected void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        helper = new Helper(wd);
        sessHelper = new SessHelper(wd);
        navHelepr = new NavHelepr(wd);
        sessHelper.login("admin", "secret");
    }

    protected void stop() {
        wd.quit();
    }

    public Helper getHelper() {
        return helper;
    }

    public NavHelepr getNavHelepr() {
        return navHelepr;
    }
}
