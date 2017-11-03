package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.appmanager.HelperBase;

public class NavHelper extends HelperBase{

    public NavHelper(WebDriver wd) {
        super(wd);
    }

    protected void gotoHomePage() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }
}
