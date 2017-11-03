package ru.stqa.pft.addressbook.Tests.ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessHelper extends HelperBasic{


    public SessHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.name("user"),username );
        type(By.name("pass"), password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }
}