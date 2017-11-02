package ru.stqa.pft.addressbook.Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.Tests.TestBase;
import ru.stqa.pft.addressbook.Tests.TestBasic;

import static org.openqa.selenium.OutputType.*;

public class ContactModificationTest3 extends TestBasic {


    @Test
    public void ContactModificationTest3() {

        goToHomePage();
        wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[12]/td[8]/a/img")).click();

        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys("maxdanydany");
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys("wax max max");
        wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();
        wd.findElement(By.linkText("home page")).click();
    }

}
