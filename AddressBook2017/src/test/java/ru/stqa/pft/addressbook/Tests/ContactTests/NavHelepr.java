package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.appmanager.HelperBase;

public class NavHelepr extends HelperBase{
    private FirefoxDriver wd;

    public NavHelepr(FirefoxDriver wd) {
        super(wd);
    }

    protected void goToHomePage() {
        click(By.linkText("home"));
    }
}
